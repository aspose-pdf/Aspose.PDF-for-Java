module Asposepdfjava
  module InsertEmptyPage
    def initialize()
    	# The path to the documents directory.
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'
                
        # Open the target document
        pdf = Rjb::import('com.aspose.pdf.Document').new(data_dir + 'input1.pdf')

        # insert a empty page in a PDF
        pdf.getPages().insert(1)

        # Save the concatenated output file (the target document)
        pdf.save(data_dir+ "output.pdf")

        puts "Empty page added successfully!"
    end
  end
end
