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
  spec.homepage      = 'https://github.com/asposepdf/Aspose_Pdf_Java/tree/master/Plugins/Aspose_Pdf_Java_for_Ruby'
  spec.license       = 'MIT'

spec.files         = `git ls-files`.split($/)
  spec.executables   = spec.files.grep(%r{^bin/}) { |f| File.basename(f) }
  spec.test_files    = spec.files.grep(%r{^(test|spec|features)/})
spec.require_paths = ['lib']

  spec.add_development_dependency 'bundler', '~> 1.7'
  spec.add_development_dependency 'rake', '~> 10.0'
  spec.add_development_dependency 'rspec'

  spec.add_dependency 'rjb', '~> 1.5.2'

end
