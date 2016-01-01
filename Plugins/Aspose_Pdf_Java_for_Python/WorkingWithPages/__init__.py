__author__ = 'fahadadeel'
import jpype

class ConcatenatePdfFiles:
    def __init__(self, dataDir):
        self.dataDir = dataDir
        self.Document = jpype.JClass("com.aspose.pdf.Document")

    def main(self):
        doc= self.Document()
        pdf = self.Document()
        pdf=self.dataDir + 'input1.pdf'

        # Open the source document
        pdf1 = self.Document()
        pdf1=self.dataDir + 'input2.pdf'

        # Add the pages of the source document to the target document
        pdf1.getPages().add(pdf1.getPages())

        # Save the concatenated output file (the target document)
        doc.save(self.dataDir + "Concatenate_output.pdf")

        print "New document has been saved, please check the output file"


class DeletePage:
    def __init__(self, dataDir):
        self.dataDir = dataDir
        self.Document = jpype.JClass("com.aspose.pdf.Document")

    def main(self):
        doc= self.Document()
        pdf = self.Document()
        pdf=self.dataDir + 'input1.pdf'

        # delete a particular page
        pdf.getPages().delete(2)

        # save the newly generated PDF file
        doc.save(self.dataDir + "output.pdf")

        print "Page deleted successfully!"

class GetNumberOfPages:
    def __init__(self, dataDir):
        self.dataDir = dataDir
        self.Document = jpype.JClass("com.aspose.pdf.Document")

    def main(self):
        doc= self.Document()
        pdf = self.Document()
        pdf=self.dataDir + 'input1.pdf'

        page_count = pdf.getPages().size()

        print "Page Count:" . page_count

class GetPage:
    def __init__(self, dataDir):
        self.dataDir = dataDir
        self.Document = jpype.JClass("com.aspose.pdf.Document")

    def main(self):
        # Open the target document
        doc= self.Document()
        pdf = self.Document()
        pdf=self.dataDir + 'input1.pdf'

        # get the page at particular index of Page Collection
        pdf_page = pdf.getPages().get_Item(1)

        # create a new Document object
        new_document = self.Document()

        # add page to pages collection of new document object
        new_document.getPages().add(pdf_page)

        # save the newly generated PDF file
        new_document.save(self.dataDir + "output.pdf")

        print "Process completed successfully!"


class GetPageProperties:
     def __init__(self, dataDir):
        self.dataDir = dataDir
        self.Document = jpype.JClass("com.aspose.pdf.Document")

     def main(self):
        doc= self.Document()
        pdf_document = self.Document()
        pdf_document=self.dataDir + 'input1.pdf'

        # get page collection
        page_collection = pdf_document.getPages();

        # get particular page
        pdf_page = page_collection.get_Item(1);

        #get page properties
        print "ArtBox : Height = " + pdf_page.getArtBox().getHeight() + ", Width = " + pdf_page.getArtBox().getWidth() + ", LLX = " + pdf_page.getArtBox().getLLX() + ", LLY = " + pdf_page.getArtBox().getLLY() + ", URX = " + pdf_page.getArtBox().getURX() + ", URY = " + pdf_page.getArtBox().getURY()
        print "BleedBox : Height = " + pdf_page.getBleedBox().getHeight() + ", Width = " + pdf_page.getBleedBox().getWidth() + ", LLX = " + pdf_page.getBleedBox().getLLX() + ", LLY = " + pdf_page.getBleedBox().getLLY() + ", URX = " + pdf_page.getBleedBox().getURX() + ", URY = " . pdf_page.getBleedBox().getURY()
        print "CropBox : Height = " + pdf_page.getCropBox().getHeight() + ", Width = " + pdf_page.getCropBox().getWidth() + ", LLX = " + pdf_page.getCropBox().getLLX() + ", LLY = " + pdf_page.getCropBox().getLLY() + ", URX = " + pdf_page.getCropBox().getURX() + ", URY = " . pdf_page.getCropBox().getURY()
        print "MediaBox : Height = " + pdf_page.getMediaBox().getHeight() + ", Width = " + pdf_page.getMediaBox().getWidth() + ", LLX = " + pdf_page.getMediaBox().getLLX() + ", LLY = " + pdf_page.getMediaBox().getLLY() + ", URX = " + pdf_page.getMediaBox().getURX() + ", URY = " . pdf_page.getMediaBox().getURY()
        print "TrimBox : Height = " + pdf_page.getTrimBox().getHeight() + ", Width = " + pdf_page.getTrimBox().getWidth() + ", LLX = " + pdf_page.getTrimBox().getLLX() + ", LLY = " + pdf_page.getTrimBox().getLLY() + ", URX = " + pdf_page.getTrimBox().getURX() + ", URY = " . pdf_page.getTrimBox().getURY()
        print "Rect : Height = " + pdf_page.getRect().getHeight() + ", Width = " + pdf_page.getRect().getWidth() + ", LLX = " + pdf_page.getRect().getLLX() + ", LLY = " + pdf_page.getRect().getLLY() + ", URX = " + pdf_page.getRect().getURX() + ", URY = " + pdf_page.getRect().getURY()
        print "Page Number :- " + pdf_page.getNumber()
        print "Rotate :-" + pdf_page.getRotate()


class InsertEmptyPage:
        def __init__(self, dataDir):
            self.dataDir = dataDir
            self.Document = jpype.JClass("com.aspose.pdf.Document")

        def main(self):
            doc= self.Document()
            pdf_document = self.Document()
            pdf_document=self.dataDir + 'input1.pdf'

            # insert a empty page in a PDF
            pdf_document.getPages().insert(1)

            # Save the concatenated output file (the target document)
            pdf_document.save(self.dataDir + "output.pdf")

            print "Empty page added successfully!"

class InsertEmptyPageAtEndOfFile:
        def __init__(self, dataDir):
            self.dataDir = dataDir
            self.Document = jpype.JClass("com.aspose.pdf.Document")

        def main(self):
            #doc= self.Document()
            pdf_document = self.Document()
            pdf_document=self.dataDir + 'input1.pdf'

            # insert a empty page in a PDF
            pdf_document.getPages().add();

            # Save the concatenated output file (the target document)
            pdf_document.save(self.dataDir + "output.pdf")

            print "Empty page added successfully!"

class SplitAllPages:
        def __init__(self, dataDir):
            self.dataDir = dataDir
            self.Document = jpype.JClass("com.aspose.pdf.Document")

        def main(self):
            #doc= self.Document()
            pdf = self.Document()
            pdf=self.dataDir + 'input1.pdf'

            # loop through all the pages
            pdf_page = 1
            total_size = pdf.getPages().size()
            while (pdf_page <= total_size):

                # create a new Document object
                new_document = self.Document();

                # get the page at particular index of Page Collection
                new_document.getPages().add(pdf.getPages().get_Item(pdf_page))

                # save the newly generated PDF file
                new_document.save(self.dataDir + "page_#{$pdf_page}.pdf")

                pdf_page+=1

            print "Split process completed successfully!";


class UpdatePageDimensions:

         def __init__(self, dataDir):
            self.dataDir = dataDir
            self.Document = jpype.JClass("com.aspose.pdf.Document")

         def main(self):
            #doc= self.Document()
            pdf = self.Document()
            pdf=self.dataDir + 'input1.pdf'

            # get page collection
            page_collection = pdf.getPages()

            # get particular page
            pdf_page = page_collection.get_Item(1)

            # set the page size as A4 (11.7 x 8.3 in) and in Aspose.Pdf, 1 inch = 72 points
            # so A4 dimensions in points will be (842.4, 597.6)
            pdf_page.setPageSize(597.6,842.4)

            # save the newly generated PDF file
            pdf.save(self.dataDir + "output.pdf")

            print "Dimensions updated successfully!"
