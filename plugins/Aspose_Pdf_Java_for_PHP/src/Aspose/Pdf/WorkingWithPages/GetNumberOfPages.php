<?php

namespace Aspose\Pdf\WorkingWithPages;

use com\aspose\pdf\Document as Document;

class GetNumberOfPages {

    public static function run($dataDir=null)
    {
        # Create PDF document
        $pdf = new Document($dataDir . 'input1.pdf');

        $page_count = $pdf->getPages()->size();

        print "Page Count:" . $page_count . PHP_EOL;
    }

}