from asposepdf import Settings
from com.aspose.pdf import Document
from com.aspose.pdf import SvgLoadOptions

class SvgToPdf:

    def __init__(self):
        dataDir = Settings.dataDir + 'WorkingWithDocumentConversion/SvgToPdf/'
        
        # Instantiate LoadOption object using SVG load option
        options = SvgLoadOptions()

        # Create document object
        pdf = Document(dataDir + 'Example.svg', options)

        # Save the output to XLS format
        pdf.save(dataDir + "SVG.pdf")

        print "Document has been converted successfully"
 
if __name__ == '__main__':        
    SvgToPdf()