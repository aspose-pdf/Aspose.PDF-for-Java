from asposepdf import Settings
from com.aspose.pdf import Document
from java.util import Date


class DeletePage:

    def __init__(self):
        
        dataDir = Settings.dataDir + 'WorkingWithPages/DeletePage/'
        
        # Open the target document
        pdf = Document(dataDir + 'input1.pdf')

        # delete a particular page
        pdf.getPages().delete(2)

        # save the newly generated PDF file
        pdf.save(dataDir + "output.pdf")

        print "Page deleted successfully!"
 
if __name__ == '__main__':        
    DeletePage()