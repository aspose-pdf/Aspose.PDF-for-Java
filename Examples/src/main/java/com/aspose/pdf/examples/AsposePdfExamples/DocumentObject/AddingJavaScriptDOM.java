package com.aspose.pdf.examples.AsposePdfExamples.DocumentObject;

import com.aspose.pdf.Document;
import com.aspose.pdf.JavascriptAction;
import com.aspose.pdf.TextBoxField;
import com.aspose.pdf.examples.Utils;

public class AddingJavaScriptDOM {

    public static void main(String[] args) {
        runExamples();
    }
    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/AddingJavaScriptDOM/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================1");
        System.out.println("Example addingJavaScriptDOM start");
        addingJavaScriptDOM(dataDir, outputDir);
        System.out.println("Example addingJavaScriptDOM end");

        System.out.println("Example afterPrintingAndSaving start");
        afterPrintingAndSaving(dataDir, outputDir);
        System.out.println("Example afterPrintingAndSaving end");

        System.out.println("Example addFormattingCodeAndValueValidation start");
        addFormattingCodeAndValueValidation(dataDir, outputDir);
        System.out.println("Example addFormattingCodeAndValueValidation end");

    }

    public static void addingJavaScriptDOM(String dataDir, String outputDir) {
        // Open a PDF Document
        Document doc = new Document(dataDir + "input.pdf");
        // Adding JavaScript at Document Level
        // Instantiate JavascriptAction with desired JavaScript statement
        JavascriptAction javaScript = new JavascriptAction("this.print({bUI:true,bSilent:false,bShrinkToFit:true});");
        // Assign JavascriptAction object to desired action of Document
        doc.setOpenAction(javaScript);
        // Adding JavaScript at Page Level
        doc.getPages().get_Item(2).getActions().setOnOpen(new JavascriptAction("app.alert('page 2 is opened')"));
        doc.getPages().get_Item(2).getActions().setOnClose(new JavascriptAction("app.alert('page 2 is closed')"));
        // Save PDF Document
        doc.save(dataDir + "out/addingJavaScriptDOM.pdf");
    }

    public static void addFormattingCodeAndValueValidation(String dataDir, String outputDir) {
        Document doc = new Document(dataDir + "PdfWithAcroForm.pdf");
        TextBoxField text = (TextBoxField) doc.getForm().get_Item("textField");
        text.getAnnotationActions().setOnFormat(new JavascriptAction("AFNumber_Format(2, 0, 0, \"\", true);"));
        text.getAnnotationActions().setOnModifyCharacter(new JavascriptAction("AFNumber_Keystroke(2, 0, 0, \"\", true);"));
        text.getAnnotationActions().setOnValidate(new JavascriptAction("AFRange_Validate(true, 1, true, 100);"));
        text.setValue("100");
        doc.save(outputDir + "addFormattingCodeAndValueValidation.pdf");
    }

    public static void afterPrintingAndSaving(String dataDir, String outputDir) {
        // Open a PDF Document
        Document doc = new Document(dataDir + "input.pdf");
        // Printing
        doc.getActions().setAfterPrinting(new JavascriptAction("app.alert('File was printed')"));
        // Saving
        doc.getActions().setAfterSaving(new JavascriptAction("app.alert('File was Saved')"));
        doc.save(outputDir + "afterPrintingAndSaving.pdf");
    }
}
