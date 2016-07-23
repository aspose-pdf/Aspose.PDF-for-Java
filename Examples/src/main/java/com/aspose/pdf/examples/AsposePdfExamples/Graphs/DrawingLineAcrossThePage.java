package com.aspose.pdf.examples.AsposePdfExamples.Graphs;

import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.drawing.Graph;
import com.aspose.pdf.drawing.Line;

public class DrawingLineAcrossThePage {

	public static void main(String[] args) {
		// Create Document instance
		Document doc = new Document();
		// Add page to pages collection of PDF file
		Page page = doc.getPages().add();
		// set page margin on all sides as 0
		page.getPageInfo().getMargin().setLeft(0);
		page.getPageInfo().getMargin().setRight(0);
		page.getPageInfo().getMargin().setBottom(0);
		page.getPageInfo().getMargin().setTop(0);
		// create Graph object with Width and Height equal to page dimensions
		Graph graph = new Graph((float) page.getPageInfo().getWidth(), (float) page.getPageInfo().getHeight());
		// create first line object starting from Lower-Left to Top-Right corner of page
		Line line = new Line(new float[] { (float) page.getRect().getLLX(), 0, (float) page.getPageInfo().getWidth(), (float) page.getRect().getURY() });
		// add line to shapes collection of Graph object
		graph.getShapes().add(line);
		// draw line from Top-Left corner of page to Bottom-Right corner of page
		Line line2 = new Line(new float[] { 0, (float) page.getRect().getURY(), (float) page.getPageInfo().getWidth(), (float) page.getRect().getLLX() });
		// add line to shapes collection of Graph object
		graph.getShapes().add(line2);
		// add Graph object to paragraphs collection of page
		page.getParagraphs().add(graph);
		// save resultant PDF file
		doc.save("Line_Across_Page.pdf");
	}

}
