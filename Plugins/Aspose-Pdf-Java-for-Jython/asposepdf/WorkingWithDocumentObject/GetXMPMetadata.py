from asposepdf import Settings
from com.aspose.pdf import Document

class GetXMPMetadata:

    def __init__(self):
        dataDir = Settings.dataDir + 'WorkingWithDocumentObject/GetXMPMetadata/'
        
        # Open a pdf document.
        doc = Document(dataDir + "input1.pdf")

        # Get properties
        print "xmp:CreateDate: "
        print doc.getMetadata().get_Item("xmp:CreateDate")
        print "xmp:Nickname: "
        print doc.getMetadata().get_Item("xmp:Nickname")
        print "xmp:CustomProperty: "
        print doc.getMetadata().get_Item("xmp:CustomProperty")
 
if __name__ == '__main__':        
    GetXMPMetadata()