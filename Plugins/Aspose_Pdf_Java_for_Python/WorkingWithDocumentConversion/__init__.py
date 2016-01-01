__author__ = 'fahadadeel'
import jpype


class PdfToDoc:
    def __init__(self, dataDir):
        print "init func"
        self.dataDir = dataDir
        self.Document = jpype.JClass("com.aspose.pdf.Document")

    def main(self):

         doc= self.Document()
         pdf = self.Document()
         pdf=self.dataDir + 'Template.pdf'
         doc.save(self.dataDir + 'template.docx')
         print "Document has been converted successfully"

class PdfToExcel:

    def __init__(self, dataDir):
        print "init func"
        self.dataDir = dataDir
        self.Document = jpype.JClass("com.aspose.pdf.Document")
        self.ExcelSaveOptions=jpype.JClass("com.aspose.pdf.ExcelSaveOptions")

    def main(self):

         # Open the target document
        doc=self.Document()
        pdf = self.Document()
        pdf=self.dataDir +'input1.pdf'

        # Instantiate ExcelSave Option object
        excelsave=self.ExcelSaveOptions();

        # Save the output to XLS format
        doc.save(self.dataDir + "Converted_Excel.xls", excelsave);

        print "Document has been converted successfully"

class PdfToSvg:

    def __init__(self, dataDir):
        print "init func"
        self.dataDir = dataDir
        self.Document = jpype.JClass("com.aspose.pdf.Document")
        self.SvgSaveOptions=jpype.JClass("com.aspose.pdf.SvgSaveOptions")

    def main(self):

        # Open the target document
        doc=self.Document()
        pdf = self.Document()
        pdf=self.dataDir +'input1.pdf'

        # instantiate an object of SvgSaveOptions
        save_options = self.SvgSaveOptions()

        # do not compress SVG image to Zip archive
        save_options.CompressOutputToZipArchive = False;

        # Save the output to XLS format
        doc.save(self.dataDir + "Output1.svg", save_options)

        print "Document has been converted successfully"
         # doc= self.Document()
         # pdf = self.Document()
         # pdf=self.dataDir + 'Template.pdf'
         # doc.save(self.dataDir + 'template.svg')
         # print "Document has been converted successfully"

class SvgToPdf:

    def __init__(self, dataDir):
        print "init func"
        self.dataDir = dataDir
        self.Document = jpype.JClass("com.aspose.pdf.Document")
        self.SvgLoadOptions=jpype.JClass("com.aspose.pdf.SvgLoadOptions")

    def main(self):

        options = self.SvgLoadOptions();

        doc=self.Document()
        pdf = self.Document()
        pdf=self.dataDir +'input1.pdf'

        # Save the output to XLS format
        doc.save(self.dataDir + "SVG1.pdf");

        print "Document has been converted successfully"

         # doc= self.Document()
         # pdf = self.Document()
         # pdf=self.dataDir + 'template.svg'
         # doc.save(self.dataDir + 'Template.pdf')
         # print "Document has been converted successfully"
