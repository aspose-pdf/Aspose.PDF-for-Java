from asposepdf import Settings
from com.aspose.pdf import Document
from java.util import Date


class SplitAllPages:

    def __init__(self):
        
        dataDir = Settings.dataDir + 'WorkingWithPages/SplitAllPages/'
        
        # Open the target document
        pdf = Document(dataDir + 'input1.pdf')

        # loop through all the pages
        pdf_page = 1
        total_size = pdf.getPages().size()
        
        while pdf_page <= total_size:

            # create a new Document object
            new_document = Document()

            # get the page at particular index of Page Collection
            new_document.getPages().add(pdf.getPages().get_Item(pdf_page))

            # save the newly generated PDF file
            new_document.save(dataDir + "page_#{pdf_page}.pdf")

            pdf_page+=1
       
        print "Split process completed successfully!"
 
if __name__ == '__main__':        
    SplitAllPages()