module Asposepdfjava
  module PdfToDoc
    def initialize()
    	# The path to the documents directory.
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'
                
        # Open the target document
        pdf = Rjb::import('com.aspose.pdf.Document').new(data_dir + 'input1.pdf')

        # Save the concatenated output file (the target document)
        pdf.save(data_dir+ "output.doc")

        puts "Document has been converted successfully"
    end
  end
end
