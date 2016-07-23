package com.aspose.pdf.examples.AsposePdfExamples.DocumentObject;

import com.aspose.pdf.Document;
import com.aspose.pdf.JavascriptAction;
import com.aspose.pdf.TextBoxField;

public class AddingJavaScriptDOM {

	public static void main(String[] args) {
		addingJavaScriptDOM();
		afterPrintingAndSaving();
		addFormattingCodeAndValueValidation();
	}

	public static void addingJavaScriptDOM() {
		// Open a PDF Document
		Document doc = new Document("inuput.pdf");
		// Adding JavaScript at Document Level
		// Instantiate JavascriptAction with desired JavaScript statement
		JavascriptAction javaScript = new JavascriptAction("this.print({bUI:true,bSilent:false,bShrinkToFit:true});");
		// Assign JavascriptAction object to desired action of Document
		doc.setOpenAction(javaScript);
		// Adding JavaScript at Page Level
		doc.getPages().get_Item(2).getActions().setOnOpen(new JavascriptAction("app.alert('page 2 is opened')"));
		doc.getPages().get_Item(2).getActions().setOnClose(new JavascriptAction("app.alert('page 2 is closed')"));
		// Save PDF Document
		doc.save("JavaScript-Added.pdf");
	}

	public static void addFormattingCodeAndValueValidation() {
		String path = "pathTodir";
		Document doc = new Document(path + "PdfWithAcroForm.pdf");
		TextBoxField text = (TextBoxField) doc.getForm().get_Item("textField");
		text.getActions().setOnFormat(new JavascriptAction("AFNumber_Format(2, 0, 0, \"\", true);"));
		text.getActions().setOnModifyCharacter(new JavascriptAction("AFNumber_Keystroke(2, 0, 0, \"\", true);"));
		text.getActions().setOnValidate(new JavascriptAction("AFRange_Validate(true, 1, true, 100);"));
		text.setValue("100");
		doc.save(path + "formatted.pdf");
	}

	public static void afterPrintingAndSaving() {
		// Open a PDF Document
		Document document = new Document("inuput.pdf");
		// Printing
		document.getActions().setAfterPrinting(new JavascriptAction("app.alert('File was printed')"));
		// Saving
		document.getActions().setAfterSaving(new JavascriptAction("app.alert('File was Saved')"));
	}
}
