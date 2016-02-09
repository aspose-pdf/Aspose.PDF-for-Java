from asposepdf import Settings
from com.aspose.pdf import Document
from com.aspose.pdf.Document import OptimizationOptions

class Optimize:

    def __init__(self):
       self.optimize_web()
       
    def optimize_web(dataDir):
        
        dataDir = Settings.dataDir + 'WorkingWithDocumentObject/Optimize/'
        
        # Open a pdf document.
        doc = Document(dataDir + "input1.pdf")

        # Optimize for web
        doc.optimize()

        #Save output document
        doc.save(dataDir + "Optimized_Web.pdf")

        print "Optimized PDF for the Web, please check output file."
 
if __name__ == '__main__':        
    Optimize()