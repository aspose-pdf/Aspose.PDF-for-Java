# coding: utf-8
lib = File.expand_path('../lib', __FILE__)
$LOAD_PATH.unshift(lib) unless $LOAD_PATH.include?(lib)
require 'asposepdfjava/version'

Gem::Specification.new do |spec|
  spec.name          = 'asposepdfjava'
  spec.version       = Asposepdfjava::VERSION
  spec.authors       = ['Aspose Marketplace']
  spec.email         = ['marketplace@aspose.com']
  spec.summary       = %q{A Ruby gem to work with Aspose.Pdf libraries}
  spec.description   = %q{AsposePdfJava is a Ruby gem that can help working with Aspose.Pdf libraries}
  spec.homepage      = 'https://github.com/aspose-pdf/Aspose.PDF-for-Java/tree/master/plugins/Aspose_Pdf_Java_for_Ruby'
  spec.license       = 'MIT'
  spec.required_ruby_version = '>= 3.1'
  spec.platform      = 'java'

  spec.files         = `git ls-files`.split($/).select { |file| File.file?(file) }
  spec.executables   = spec.files.grep(%r{^bin/}) { |f| File.basename(f) }
  spec.require_paths = ['lib']

  spec.add_development_dependency 'bundler', '~> 2.4'
  spec.add_development_dependency 'rake', '~> 13.0'
  spec.add_development_dependency 'rspec', '~> 3.13'

end
