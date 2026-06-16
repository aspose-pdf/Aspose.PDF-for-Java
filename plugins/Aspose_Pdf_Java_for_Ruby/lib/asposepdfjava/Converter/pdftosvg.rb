module Asposepdfjava
  module PdfToSvg
    def initialize()
    	# The path to the documents directory.
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'
                
        # Open the target document
        pdf = Rjb::import('com.aspose.pdf.Document').new(data_dir + 'input1.pdf')

        # instantiate an object of SvgSaveOptions
        save_options = Rjb::import('com.aspose.pdf.SvgSaveOptions').new

        # do not compress SVG image to Zip archive
        save_options.CompressOutputToZipArchive = false

        # Save the output to XLS format
        pdf.save(data_dir + "Output.svg", save_options)

        puts "Document has been converted successfully"
    end
  end
end
