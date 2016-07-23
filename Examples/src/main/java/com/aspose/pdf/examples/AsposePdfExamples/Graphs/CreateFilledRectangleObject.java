package com.aspose.pdf.examples.AsposePdfExamples.Graphs;

import com.aspose.pdf.Color;
import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.drawing.Graph;
import com.aspose.pdf.drawing.Rectangle;

public class CreateFilledRectangleObject {

	public static void main(String[] args) {
		// Create Document instance
		Document doc = new Document();
		// Add page to pages collection of PDF file
		Page page = doc.getPages().add();
		// Create Graph instance
		Graph graph = new Graph(100, 400);
		// Add graph object to paragraphs collection of page instance
		page.getParagraphs().add(graph);
		// Create Rectangle instance
		Rectangle rect = new Rectangle(100, 100, 200, 120);
		// Specify fill color for Graph object
		rect.getGraphInfo().setFillColor(Color.getRed());
		// Add rectangle object to shapes collection of Graph object
		graph.getShapes().add(rect);
		// save resultant PDF file
		doc.save("Filled_Rect.pdf");
	}

}
