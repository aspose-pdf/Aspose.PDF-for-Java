package com.aspose.pdf.examples.AsposePdfLegacy.Documents;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import aspose.pdf.Pdf;

public class AddingJavaScript {

	public static void main(String[] args) throws IOException {
		// Instantiate a PDF Object
		Pdf pdf = new Pdf();
		// Call the Add method and pass JavaScript statement as an argument, to show Print Dialog
		pdf.getJavaScripts().add("this.print(true);");
		// Call the Add method and JavaScript statement as an argument, to show alert
		pdf.getJavaScripts().add("app.alert(\"hello world\");");
		FileOutputStream out = new FileOutputStream(new File("test.pdf"));
		// Save Pdf Document
		pdf.save(out);
	}
}
