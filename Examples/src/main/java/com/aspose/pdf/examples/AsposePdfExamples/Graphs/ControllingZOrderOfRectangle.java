package com.aspose.pdf.examples.AsposePdfExamples.Graphs;

import com.aspose.pdf.Color;
import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.drawing.Graph;
import com.aspose.pdf.drawing.Rectangle;

public class ControllingZOrderOfRectangle {

	public static void main(String[] args) {
		// Create Document instance
		Document doc = new Document();
		// Add page to pages collection of PDF file
		Page page = doc.getPages().add();
		// set size of PDF page
		page.setPageSize(375, 300);
		// set left margin for page object as 0
		page.getPageInfo().getMargin().setLeft(0);
		// set top margin of page object as 0
		page.getPageInfo().getMargin().setTop(0);
		// create a new rectangle with Color as Red, Z-Order as 0 and certain
		// dimensions
		addRectangle(page, 50, 40, 60, 40, Color.getRed(), 2);
		// create a new rectangle with Color as Blue, Z-Order as 0 and certain
		// dimensions
		addRectangle(page, 20, 20, 30, 30, Color.getBlue(), 1);
		// create a new rectangle with Color as Green, Z-Order as 0 and certain
		// dimensions
		addRectangle(page, 40, 40, 60, 30, Color.getGreen(), 0);
		// save resultant PDF file
		doc.save("Z-Order_Test.pdf");
	}

	private static void addRectangle(Page page, float x, float y, float width, float height, Color color, int zindex) {
		// create graph object with dimensions same as specified for Rectangle object
		Graph graph = new Graph(width, height);
		// can we change the position of graph instance
		graph.setChangePosition(false);
		// set Left coordinate position for Graph instance
		graph.setLeft(x);
		// set Top coordinate position for Graph object
		graph.setTop(y);
		// Add a rectangle inside the "graph"
		Rectangle rect = new Rectangle(0, 0, width, height);
		// set rectangle fill color
		rect.getGraphInfo().setFillColor(color);
		// color of graph object
		rect.getGraphInfo().setColor(color);
		// add rectangle to shapes collection of graph instance
		graph.getShapes().add(rect);
		// set Z-Index for rectangle object
		graph.setZIndex(zindex);
		// add graph to paragraphs collection of page object
		page.getParagraphs().add(graph);
	}
}
