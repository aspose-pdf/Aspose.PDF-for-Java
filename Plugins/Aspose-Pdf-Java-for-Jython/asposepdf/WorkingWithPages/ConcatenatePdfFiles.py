from asposepdf import Settings
from com.aspose.pdf import Document
from java.util import Date


class ConcatenatePdfFiles:

    def __init__(self):
        
        dataDir = Settings.dataDir + 'WorkingWithPages/ConcatenatePdfFiles/'
        
        # Open the target document
        pdf1 = Document(dataDir + 'input1.pdf')

        # Open the source document
        pdf2 = Document(dataDir + 'input2.pdf')
        
        # Add the pages of the source document to the target document
        pdf1.getPages().add(pdf2.getPages())

        # Save the concatenated output file (the target document)
        pdf1.save(dataDir + "Concatenate_output.pdf")

        print "New document has been saved, please check the output file"
 
if __name__ == '__main__':        
    ConcatenatePdfFiles()