from asposepdf import Settings
from com.aspose.pdf import Document
from com.aspose.pdf import HtmlFragment
from com.aspose.pdf import MarginInfo


class AddHtml:

    def __init__(self):
        
        dataDir = Settings.dataDir + 'WorkingWithText/AddHtml/'
        
        # Instantiate Document object
        doc = Document()

        # Add a page to pages collection of PDF file
        page = doc.getPages().add()

        # Instantiate HtmlFragment with HTML contents
        title = HtmlFragment("<fontsize=10><b><i>Table</i></b></fontsize>")

        # set MarginInfo for margin details
        margin = MarginInfo()
        margin.setBottom(10)
        margin.setTop(200)

        # Set margin information
        title.setMargin(margin)

        # Add HTML Fragment to paragraphs collection of page
        page.getParagraphs().add(title)

        # Save PDF file
        doc.save(dataDir + "html.output.pdf")

        print "HTML added successfully"
 
if __name__ == '__main__':        
    AddHtml()