<?php

namespace Aspose\Pdf\WorkingWithDocumentObject;

use com\aspose\pdf\Document as Document;
use com\aspose\pdf\TocInfo as TocInfo;
use com\aspose\pdf\TextFragment as TextFragment;
use com\aspose\pdf\TextSegment as TextSegment;
use com\aspose\pdf\Heading as Heading;


class AddToc {

    public static function run($dataDir=null)
    {
        # Open a pdf document.
        $doc = new Document($dataDir . "input1.pdf");

        # Get access to first page of PDF file
        $toc_page = $doc->getPages()->insert(1);

        # Create object to represent TOC information
        $toc_info = new TocInfo();
        $title = new TextFragment("Table Of Contents");
        $title->getTextState()->setFontSize(20);
        #title.getTextState().setFontStyle(Rjb::import('com.aspose.pdf.FontStyles.Bold'))

        # Set the title for TOC
        $toc_info->setTitle($title);
        $toc_page->setTocInfo($toc_info);

        # Create string objects which will be used as TOC elements
        $titles = array("First page", "Second page");

        $i = 0;
        while ($i < 2){
            # Create Heading object
            $heading2 = new Heading(1);

            $segment2 = new TextSegment();
            $heading2->setTocPage($toc_page);
            $heading2->getSegments()->add($segment2);

            # Specify the destination page for heading object
            $heading2->setDestinationPage($doc->getPages()->get_Item($i + 2));

            # Destination page
            $heading2->setTop($doc->getPages()->get_Item($i + 2)->getRect()->getHeight());

            # Destination coordinate
            $segment2->setText($titles[$i]);

            # Add heading to page containing TOC
            $toc_page->getParagraphs()->add($heading2);

            $i +=1;
        }

        # Save PDF Document
        $doc->save($dataDir . "TOC.pdf");

        print "Added TOC Successfully, please check the output file.";
    }

}