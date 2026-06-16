<?php

namespace Aspose\Pdf\WorkingWithDocumentConversion;

use com\aspose\pdf\Document as Document;
use com\aspose\pdf\SvgSaveOptions as SvgSaveOptions;


class PdfToSvg {

    public static function run($dataDir=null)
    {
        # Open the target document
        $pdf = new Document($dataDir . 'input1.pdf');

        # instantiate an object of SvgSaveOptions
        $save_options = new SvgSaveOptions();

        # do not compress SVG image to Zip archive
        $save_options->CompressOutputToZipArchive = false;

        # Save the output to XLS format
        $pdf->save($dataDir . "Output.svg", $save_options);

        print "Document has been converted successfully" . PHP_EOL;
    }
}