from asposepdf import Settings
from com.aspose.pdf import Document
from com.aspose.pdf import TextFragment
from com.aspose.pdf import Position
from com.aspose.pdf import FontRepository
from com.aspose.pdf import TextBuilder


class AddText:

    def __init__(self):
        
        dataDir = Settings.dataDir + 'WorkingWithText/AddText/'
        
        # Instantiate Document object
        doc = Document(dataDir + 'input1.pdf')

        # get particular page
        pdf_page = doc.getPages().get_Item(1)

        # create text fragment
        text_fragment = TextFragment("main text")
        text_fragment.setPosition(Position(100, 600))


        font_repository = FontRepository()

        # set text properties
        text_fragment.getTextState().setFont(font_repository.findFont("Verdana"))
        text_fragment.getTextState().setFontSize(14)

        # create TextBuilder object
        text_builder = TextBuilder(pdf_page)

        # append the text fragment to the PDF page
        text_builder.appendText(text_fragment)

        # Save PDF file
        doc.save(dataDir + "Text_Added.pdf")

        print "Text added successfully"
 
if __name__ == '__main__':        
    AddText()