from asposepdf import Settings
from com.aspose.pdf import Document
from com.aspose.pdf import SvgSaveOptions

class PdfToSvg:

    def __init__(self):
        dataDir = Settings.dataDir + 'WorkingWithDocumentConversion/PdfToSvg/'
        
        # Open the target document
        pdf = Document(dataDir + 'input1.pdf');

        # instantiate an object of SvgSaveOptions
        save_options = SvgSaveOptions();

        # do not compress SVG image to Zip archive
        save_options.CompressOutputToZipArchive = False;

        # Save the output to XLS format
        pdf.save(dataDir + "Output.svg", save_options);

        print "Document has been converted successfully"
 
if __name__ == '__main__':        
    PdfToSvg()