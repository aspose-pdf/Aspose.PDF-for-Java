require_relative 'asposepdfjava/version'
require_relative 'asposepdfjava/asposepdf'
require 'logger'
require 'yaml'

unless defined?(JRUBY_VERSION)
  raise LoadError, 'asposepdfjava requires JRuby because it uses Java integration directly.'
end

require 'java'

module Asposepdfjava

  class << self
    attr_accessor :aspose_pdf_config
  end

  def initialize_aspose_pdf
    Asposepdfjava.load_default_config

    aspose_jars_dir = Asposepdfjava.aspose_pdf_config ? Asposepdfjava.aspose_pdf_config['jar_dir'] : nil
    aspose_license_path = Asposepdfjava.aspose_pdf_config ? Asposepdfjava.aspose_pdf_config['license_path'] : nil
    jvm_args = Asposepdfjava.aspose_pdf_config ? Asposepdfjava.aspose_pdf_config['jvm_args'] : nil
    
    load_aspose_jars(aspose_jars_dir, jvm_args)
    load_aspose_license(aspose_license_path)
  end

  def load_aspose_license(aspose_license_path)
    if aspose_license_path && !aspose_license_path.empty?
      aspose_license_path = File.expand_path(aspose_license_path, File.expand_path('..', __dir__))
    end

    if aspose_license_path && File.exist?(aspose_license_path)
      set_license(File.join(aspose_license_path))
    else
      logger = Logger.new(STDOUT)
      logger.level = Logger::WARN
      logger.warn('Using the non licensed aspose jar. Please specify path to your aspose license directory in config/aspose.yml file!')
    end
  end

  def load_aspose_jars(aspose_jars_dir, jvm_args)
    repo_root = File.expand_path('..', __dir__)
    aspose_jars_dir = File.expand_path(aspose_jars_dir, repo_root) if aspose_jars_dir

    if aspose_jars_dir && File.exist?(aspose_jars_dir)
      jardir = File.join(aspose_jars_dir, '**', '*.jar')
    else
      jardir = File.join(File.dirname(File.dirname(__FILE__)), 'jars', '**', '*.jar')
    end

    Asposepdfjava.java_class('java.lang.System').setProperty('java.awt.headless', 'true')
    if jvm_args && !jvm_args.empty?
      logger = Logger.new(STDOUT)
      logger.level = Logger::DEBUG
      logger.debug("JVM args must be passed when starting JRuby: #{jvm_args}")
    end

    Dir.glob(jardir).each { |jar| require jar }
  end

  def input_file(file)
    Asposepdfjava.java_class('java.io.FileInputStream').new(file)
  end

  def set_license(aspose_license_file)
    begin
      fstream = input_file(aspose_license_file)
      license = Asposepdfjava.java_class('com.aspose.pdf.License').new
      license.setLicense(fstream)
    rescue StandardError => ex
      logger = Logger.new(STDOUT)
      logger.level = Logger::ERROR
      logger.error("Could not load the license file : #{ex}")
    ensure
      fstream.close() if fstream
    end
  end

  def self.configure_aspose_pdf(config)
    Asposepdfjava.aspose_pdf_config = config
  end

  def self.load_default_config
    return if aspose_pdf_config

    config_file = File.expand_path('../config/aspose.yml', __dir__)
    self.aspose_pdf_config = File.exist?(config_file) ? YAML.load_file(config_file) : {}
  end

  def self.java_class(class_name)
    @java_classes ||= {}
    @java_classes[class_name] ||= begin
      JavaUtilities.get_proxy_class(class_name)
    rescue NameError
      owner_name, _separator, member_name = class_name.rpartition('.')
      owner = java_class(owner_name)

      if owner.respond_to?(member_name)
        owner.public_send(member_name)
      elsif owner.respond_to?(:const_defined?) && owner.const_defined?(member_name, false)
        owner.const_get(member_name)
      else
        java_class('java.lang.Class').forName(owner_name).getField(member_name).get(nil)
      end
    end
  end

end
