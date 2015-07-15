module Asposepdfjava
  module UpdatePageDimensions
    def initialize()
    	# The path to the documents directory.
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'
                
        # Open the target document
        pdf = Rjb::import('com.aspose.pdf.Document').new(data_dir + 'input1.pdf')

        # get page collection
        page_collection = pdf.getPages()

        # get particular page
        pdf_page = page_collection.get_Item(1)

        # set the page size as A4 (11.7 x 8.3 in) and in Aspose.Pdf, 1 inch = 72 points
        # so A4 dimensions in points will be (842.4, 597.6)
        pdf_page.setPageSize(597.6,842.4)

        # save the newly generated PDF file
        pdf.save(data_dir + "output.pdf")

        puts "Dimensions updated successfully!"
    end
  end
end
