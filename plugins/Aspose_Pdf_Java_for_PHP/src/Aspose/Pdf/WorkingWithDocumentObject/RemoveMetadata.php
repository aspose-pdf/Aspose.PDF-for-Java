<?php

namespace Aspose\Pdf\WorkingWithDocumentObject;

use com\aspose\pdf\Document as Document;

class RemoveMetadata {

    public static function run($dataDir=null)
    {

        # Open a pdf document.
        $doc = new Document($dataDir . "input1.pdf");

        if (preg_match('/pdfaid:part/',$doc->getMetadata())) {
            $doc->getMetadata()->removeItem("pdfaid:part");
        }

        if (preg_match('/dc:format/',$doc->getMetadata())) {
            $doc->getMetadata()->removeItem("dc:format");
        }

        # save update document with new information
        $doc->save($dataDir . "Remove_Metadata.pdf");

        print "Removed metadata successfully, please check output file." . PHP_EOL;

    }
}