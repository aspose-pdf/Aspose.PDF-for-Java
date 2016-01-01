__author__ = 'fahadadeel'
import jpype
import re
import datetime

class AddJavascript:
    def __init__(self, dataDir):
        self.dataDir = dataDir
        self.Document = jpype.JClass("com.aspose.pdf.Document")
        self.JavascriptAction=jpype.JClass("com.aspose.pdf.JavascriptAction")

    def main(self):

        # Open a pdf document.
        doc= self.Document()
        pdf = self.Document()
        pdf=self.dataDir + 'Template.pdf'


        # Adding JavaScript at Document Level
        # Instantiate JavascriptAction with desried JavaScript statement
        javaScript = self.JavascriptAction("this.print({bUI:true,bSilent:false,bShrinkToFit:true});");

        # Assign JavascriptAction object to desired action of Document
        doc.setOpenAction(javaScript)
        js=self.JavascriptAction("app.alert('page 2 is opened')")

        # Adding JavaScript at Page Level
        doc.getPages.get_Item(2)
        doc.getActions().setOnOpen(js())
        doc.getPages().get_Item(2).getActions().setOnClose(self.JavascriptAction("app.alert('page 2 is closed')"))

        # Save PDF Document
        doc.save(self.dataDir + "JavaScript-Added.pdf")

        print "Added JavaScript Successfully, please check the output file."

class AddToc:
    def __init__(self, dataDir):
        self.dataDir = dataDir
        self.Document = jpype.JClass("com.aspose.pdf.Document")
        self.TocInfo=jpype.JClass("com.aspose.pdf.TocInfo")
        self.TextFragment=jpype.JClass("com.aspose.pdf.TextFragment")
        self.TextSegment=jpype.JClass("com.aspose.pdf.TextSegment")
        self.Heading=jpype.JClass("com.aspose.pdf.Heading")

    def main(self):
        # Open a pdf document.
        doc= self.Document()
        pdf = self.Document()
        pdf=self.dataDir + 'input1.pdf'

        # Get access to first page of PDF file
        toc_page = doc.getPages().insert(1)

        # Create object to represent TOC information
        toc_info = self.TocInfo()
        title = self.TextFragment("Table Of Contents")
        title.getTextState().setFontSize(20)

        # Set the title for TOC
        toc_info.setTitle(title)
        toc_page.setTocInfo(toc_info)

        # Create string objects which will be used as TOC elements
        titles = ["First page", "Second page"]

        i = 0;
        while (i < 2):
            # Create Heading object
            heading2 = self.Heading(1);

            segment2 = self.TextSegment
            heading2.setTocPage(toc_page)
            heading2.getSegments().add(segment2)

            # Specify the destination page for heading object
            heading2.setDestinationPage(doc.getPages().get_Item(i + 2))

            # Destination page
            heading2.setTop(doc.getPages().get_Item(i + 2).getRect().getHeight())

            # Destination coordinate
            segment2.setText(titles[i])

            # Add heading to page containing TOC
            toc_page.getParagraphs().add(heading2)

            i +=1;


        # Save PDF Document
        doc.save(self.dataDir + "TOC.pdf")

        print "Added TOC Successfully, please check the output file."

class GetDocumentWindow:
    def __init__(self, dataDir):
        self.dataDir = dataDir
        self.Document = jpype.JClass("com.aspose.pdf.Document")

    def main(self):

        doc= self.Document()
        pdf = self.Document()
        pdf=self.dataDir + 'input1.pdf'

        # Get different document properties
        # Position of document's window - Default: false
        print "CenterWindow :- " + str(doc.getCenterWindow())

        # Predominant reading order; determine the position of page
        # when displayed side by side - Default: L2R
        print "Direction :- " + str(doc.getDirection())

        # Whether window's title bar should display document title.
        # If false, title bar displays PDF file name - Default: false
        print "DisplayDocTitle :- " + str(doc.getDisplayDocTitle())

        #Whether to resize the document's window to fit the size of
        #first displayed page - Default: false
        print "FitWindow :- " + str(doc.getFitWindow())

        # Whether to hide menu bar of the viewer application - Default: false
        print "HideMenuBar :-" + str(doc.getHideMenubar())

        # Whether to hide tool bar of the viewer application - Default: false
        print "HideToolBar :-" + str(doc.getHideToolBar())

        # Whether to hide UI elements like scroll bars
        # and leaving only the page contents displayed - Default: false
        print "HideWindowUI :-" + str(doc.getHideWindowUI())

        # The document's page mode. How to display document on exiting full-screen mode.
        print "NonFullScreenPageMode :-" + str(doc.getNonFullScreenPageMode())

        # The page layout i.e. single page, one column
        print "PageLayout :-" + str(doc.getPageLayout())

        #How the document should display when opened.
        print "pageMode :-" + str(doc.getPageMode())

class GetPdfFileInfo:
    def __init__(self, dataDir):
        self.dataDir = dataDir
        self.Document = jpype.JClass("com.aspose.pdf.Document")

    def main(self):

        doc= self.Document()
        pdf = self.Document()
        pdf=self.dataDir + 'input1.pdf'

        # Get document information
        doc_info = doc.getInfo();

        # Show document information
        print "Author:-" + str(doc_info.getAuthor())
        print "Creation Date:-" + str(doc_info.getCreationDate())
        print "Keywords:-" + str(doc_info.getKeywords())
        print "Modify Date:-" + str(doc_info.getModDate())
        print "Subject:-" + str(doc_info.getSubject())
        print "Title:-" + str(doc_info.getTitle())

class GetXMPMetadata:
    def __init__(self, dataDir):
        self.dataDir = dataDir
        self.Document = jpype.JClass("com.aspose.pdf.Document")

    def main(self):

        doc= self.Document()
        pdf = self.Document()
        pdf=self.dataDir + 'input1.pdf'

        # Get properties
        print "xmp:CreateDate: " + str(doc.getMetadata().get_Item("xmp:CreateDate"))
        print "xmp:Nickname: " + str(doc.getMetadata().get_Item("xmp:Nickname"))
        print "xmp:CustomProperty: " + str(doc.getMetadata().get_Item("xmp:CustomProperty"))



class Optimize:
        def __init__(self, dataDir):
            self.dataDir = dataDir
            self.Document = jpype.JClass("com.aspose.pdf.Document")
#            self.OptimizationOptions=jpype.JClass("com.aspose.pdf.Document.OptimizationOptions")

        def main(self):

            doc= self.Document()
            pdf = self.Document()
            pdf=self.dataDir + 'input1.pdf'

            # Optimize for web
            doc.optimize();

            #Save output document
            doc.save(self.dataDir + "Optimized_Web.pdf")

            print "Optimized PDF for the Web, please check output file."

class RemoveMetadata:
        def __init__(self, dataDir):
            self.dataDir = dataDir
            self.Document = jpype.JClass("com.aspose.pdf.Document")

        def main(self):

            doc= self.Document()
            pdf = self.Document()
            pdf=self.dataDir + 'input1.pdf'

            if (re.findall('/pdfaid:part/',doc.getMetadata())):
                doc.getMetadata().removeItem("pdfaid:part")


            if (re.findall('/dc:format/',doc.getMetadata())):
                doc.getMetadata().removeItem("dc:format")


            # save update document with new information
            doc.save(self.dataDir + "Remove_Metadata.pdf")

            print "Removed metadata successfully, please check output file."

class SetExpiration:

        def __init__(self, dataDir):
            self.dataDir = dataDir
            self.Document = jpype.JClass("com.aspose.pdf.Document")
            self.JavascriptAction=jpype.JClass("com.aspose.pdf.JavascriptAction")

        def main(self):
            doc= self.Document()
            pdf = self.Document()
            pdf=self.dataDir + 'input1.pdf'

            javascript = self.JavascriptAction(
                "var year=2014; var month=4;today = new Date();today = new Date(today.getFullYear(), today.getMonth());expiry = new Date(year, month);if (today.getTime() > expiry.getTime())app.alert('The file is expired. You need a new one.');");

            doc.setOpenAction(javascript);

            # save update document with new information
            doc.save(self.dataDir + "set_expiration.pdf");

            print "Update document information, please check output file."


class SetPdfFileInfo:

        def __init__(self, dataDir):
            self.dataDir = dataDir
            self.Document = jpype.JClass("com.aspose.pdf.Document")

        def main(self):

            doc= self.Document()
            pdf = self.Document()
            pdf=self.dataDir + 'input1.pdf'

            # Get document information
            doc_info = doc.getInfo();

            doc_info.setAuthor("Aspose.Pdf for java");
            doc_info.setCreationDate(datetime.today.strftime("%m/%d/%Y"));
            doc_info.setKeywords("Aspose.Pdf, DOM, API");
            doc_info.setModDate(datetime.today.strftime("%m/%d/%Y"));
            doc_info.setSubject("PDF Information");
            doc_info.setTitle("Setting PDF Document Information");

            # save update document with new information
            doc.save(self.dataDir + "Updated_Information.pdf")

            print "Update document information, please check output file."





