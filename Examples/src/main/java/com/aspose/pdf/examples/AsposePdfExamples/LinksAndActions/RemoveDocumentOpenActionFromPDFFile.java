package com.aspose.pdf.examples.AsposePdfExamples.LinksAndActions;

import com.aspose.pdf.Document;

public class RemoveDocumentOpenActionFromPDFFile {

	public static void main(String[] args) {
		// Open document
		Document document = new Document("Input.pdf");
		// Remove document open action
		document.setOpenAction(null);
		// Save updated document
		document.save("Output.pdf");
	}

}
