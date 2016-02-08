from asposepdf import Settings
from com.aspose.pdf import Document
from com.aspose.pdf import ExcelSaveOptions

class PdfToExcel:

    def __init__(self):
        dataDir = Settings.dataDir + 'WorkingWithDocumentConversion/PdfToExcel/'
        
        # Open the target document
        pdf = Document(dataDir + 'input1.pdf')

        # Instantiate ExcelSave Option object
        excelsave = ExcelSaveOptions()

        # Save the output to XLS format
        pdf.save(dataDir + "Converted_Excel.xls", excelsave)

        print "Document has been converted successfully"
 
if __name__ == '__main__':        
    PdfToExcel()