from asposepdf import Settings
from com.aspose.pdf import Document
from com.aspose.pdf import TextAbsorber
from java.io import FileWriter
from java.io import File



class ExtractTextFromAllPages:

    def __init__(self):
        
        dataDir = Settings.dataDir + 'WorkingWithText/ExtractTextFromAllPages/'
        
        # Open the target document
        pdf = Document(dataDir + 'input1.pdf')

        # create TextAbsorber object to extract text
        text_absorber = TextAbsorber()

        # accept the absorber for all the pages
        pdf.getPages().accept(text_absorber)

        # In order to extract text from specific page of document, we need to specify the particular page using its index against accept(..) method.
        # accept the absorber for particular PDF page
        # pdfDocument.getPages().get_Item(1).accept(textAbsorber)

        #get the extracted text
        extracted_text = text_absorber.getText()

        # create a writer and open the file
        writer = FileWriter(File(dataDir + "extracted_text.out.txt"))
        writer.write(extracted_text)
        # write a line of text to the file
        # tw.WriteLine(extractedText)
        # close the stream
        writer.close()

        print "Text extracted successfully. Check output file."
 
if __name__ == '__main__':        
    ExtractTextFromAllPages()