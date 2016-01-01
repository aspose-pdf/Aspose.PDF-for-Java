__author__ = 'fahadadeel'
import jpype


class AddHtml:
    def __init__(self, dataDir):
        print "init func"
        self.dataDir = dataDir
        self.Document = jpype.JClass("com.aspose.pdf.Document")
        self.HtmlFragment=jpype.JClass("com.aspose.pdf.HtmlFragment")
        self.MarginInfo=jpype.JClass("com.aspose.pdf.MarginInfo")
        self.TextFragment=jpype.JClass("com.aspose.pdf.TextFragment")
        self.Position=jpype.JClass("com.aspose.pdf.Position")
        self.FontRepository=jpype.JClass("com.aspose.pdf.FontRepository")
        self.Color=jpype.JClass("com.aspose.pdf.Color")
        self.TextBuilder=jpype.JClass("com.aspose.pdf.TextBuilder")

    def main(self):

        doc=self.Document()
        page=doc.getPages().add()

        title=self.HtmlFragment("<fontsize=10><b><i>Table</i></b></fontsize>")

        margin=self.MarginInfo()
        #margin.setBottom(10)
        #margin.setTop(200)

        # Set margin information
        title.setMargin(margin)

        # Add HTML Fragment to paragraphs collection of page
        page.getParagraphs().add(title)

        # Save PDF file
        doc.save(self.dataDir + 'html.output.pdf')

        print "HTML added successfully"

class AddText:
    def __init__(self, dataDir):
        print "init func"
        self.dataDir = dataDir
        self.Document = jpype.JClass("com.aspose.pdf.Document")
        self.HtmlFragment=jpype.JClass("com.aspose.pdf.HtmlFragment")
        self.MarginInfo=jpype.JClass("com.aspose.pdf.MarginInfo")
        self.TextFragment=jpype.JClass("com.aspose.pdf.TextFragment")
        self.Position=jpype.JClass("com.aspose.pdf.Position")
        self.FontRepository=jpype.JClass("com.aspose.pdf.FontRepository")
        self.Color=jpype.JClass("com.aspose.pdf.Color")
        self.TextBuilder=jpype.JClass("com.aspose.pdf.TextBuilder")

    def main(self):

        #$doc = new Document($dataDir . 'input1.pdf');
        doc=self.Document()
        doc=self.dataDir + 'input1.pdf'

        # get particular page
        #$pdf_page = $doc->getPages()->get_Item(1);
        pdf_page=self.Document()
        pdf_page.getPages().get_Item(1)

        # create text fragment
        #$text_fragment = new TextFragment("main text");
        text_fragment=self.TextFragment("main text")
        #$text_fragment->setPosition(new Position(100, 600));
        position=self.Position()
        text_fragment.setPosition(position(100,600))


        #$font_repository = new FontRepository();
        #$color = new Color();

        font_repository=self.FontRepository()
        color=self.Color()

        # set text properties
        #$text_fragment->getTextState()->setFont($font_repository->findFont("Verdana"));
        #$text_fragment->getTextState()->setFontSize(14);

        text_fragment.getTextState().setFont(font_repository.findFont("Verdana"))
        text_fragment.getTextState().setFontSize(14)

        # create TextBuilder object
          # $text_builder = new TextBuilder($pdf_page);
        text_builder=self.TextBuilder(pdf_page)

        # append the text fragment to the PDF page
        #$text_builder->appendText($text_fragment);
        text_builder.appendText(text_fragment)

        # Save PDF file
        #$doc->save($dataDir . "Text_Added.pdf");
        doc.save(self.dataDir + "Text_Added.pdf")

        print "Text added successfully"

class ExtractTextFromAllPages:
    def __init__(self,dataDir):
        self.dataDir = dataDir
        self.Document = jpype.JClass("com.aspose.pdf.Document")
        self.TextAbsorber=jpype.JClass("com.aspose.pdf.TextAbsorber")
        self.FileWriter=jpype.JClass("java.io.FileWriter")
        self.File=jpype.JClass("java.io.File")

    def main(self):

        # Open the target document
        #$pdf = new Document($dataDir . 'input1.pdf');
        pdf=self.Document()
        pdf=self.dataDir + 'input1.pdf'

        # create TextAbsorber object to extract text
        #$text_absorber = new TextAbsorber();
        text_absorber=self.TextAbsorber()


        # accept the absorber for all the pages
        #$pdf->getPages()->accept($text_absorber);
        pdf.getPages().accept(text_absorber)

        # In order to extract text from specific page of document, we need to specify the particular page using its index against accept(..) method.
        # accept the absorber for particular PDF page
        # pdfDocument.getPages().get_Item(1).accept(textAbsorber);

        #get the extracted text
        #$extracted_text = $text_absorber->getText();
        extracted_text=text_absorber.getText()

        # create a writer and open the file
        #$writer = new FileWriter(new File($dataDir . "extracted_text.out.txt"));
        #$writer->write($extracted_text);

        writer=self.FileWriter(self.File(self.dataDir + 'extracted_text.out.txt'))
        writer.write(extracted_text)
        # write a line of text to the file
        # tw.WriteLine(extractedText);
        # close the stream
 #       $writer->close();
        writer.close()

        print "Text extracted successfully. Check output file."