<?php

namespace Aspose\Pdf\WorkingWithPages;

use com\aspose\pdf\Document as Document;

class UpdatePageDimensions {

    public static function run($dataDir=null)
    {
        # Open the target document
        $pdf = new Document($dataDir . 'input1.pdf');

        # get page collection
        $page_collection = $pdf->getPages();

        # get particular page
        $pdf_page = $page_collection->get_Item(1);

        # set the page size as A4 (11.7 x 8.3 in) and in Aspose.Pdf, 1 inch = 72 points
        # so A4 dimensions in points will be (842.4, 597.6)
        $pdf_page->setPageSize(597.6,842.4);

        # save the newly generated PDF file
        $pdf->save($dataDir . "output.pdf");

        print "Dimensions updated successfully!" . PHP_EOL;
    }
}