<?php

namespace Aspose\Pdf\WorkingWithText;

use com\aspose\pdf\Document as Document;
use com\aspose\pdf\HtmlFragment as HtmlFragment;
use com\aspose\pdf\MarginInfo as MarginInfo;

class AddHtml {

    public static function run($dataDir=null)
    {

        # Instantiate Document object
        $doc = new Document();

        # Add a page to pages collection of PDF file
        $page = $doc->getPages()->add();

        # Instantiate HtmlFragment with HTML contents
        $title = new HtmlFragment("<fontsize=10><b><i>Table</i></b></fontsize>");

        # set MarginInfo for margin details
        $margin = new MarginInfo();
        $margin->setBottom(10);
        $margin->setTop(200);

        # Set margin information
        $title->setMargin($margin);

        # Add HTML Fragment to paragraphs collection of page
        $page->getParagraphs()->add($title);

        # Save PDF file
        $doc->save($dataDir . "html.output.pdf");

        print "HTML added successfully" . PHP_EOL;

    }

}