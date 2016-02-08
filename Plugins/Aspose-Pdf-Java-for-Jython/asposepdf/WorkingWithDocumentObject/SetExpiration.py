from asposepdf import Settings
from com.aspose.pdf import Document
from com.aspose.pdf import JavascriptAction

class SetExpiration:

    def __init__(self):
       self.optimize_web()
       
    def optimize_web(dataDir):
        
        dataDir = Settings.dataDir + 'WorkingWithDocumentObject/SetExpiration/'
        
        # Open a pdf document.
        doc = Document(dataDir + "input1.pdf")

        javascript = JavascriptAction(
                "var year=2014;" "var month=4;" "today = new Date();"
                "today = new Date(today.getFullYear(), today.getMonth());"
                "expiry = new Date(year, month);"
                "if (today.getTime() > expiry.getTime())"
                "app.alert('The file is expired. You need a new one.');"
                )
                    
        doc.setOpenAction(javascript)

        # save update document with information
        doc.save(dataDir + "set_expiration.pdf")

        print "Update document information, please check output file."
 
if __name__ == '__main__':        
    SetExpiration()