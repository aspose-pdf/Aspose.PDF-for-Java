from asposepdf import Settings
from com.aspose.pdf import Document

class GetPdfFileInfo:

    def __init__(self):
        dataDir = Settings.dataDir + 'WorkingWithDocumentObject/GetPdfFileInfo/'
        
        # Open a pdf document.
        doc = Document(dataDir + "input1.pdf")

        # Get document information
        doc_info = doc.getInfo()

        # Show document information
        print "Author:"
        print doc_info.getAuthor()
        print "Creation Date:"
        print doc_info.getCreationDate()
        print "Keywords:"
        print doc_info.getKeywords()
        print "Modify Date:"
        print doc_info.getModDate()
        print "Subject:"
        print doc_info.getSubject()
        print "Title:"
        print doc_info.getTitle()
 
if __name__ == '__main__':        
    GetPdfFileInfo()