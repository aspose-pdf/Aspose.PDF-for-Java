from asposepdf import Settings
from com.aspose.pdf import Document
from com.aspose.pdf import JavascriptAction

class AddJavascript:

    def __init__(self):
        dataDir = Settings.dataDir + 'WorkingWithDocumentObject/AddJavascript/'
        
        # Open a pdf document.
        doc = Document(dataDir + "input1.pdf")

        # Adding JavaScript at Document Level
        # Instantiate JavascriptAction with desried JavaScript statement
        javaScript = JavascriptAction("this.print({bUI:true,bSilent:false,bShrinkToFit:true})")

        # Assign JavascriptAction object to desired action of Document
        doc.setOpenAction(javaScript)

        # Adding JavaScript at Page Level
        doc.getPages().get_Item(2).getActions().setOnOpen(JavascriptAction("app.alert('page 2 is opened')"))
        doc.getPages().get_Item(2).getActions().setOnClose(JavascriptAction("app.alert('page 2 is closed')"))

        # Save PDF Document
        doc.save(dataDir + "JavaScript-Added.pdf")

        print "Added JavaScript Successfully, please check the output file."
 
if __name__ == '__main__':        
    AddJavascript()