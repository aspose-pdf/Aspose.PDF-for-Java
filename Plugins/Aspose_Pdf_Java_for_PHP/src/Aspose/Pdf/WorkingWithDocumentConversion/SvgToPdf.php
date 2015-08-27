<?php

namespace Aspose\Pdf\WorkingWithDocumentConversion;

use com\aspose\pdf\Document as Document;
use com\aspose\pdf\SvgLoadOptions as SvgLoadOptions;

class SvgToPdf {

    public static function run($dataDir=null)
    {
        # Instantiate LoadOption object using SVG load option
        $options = new SvgLoadOptions();

        # Create document object
        $pdf = new Document($dataDir . 'Example.svg', $options);

        # Save the output to XLS format
        $pdf->save($dataDir . "SVG.pdf");

        print "Document has been converted successfully";
    }
}