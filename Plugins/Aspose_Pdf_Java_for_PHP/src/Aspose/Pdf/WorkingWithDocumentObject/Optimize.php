<?php

namespace Aspose\Pdf\WorkingWithDocumentObject;

use com\aspose\pdf\Document as Document;
use com\aspose\pdf\Document\OptimizationOptions as OptimizationOptions;

class Optimize {

    public static function run($dataDir=null)
    {
        # Optimize document for the web
        Optimize::optimize_web($dataDir);

    }

    public static function optimize_web($dataDir=null)
    {

        # Open a pdf document.
        $doc = new Document($dataDir . "input1.pdf");

        # Optimize for web
        $doc->optimize();

        #Save output document
        $doc->save($dataDir . "Optimized_Web.pdf");

        print "Optimized PDF for the Web, please check output file." . PHP_EOL;

    }

}