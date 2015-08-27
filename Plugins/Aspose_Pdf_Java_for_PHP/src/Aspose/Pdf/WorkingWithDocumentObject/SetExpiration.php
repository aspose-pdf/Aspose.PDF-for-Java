<?php

namespace Aspose\Pdf\WorkingWithDocumentObject;

use com\aspose\pdf\Document as Document;
use com\aspose\pdf\JavascriptAction as JavascriptAction;

class SetExpiration {

    public static function run($dataDir=null)
    {
        # Open a pdf document.
        $doc = new Document($dataDir . "input1.pdf");

        $javascript = new JavascriptAction(
                "var year=2014;
            var month=4;
            today = new Date();
            today = new Date(today.getFullYear(), today.getMonth());
            expiry = new Date(year, month);
            if (today.getTime() > expiry.getTime())
            app.alert('The file is expired. You need a new one.');");
        $doc->setOpenAction($javascript);

        # save update document with new information
        $doc->save($dataDir . "set_expiration.pdf");

        print "Update document information, please check output file." . PHP_EOL;
    }

}