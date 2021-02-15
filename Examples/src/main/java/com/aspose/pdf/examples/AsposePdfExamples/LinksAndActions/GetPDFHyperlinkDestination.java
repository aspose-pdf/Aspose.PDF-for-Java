package com.aspose.pdf.examples.AsposePdfExamples.LinksAndActions;

import java.util.List;

import com.aspose.pdf.AnnotationSelector;
import com.aspose.pdf.Document;
import com.aspose.pdf.GoToURIAction;
import com.aspose.pdf.LinkAnnotation;
import com.aspose.pdf.Page;
import com.aspose.pdf.Rectangle;

public class GetPDFHyperlinkDestination {
	public static void main(String[] args) {
		Document document = new Document("update_Service_Work_Order.pdf");
		// Extract actions
		Page page = document.getPages().get_Item(1);
		AnnotationSelector selector = new AnnotationSelector(new LinkAnnotation(page, Rectangle.getTrivial()));
		page.accept(selector);
		List list = selector.getSelected();
		// Iterate through individual item inside list
		if (list.size() == 0)
			System.out.println("No Hyperlinks found..");
		else {
			// Loop through all the bookmarks
			for (LinkAnnotation annot : (Iterable<LinkAnnotation>) list) {
				// Print the destination URL
				System.out.println("<br />Destination: " + ((GoToURIAction) annot.getAction()).getURI() + "<br />");
			}
		}// end else
	}
}
