<?php

namespace Aspose\Pdf\WorkingWithDocumentConversion;

use com\aspose\pdf\Document as Document;
use com\aspose\pdf\ExcelSaveOptions as ExcelSaveOptions;

class PdfToExcel {

    public static function run($dataDir=null)
    {
        # Open the target document
        $pdf = new Document($dataDir . 'input1.pdf');

        # Instantiate ExcelSave Option object
        $excelsave = new ExcelSaveOptions();

        # Save the output to XLS format
        $pdf->save($dataDir . "Converted_Excel.xls", $excelsave);

        print "Document has been converted successfully" . PHP_EOL;
    }
}