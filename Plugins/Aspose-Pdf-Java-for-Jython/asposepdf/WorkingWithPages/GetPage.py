from asposepdf import Settings
from com.aspose.pdf import Document
from java.util import Date


class GetPage:

    def __init__(self):
        
        dataDir = Settings.dataDir + 'WorkingWithPages/GetPage/'
        
        # Open the target document
        pdf = Document(dataDir + 'input1.pdf')

        # get the page at particular index of Page Collection
        pdf_page = pdf.getPages().get_Item(1)

        # create a Document object
        new_document = Document()

        # add page to pages collection of document object
        new_document.getPages().add(pdf_page)

        # save the newly generated PDF file
        new_document.save(dataDir + "output.pdf")

        print "Process completed successfully!"
 
if __name__ == '__main__':        
    GetPage()