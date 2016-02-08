from asposepdf import Settings
from com.aspose.pdf import Document
from java.util import Date


class InsertEmptyPage:

    def __init__(self):
        
        dataDir = Settings.dataDir + 'WorkingWithPages/InsertEmptyPage/'
        
        # Open the target document
        pdf = Document(dataDir + 'input1.pdf')

        # insert a empty page in a PDF
        pdf.getPages().insert(1)

        # Save the concatenated output file (the target document)
        pdf.save(dataDir + "output.pdf")

        print "Empty page added successfully!"
 
if __name__ == '__main__':        
    InsertEmptyPage()