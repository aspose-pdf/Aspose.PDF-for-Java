from asposepdf import Settings
from com.aspose.pdf import Document
from java.util import Date


class GetPageProperties:

    def __init__(self):
        
        dataDir = Settings.dataDir + 'WorkingWithPages/GetPageProperties/'

        # Create PDF document
        pdf_document = Document(dataDir + 'input1.pdf');

        # get page collection
        page_collection =pdf_document.getPages();

        # get particular page
        pdf_page =page_collection.get_Item(1);

        #get page properties
        print "ArtBox : Height = " 
        print pdf_page.getArtBox().getHeight()
        print ", Width = " 
        print pdf_page.getArtBox().getWidth()
        print ", LLX = " 
        print pdf_page.getArtBox().getLLX()
        print ", LLY = "
        print pdf_page.getArtBox().getLLY()
        print ", URX = " 
        print pdf_page.getArtBox().getURX() 
        print ", URY = " 
        print pdf_page.getArtBox().getURY()
        
        
        print "BleedBox : Height = " 
        print pdf_page.getBleedBox().getHeight() 
        print ", Width = " 
        print pdf_page.getBleedBox().getWidth()
        print ", LLX = " 
        print pdf_page.getBleedBox().getLLX() 
        print ", LLY = " 
        print pdf_page.getBleedBox().getLLY() 
        print ", URX = " 
        print pdf_page.getBleedBox().getURX()
        print ", URY = " 
        print pdf_page.getBleedBox().getURY()
        
        
        print "CropBox : Height = " 
        print pdf_page.getCropBox().getHeight() 
        print ", Width = " 
        print pdf_page.getCropBox().getWidth() 
        print ", LLX = " 
        print pdf_page.getCropBox().getLLX() 
        print ", LLY = " 
        print pdf_page.getCropBox().getLLY() 
        print ", URX = " 
        print pdf_page.getCropBox().getURX() 
        print ", URY = " 
        print pdf_page.getCropBox().getURY()
        
        
        print "MediaBox : Height = " 
        print pdf_page.getMediaBox().getHeight() 
        print ", Width = " 
        print pdf_page.getMediaBox().getWidth() 
        print ", LLX = "
        print pdf_page.getMediaBox().getLLX() 
        print ", LLY = " 
        print pdf_page.getMediaBox().getLLY() 
        print ", URX = " 
        print pdf_page.getMediaBox().getURX() 
        print ", URY = " 
        print pdf_page.getMediaBox().getURY()
        
        print "TrimBox : Height = " 
        print pdf_page.getTrimBox().getHeight()
        print ", Width = "
        print pdf_page.getTrimBox().getWidth() 
        print ", LLX = " 
        print pdf_page.getTrimBox().getLLX() 
        print ", LLY = " 
        print pdf_page.getTrimBox()
        print getLLY() 
        print ", URX = " 
        print pdf_page.getTrimBox().getURX() 
        print ", URY = " 
        print pdf_page.getTrimBox().getURY()
        
        
        print "Rect : Height = "
        print pdf_page.getRect().getHeight() 
        print ", Width = " 
        print pdf_page.getRect().getWidth()
        print ", LLX = "
        print pdf_page.getRect().getLLX()
        print ", LLY = " 
        print pdf_page.getRect().getLLY()
        print ", URX = " 
        print pdf_page.getRect().getURX()
        print ", URY = " +pdf_page.getRect().getURY()
        
        
        print "Page Number :"
        print pdf_page.getNumber()
        print "Rotate :" 
        print pdf_page.getRotate()
 
if __name__ == '__main__':        
    GetPageProperties()