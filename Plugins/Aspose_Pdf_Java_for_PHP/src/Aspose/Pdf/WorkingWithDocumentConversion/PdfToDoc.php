<?php

namespace Aspose\Pdf\WorkingWithDocumentConversion;

use com\aspose\pdf\Document as Document;

class PdfToDoc {

    public static function run($dataDir=null)
    {
        # Open the target document
        $pdf = new Document($dataDir . 'input1.pdf');

        # Save the concatenated output file (the target document)
        $pdf->save($dataDir . "output.doc");

        print "Document has been converted successfully" . PHP_EOL;
    }

}