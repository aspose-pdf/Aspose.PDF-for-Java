package com.aspose.pdf.examples.AsposePdfExamples.DocumentObject;

import com.aspose.pdf.Document;
import com.aspose.pdf.JavascriptAction;

public class SetPDFExpiration {

	public static void main(String[] args) {
		Document doc = new Document("input.pdf");
		JavascriptAction javaScript = new JavascriptAction("var year=2014;" + "var month=4;" + "today = new Date(); today = new Date(today.getFullYear(), today.getMonth());" + "expiry = new Date(year, month);" + "if (today.getTime() > expiry.getTime())" + "app.alert('The file is expired. You need a new one.');");
		doc.setOpenAction(javaScript);
		doc.save("JavaScript-Added.pdf");
	}
}
