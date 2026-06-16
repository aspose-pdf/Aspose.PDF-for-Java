<?php

namespace Aspose\Pdf\WorkingWithPages;

use com\aspose\pdf\Document as Document;

class DeletePage {

    public static function run($dataDir=null)
    {
        # Open the target document
        $pdf = new Document($dataDir . 'input1.pdf');

        # delete a particular page
        $pdf->getPages()->delete(2);

        # save the newly generated PDF file
        $pdf->save($dataDir . "output.pdf");

        print "Page deleted successfully!";
    }
}