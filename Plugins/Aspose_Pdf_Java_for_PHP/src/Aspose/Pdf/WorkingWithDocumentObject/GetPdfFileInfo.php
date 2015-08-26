<?php

namespace Aspose\Pdf\WorkingWithDocumentObject;

use com\aspose\pdf\Document as Document;

class GetPdfFileInfo {

    public static function run($dataDir=null)
    {

        # Open a pdf document.
        $doc = new Document($dataDir . "input1.pdf");

        # Get document information
        $doc_info = $doc->getInfo();

        # Show document information
        print "Author:-" . $doc_info->getAuthor();
        print "Creation Date:-" . $doc_info->getCreationDate();
        print "Keywords:-" . $doc_info->getKeywords();
        print "Modify Date:-" . $doc_info->getModDate();
        print "Subject:-" . $doc_info->getSubject();
        print "Title:-" . $doc_info->getTitle();

    }
}