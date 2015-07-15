module Asposepdfjava
  module GetPage
    def initialize()
    	# The path to the documents directory.
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'
                
        # Open the target document
        pdf = Rjb::import('com.aspose.pdf.Document').new(data_dir + 'input1.pdf')

        # get the page at particular index of Page Collection
        pdf_page = pdf.getPages().get_Item(1)

        # create a new Document object
        new_document = Rjb::import('com.aspose.pdf.Document').new

        # add page to pages collection of new document object
        new_document.getPages().add(pdf_page)

        # save the newly generated PDF file
        new_document.save(data_dir + "output.pdf")

        puts "Process completed successfully!"
    end
  end
end
