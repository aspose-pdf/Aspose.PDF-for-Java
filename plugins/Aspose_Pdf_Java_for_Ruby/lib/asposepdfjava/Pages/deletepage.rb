module Asposepdfjava
  module DeletePage
    def initialize()
    	# The path to the documents directory.
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'
                
        # Open the target document
        pdf = Rjb::import('com.aspose.pdf.Document').new(data_dir + 'input1.pdf')

        # delete a particular page
        pdf.getPages().delete(2)

        # save the newly generated PDF file
        pdf.save(data_dir + "output.pdf")

        puts "Page deleted successfully!"
    end
  end
end
