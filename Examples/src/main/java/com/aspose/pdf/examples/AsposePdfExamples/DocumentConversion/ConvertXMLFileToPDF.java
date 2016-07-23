package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.TextSegment;

public class ConvertXMLFileToPDF {

	public static void main(String[] args) {
		// instantiate Document object
		Document doc = new Document();
		// bind source XML file
		doc.bindXml("Source.xml");
		// get reference of page object from XML
		Page page = (Page) doc.getObjectById("mainSection");
		// get reference of first TextSegment with ID boldHtml
		TextSegment segment = (TextSegment) doc.getObjectById("boldHtml");
		// get reference of second TextSegment with ID strongHtml
		segment = (TextSegment) doc.getObjectById("strongHtml");
		// update TextSegement text
		segment.setText("TestSegment");
		// save resultant PDF file
		doc.save("Resultant.pdf");
	}

}
