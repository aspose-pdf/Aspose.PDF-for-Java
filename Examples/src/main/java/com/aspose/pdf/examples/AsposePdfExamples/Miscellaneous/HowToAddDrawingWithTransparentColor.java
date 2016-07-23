package com.aspose.pdf.examples.AsposePdfExamples.Miscellaneous;

import com.aspose.pdf.BorderInfo;
import com.aspose.pdf.BorderSide;
import com.aspose.pdf.Color;
import com.aspose.pdf.Document;
import com.aspose.pdf.GraphInfo;
import com.aspose.pdf.Page;
import com.aspose.pdf.drawing.Graph;
import com.aspose.pdf.drawing.Rectangle;

public class HowToAddDrawingWithTransparentColor {

	public static void main(String[] args) {
		int alpha = 10;
		int green = 0;
		int red = 100;
		int blue = 0;
		// create Color object using Alpha RGB
		Color alphaColor = Color.fromArgb(alpha, red, green, blue); // provide alpha channel
		// instantiate Document object
		Document document = new Document();
		// add page to pages collection of PDF file
		Page page = document.getPages().add();
		// create Graph object with certain dimensions
		Graph graph = new Graph(300, 400);
		// set border for Drawing object
		graph.setBorder(new BorderInfo(BorderSide.All, Color.getBlack()));
		// add graph object to paragraphs collection of Page instance
		page.getParagraphs().add(graph);
		// create Rectangle object with certain dimensions
		Rectangle rectangle = new Rectangle(0, 0, 100, 50);
		// create graphInfo object for Rectangle instance
		GraphInfo graphInfo = rectangle.getGraphInfo();
		// set color information for GraphInfo instance
		graphInfo.setColor(Color.getRed());
		// set fill color for GraphInfo
		graphInfo.setFillColor(alphaColor);
		// add rectangle shape to shapes collection of graph object
		graph.getShapes().add(rectangle);
		// save PDF file
		document.save("TransparentColor.pdf");
	}
}
