<?php

namespace Aspose\Pdf\WorkingWithPages;

use com\aspose\pdf\Document as Document;

class InsertEmptyPage {

    public static function run($dataDir=null)
    {
        # Open the target document
        $pdf = new Document($dataDir . 'input1.pdf');

        # insert a empty page in a PDF
        $pdf->getPages()->insert(1);

        # Save the concatenated output file (the target document)
        $pdf->save($dataDir . "output.pdf");

        print "Empty page added successfully!";

    }

}