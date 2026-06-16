module Asposepdfjava
  module ConcatenatePdfFiles
    def initialize()
    	# The path to the documents directory.
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'
                
        # Open the target document
        pdf1 = Rjb::import('com.aspose.pdf.Document').new(data_dir + 'input1.pdf')

        # Open the source document
        pdf2 = Rjb::import('com.aspose.pdf.Document').new(data_dir + 'input2.pdf')
        
        # Add the pages of the source document to the target document
        pdf1.getPages().add(pdf2.getPages())

        # Save the concatenated output file (the target document)
        pdf1.save(data_dir+ "Concatenate_output.pdf")

        puts "New document has been saved, please check the output file"
    end
  end
end
