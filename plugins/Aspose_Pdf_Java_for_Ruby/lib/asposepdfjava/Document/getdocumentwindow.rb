module Asposepdfjava
  module GetDocumentWindow
    def initialize()
    	# The path to the documents directory.
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'
        
        # Open a pdf document.
        doc = Rjb::import('com.aspose.pdf.Document').new(data_dir + "input1.pdf")

        # Get different document properties
        # Position of document's window - Default: false
        puts "CenterWindow :- " + doc.getCenterWindow().to_s

        # Predominant reading order; determine the position of page
        # when displayed side by side - Default: L2R
        puts "Direction :- " + doc.getDirection().to_s

        # Whether window's title bar should display document title.
        # If false, title bar displays PDF file name - Default: false
        puts "DisplayDocTitle :- " + doc.getDisplayDocTitle().to_s

        #Whether to resize the document's window to fit the size of
        #first displayed page - Default: false
        puts "FitWindow :- " + doc.getFitWindow().to_s

        # Whether to hide menu bar of the viewer application - Default: false
        puts "HideMenuBar :-" + doc.getHideMenubar().to_s

        # Whether to hide tool bar of the viewer application - Default: false
        puts "HideToolBar :-" + doc.getHideToolBar().to_s

        # Whether to hide UI elements like scroll bars
        # and leaving only the page contents displayed - Default: false
        puts "HideWindowUI :-" + doc.getHideWindowUI().to_s

        # The document's page mode. How to display document on exiting full-screen mode.
        puts "NonFullScreenPageMode :-" + doc.getNonFullScreenPageMode().to_s

        # The page layout i.e. single page, one column
        puts "PageLayout :-" + doc.getPageLayout().to_s

        #How the document should display when opened.
        puts "pageMode :-" + doc.getPageMode().to_s
    end
  end
end
