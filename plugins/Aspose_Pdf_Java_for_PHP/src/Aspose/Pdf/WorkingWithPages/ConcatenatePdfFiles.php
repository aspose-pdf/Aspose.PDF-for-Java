<?php

namespace Aspose\Pdf\WorkingWithPages;

use com\aspose\pdf\Document as Document;

class ConcatenatePdfFiles {

    public static function run($dataDir=null)
    {
        # Open the target document
        $pdf1 = new Document($dataDir . 'input1.pdf');

        # Open the source document
        $pdf2 = new Document($dataDir . 'input2.pdf');
        
        # Add the pages of the source document to the target document
        $pdf1->getPages()->add($pdf2->getPages());

        # Save the concatenated output file (the target document)
        $pdf1->save($dataDir . "Concatenate_output.pdf");

        print "New document has been saved, please check the output file" . PHP_EOL;
    }
}