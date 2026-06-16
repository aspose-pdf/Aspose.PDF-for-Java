<?php
namespace Aspose\Pdf\WorkingWithDocumentObject;

use com\aspose\pdf\Document as Document;
use com\aspose\pdf\JavascriptAction as JavascriptAction;


class AddJavascript {

    public static function run($dataDir=null)
    {
        # Open a pdf document.
        $doc = new Document($dataDir . "input1.pdf");

        # Adding JavaScript at Document Level
        # Instantiate JavascriptAction with desried JavaScript statement
        $javaScript = new JavascriptAction("this.print({bUI:true,bSilent:false,bShrinkToFit:true});");

        # Assign JavascriptAction object to desired action of Document
        $doc->setOpenAction($javaScript);

        # Adding JavaScript at Page Level
        $doc->getPages()->get_Item(2)->getActions()->setOnOpen(new JavascriptAction("app.alert('page 2 is opened')"));
        $doc->getPages()->get_Item(2)->getActions()->setOnClose(new JavascriptAction("app.alert('page 2 is closed')"));

        # Save PDF Document
        $doc->save($dataDir . "JavaScript-Added.pdf");

        print "Added JavaScript Successfully, please check the output file.";
    }

}