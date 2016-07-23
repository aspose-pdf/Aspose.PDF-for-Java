package com.aspose.pdf.examples.AsposePdfExamples.Graphs;

import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.drawing.Graph;
import com.aspose.pdf.drawing.Line;

public class AddLineObjectToPDF {

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
		Line line = new Line(new float[] { 100, 100, 200, 100 });
		// Specify fill color for Graph object
		line.getGraphInfo().setDashArray(new int[] { 0, 1, 0 });
		line.getGraphInfo().setDashPhase(1);
		// Add rectangle object to shapes collection of Graph object
		graph.getShapes().add(line);
		// Save PDF file
		doc.save("LineAdded.pdf");
	}

}
