from asposepdf import Settings
from com.aspose.pdf import Document

class GetDocumentWindow:

    def __init__(self):
        dataDir = Settings.dataDir + 'WorkingWithDocumentObject/GetDocumentWindow/'
        
        # Open a pdf document.
        doc = Document(dataDir + "input1.pdf")

        # Get different document properties
        # Position of document's window - Default: false
        print "CenterWindow :- " 
        print doc.getCenterWindow()

        # Predominant reading order; determine the position of page
        # when displayed side by side - Default: L2R
        print "Direction :- " 
        print doc.getDirection()

        # Whether window's title bar should display document title.
        # If false, title bar displays PDF file name - Default: false
        print "DisplayDocTitle :- " 
        print doc.getDisplayDocTitle()

        #Whether to resize the document's window to fit the size of
        #first displayed page - Default: false
        print "FitWindow :- " 
        print doc.getFitWindow()

        # Whether to hide menu bar of the viewer application - Default: false
        print "HideMenuBar :-" 
        print doc.getHideMenubar()

        # Whether to hide tool bar of the viewer application - Default: false
        print "HideToolBar :-" 
        print doc.getHideToolBar()

        # Whether to hide UI elements like scroll bars
        # and leaving only the page contents displayed - Default: false
        print "HideWindowUI :-" 
        print doc.getHideWindowUI()

        # The document's page mode. How to display document on exiting full-screen mode.
        print "NonFullScreenPageMode :-" 
        print doc.getNonFullScreenPageMode()

        # The page layout i.e. single page, one column
        print "PageLayout :-" 
        print doc.getPageLayout()

        #How the document should display when opened.
        print "pageMode :-" 
        print doc.getPageMode()
 
if __name__ == '__main__':        
    GetDocumentWindow()