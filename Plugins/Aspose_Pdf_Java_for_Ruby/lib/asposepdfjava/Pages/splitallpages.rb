module Asposepdfjava
  module SplitAllPages
    def initialize()
    	# The path to the documents directory.
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'
                
        # Open the target document
        pdf = Rjb::import('com.aspose.pdf.Document').new(data_dir + 'input1.pdf')

        # loop through all the pages
        pdf_page = 1
        #for (int pdfPage = 1; pdfPage<= pdfDocument1.getPages().size(); pdfPage++)
        while pdf_page <= pdf.getPages().size()
            # create a new Document object
            new_document = Rjb::import('com.aspose.pdf.Document').new
            
            # get the page at particular index of Page Collection
            new_document.getPages().add(pdf.getPages().get_Item(pdf_page))
            
            # save the newly generated PDF file
            new_document.save(data_dir + "page_#{pdf_page}.pdf")

            pdf_page +=1
        end

        puts "Split process completed successfully!"
    end
  end
end
