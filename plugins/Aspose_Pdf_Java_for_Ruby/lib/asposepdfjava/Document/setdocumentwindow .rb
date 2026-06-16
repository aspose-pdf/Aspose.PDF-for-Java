module Asposepdfjava
  module SetDocumentWindow
    def initialize()
    	# The path to the documents directory.
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'
        
        # Open a pdf document.
        doc = Rjb::import('com.aspose.pdf.Document').new(data_dir + "input1.pdf")

        # Set different document properties
        # Position of document's window - Default: false
        doc.setCenterWindow(true)

        # Predominant reading order; determine the position of page
        # when displayed side by side - Default: L2R
        #doc.setDirection(Rjb::import('com.aspose.pdf.Direction.L2R'))

        # Whether window's title bar should display document title.
        # If false, title bar displays PDF file name - Default: false
        doc.setDisplayDocTitle(true)

        # Whether to resize the document's window to fit the size of
        # first displayed page - Default: false
        doc.setFitWindow(true)

        # Whether to hide menu bar of the viewer application - Default: false
        doc.setHideMenubar(true)

        # Whether to hide tool bar of the viewer application - Default: false
        doc.setHideToolBar(true)

        # Whether to hide UI elements like scroll bars
        # and leaving only the page contents displayed - Default: false
        doc.setHideWindowUI(true)

        # The document's page mode. How to display document on exiting full-screen mode.
        doc.setNonFullScreenPageMode(Rjb::import('com.aspose.pdf.PageMode.UseOC'))

        # The page layout i.e. single page, one column
        doc.setPageLayout(Rjb::import('com.aspose.pdf.PageLayout.TwoColumnLeft'))

        #How the document should display when opened.
        doc.setPageMode()

        # Save updated PDF file
        doc.save(data_dir + "Set Document Window.pdf")
    end
  end
end
