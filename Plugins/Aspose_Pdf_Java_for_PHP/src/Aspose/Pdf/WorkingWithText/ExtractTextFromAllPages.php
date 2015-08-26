<?php

namespace Aspose\Pdf\WorkingWithText;

use com\aspose\pdf\Document as Document;
use com\aspose\pdf\TextAbsorber as TextAbsorber;
use java\io\FileWriter as FileWriter;
use java\io\File;

class ExtractTextFromAllPages {

    public static function run($dataDir=null)
    {
        # Open the target document
        $pdf = new Document($dataDir . 'input1.pdf');

        # create TextAbsorber object to extract text
        $text_absorber = new TextAbsorber();

        # accept the absorber for all the pages
        $pdf->getPages()->accept($text_absorber);

        # In order to extract text from specific page of document, we need to specify the particular page using its index against accept(..) method.
        # accept the absorber for particular PDF page
        # pdfDocument.getPages().get_Item(1).accept(textAbsorber);

        #get the extracted text
        $extracted_text = $text_absorber->getText();

        # create a writer and open the file
        $writer = new FileWriter(new File($dataDir . "extracted_text.out.txt"));
        $writer->write($extracted_text);
        # write a line of text to the file
        # tw.WriteLine(extractedText);
        # close the stream
        $writer->close();

        print "Text extracted successfully. Check output file." . PHP_EOL;

    }
}