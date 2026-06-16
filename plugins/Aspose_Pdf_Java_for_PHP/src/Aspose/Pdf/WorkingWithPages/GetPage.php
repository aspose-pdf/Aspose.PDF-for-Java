<?php

namespace Aspose\Pdf\WorkingWithPages;

use com\aspose\pdf\Document as Document;

class GetPage {

    public static function run($dataDir=null)
    {
        # Open the target document
        $pdf = new Document($dataDir . 'input1.pdf');

        # get the page at particular index of Page Collection
        $pdf_page = $pdf->getPages()->get_Item(1);

        # create a new Document object
        $new_document = new Document();

        # add page to pages collection of new document object
        $new_document->getPages()->add($pdf_page);

        # save the newly generated PDF file
        $new_document->save($dataDir . "output.pdf");

        print "Process completed successfully!";
    }
}