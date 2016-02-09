from asposepdf import Settings
from com.aspose.pdf import Document
from java.util import Date


class GetNumberOfPages:

    def __init__(self):
        
        dataDir = Settings.dataDir + 'WorkingWithPages/GetNumberOfPages/'
        
        # Create PDF document
        pdf = Document(dataDir + 'input1.pdf')

        page_count = pdf.getPages().size()

        print "Page Count:"
        print page_count
 
if __name__ == '__main__':        
    GetNumberOfPages()