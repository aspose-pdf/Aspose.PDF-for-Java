package com.aspose.pdf.examples.AsposePdfExamples.LinksAndActions;

import com.aspose.pdf.Border;
import com.aspose.pdf.DefaultAppearance;
import com.aspose.pdf.Document;
import com.aspose.pdf.FontRepository;
import com.aspose.pdf.FreeTextAnnotation;
import com.aspose.pdf.GoToURIAction;
import com.aspose.pdf.LinkAnnotation;
import com.aspose.pdf.Page;
import com.aspose.pdf.Rectangle;
import com.aspose.pdf.examples.Utils;

public class AddHyperlinkInPDFFile {
	
	private static final String dataDir = Utils.getSharedDataDir(AddHyperlinkInPDFFile.class) + "LinksAndActions/";
	
	public static void main(String[] args) {
		// Open document
		Document document = new Document(dataDir + "input.pdf");
		// Create link
		Page page = document.getPages().get_Item(1);
		// Create Link annotation object
		LinkAnnotation link = new LinkAnnotation(page, new Rectangle(100, 100, 300, 300));
		// Create border object for LinkAnnotation
		Border border = new Border(link);
		// Set the border width value as 0
		border.setWidth(0);
		// Set the border for LinkAnnotation
		link.setBorder(border);
		// Specify the link type as remote URI
		link.setAction(new GoToURIAction("www.aspose.com"));
		// Add link annotation to annotations collection of first page of PDF file
		page.getAnnotations().add(link);
		// Create Free Text annotation
		FreeTextAnnotation textAnnotation = new FreeTextAnnotation(document.getPages().get_Item(1), new Rectangle(100, 100, 300, 300), new DefaultAppearance(FontRepository.findFont("Arial"), 10, java.awt.Color.BLUE));
		// String to be added as Free text
		textAnnotation.setContents("Link to Aspose website");
		// Set the border for Free Text Annotation
		textAnnotation.setBorder(border);
		// Add FreeText annotation to annotations collection of first page of Document
		document.getPages().get_Item(1).getAnnotations().add(textAnnotation);
		// Save updated document
		document.save(dataDir + "Annotation_output.pdf");
	}

}
