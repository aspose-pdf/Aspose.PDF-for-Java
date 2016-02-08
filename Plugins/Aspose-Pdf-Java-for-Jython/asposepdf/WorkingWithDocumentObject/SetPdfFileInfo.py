from asposepdf import Settings
from com.aspose.pdf import Document
from java.util import Date


class SetPdfFileInfo:

    def __init__(self):
        
        dataDir = Settings.dataDir + 'WorkingWithDocumentObject/SetPdfFileInfo/'
        
        # Open a pdf document.
        doc = Document(dataDir + "input1.pdf")

        # Get document information
        doc_info = doc.getInfo()

        doc_info.setAuthor("Aspose.Pdf for java")
        doc_info.setCreationDate(Date())
        doc_info.setKeywords("Aspose.Pdf, DOM, API")
        doc_info.setModDate(Date())
        doc_info.setSubject("PDF Information")
        doc_info.setTitle("Setting PDF Document Information")

        # save update document with information
        doc.save(dataDir + "Updated_Information.pdf")

        print "Update document information, please check output file."
 
if __name__ == '__main__':        
    SetPdfFileInfo()