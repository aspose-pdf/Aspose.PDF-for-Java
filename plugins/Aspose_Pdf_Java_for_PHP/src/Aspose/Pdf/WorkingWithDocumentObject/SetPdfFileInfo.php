<?php


namespace Aspose\Pdf\WorkingWithDocumentObject;

use com\aspose\pdf\Document as Document;
use java\util\Date as Date;


class SetPdfFileInfo {

    public static function run($dataDir=null)
    {

        # Open a pdf document.
        $doc = new Document($dataDir . "input1.pdf");

        # Get document information
        $doc_info = $doc->getInfo();

        $doc_info->setAuthor("Aspose.Pdf for java");
        $doc_info->setCreationDate(new Date());
        $doc_info->setKeywords("Aspose.Pdf, DOM, API");
        $doc_info->setModDate(new Date());
        $doc_info->setSubject("PDF Information");
        $doc_info->setTitle("Setting PDF Document Information");

        # save update document with new information
        $doc->save($dataDir . "Updated_Information.pdf");

        print "Update document information, please check output file.";

    }
}