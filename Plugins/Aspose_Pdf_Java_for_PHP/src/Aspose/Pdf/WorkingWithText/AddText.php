<?php

namespace Aspose\Pdf\WorkingWithText;

use com\aspose\pdf\Document as Document;
use com\aspose\pdf\TextFragment as TextFragment;
use com\aspose\pdf\Position as Position;
use com\aspose\pdf\FontRepository as FontRepository;
use com\aspose\pdf\Color as Color;
use com\aspose\pdf\TextBuilder as TextBuilder;


class AddText {

    public static function run($dataDir=null)
    {
        # Instantiate Document object
        $doc = new Document($dataDir . 'input1.pdf');

        # get particular page
        $pdf_page = $doc->getPages()->get_Item(1);

        # create text fragment
        $text_fragment = new TextFragment("main text");
        $text_fragment->setPosition(new Position(100, 600));


        $font_repository = new FontRepository();
        $color = new Color();

        # set text properties
        $text_fragment->getTextState()->setFont($font_repository->findFont("Verdana"));
        $text_fragment->getTextState()->setFontSize(14);

        # create TextBuilder object
        $text_builder = new TextBuilder($pdf_page);

        # append the text fragment to the PDF page
        $text_builder->appendText($text_fragment);

        # Save PDF file
        $doc->save($dataDir . "Text_Added.pdf");

        print "Text added successfully" . PHP_EOL;
    }

}