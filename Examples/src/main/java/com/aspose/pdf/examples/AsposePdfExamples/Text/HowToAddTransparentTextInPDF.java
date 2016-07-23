package com.aspose.pdf.examples.AsposePdfExamples.Text;

import com.aspose.pdf.Color;
import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.drawing.Graph;
import com.aspose.pdf.drawing.Rectangle;

public class HowToAddTransparentTextInPDF {

	public static void main(String[] args) {
		int alpha = 10;
		int green = 0;
		int red = 100;
		int blue = 0;
		// create Document instance
		Document doc = new Document();
		// create page to pages collection of PDF file
		Page page = doc.getPages().add();
		// create Graph object
		Graph canvas = new Graph(100, 400);
		// create rectangle instance with certain dimensions
		Rectangle rect = new Rectangle(100, 100, 400, 400);
		// create color object from Alpha color channel
		rect.getGraphInfo().setFillColor(Color.fromArgb(alpha, red, green, blue));
		// add rectanlge to shapes collection of Graph object
		canvas.getShapes().add(rect);
		// add graph object to paragraphs collection of page object
		page.getParagraphs().add(canvas);
		// set value to not change position for graph object
		canvas.setChangePosition(false);
		// create TextFragment instance with sample value
		TextFragment text = new TextFragment("transparent text transparent text transparent text transparent text transparent text transparent text transparent text transparent text transparent text transparent text transparent text transparent text transparent text transparent text transparent text transparent text ");
		// create color object from Alpha channel
		Color color = Color.fromArgb(30, 0, 255, 0);
		// set color information for text instance
		text.getTextState().setForegroundColor(color);
		// add text to paragraphs collection of page instance
		page.getParagraphs().add(text);
		// save PDF file
		doc.save("Transparent_Text.pdf");
	}
}
