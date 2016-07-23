package com.aspose.pdf.examples.AsposePdfLegacy.Graphs;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import aspose.pdf.Graph;
import aspose.pdf.Pdf;
import aspose.pdf.Rectangle;
import aspose.pdf.Section;

public class GraphsRotationAndScaling {

	public static void main(String[] args) throws IOException {
		// Instantiate Pdf document by calling its empty constructor
		Pdf pdf1 = new Pdf();
		// Add a section to the Pdf document
		Section sec1 = pdf1.getSections().add();
		// Create a graph object in the section with Width=100 and Height=400
		Graph graph1 = new Graph(sec1, 400, 400);
		// Add the graph object to the paragraphs collection of the section
		sec1.getParagraphs().add(graph1);
		// Create a rectangle shape with specified coordinates
		Rectangle rect1 = new Rectangle(85, 100, 100, 50);
		// Add the rectangle into the shapes collection of the 1st graph
		graph1.getShapes().add(rect1);
		// Create 2nd graph in the section with width=100 and height=400
		Graph graph2 = new Graph(sec1, 400, 400);
		// the Graph will display in a new page
		graph2.isFirstParagraph(true);
		// Add the graph object to the paragraphs collection of the section
		sec1.getParagraphs().add(graph2);
		// Create a rectangle shape with specified coordinates
		Rectangle rect2 = new Rectangle(85, 100, 100, 50);
		// Add the rectangle into the shapes collection of the 2nd graph
		graph2.getShapes().add(rect2);
		// Rotate the 2nd graph to 30 degree using RotationAngle property
		graph2.getGraphInfo().setRotationAngle(30);
		// Create 3rd graph in the section with width=100 and height=400
		Graph graph3 = new Graph(sec1, 400, 400);
		// the Graph will display in a new page
		graph3.isFirstParagraph(true);
		// Add 3rd graph into the paragraphs collection of the section
		sec1.getParagraphs().add(graph3);
		// Create a rectangle shape with specified coordinates
		Rectangle rect3 = new Rectangle(85, 100, 100, 50);
		// Add the rectangle into the shapes collection of the 3rd graph
		graph3.getShapes().add(rect3);
		// Adjust the horizontal size of the 3rd graph using ScalingRateX property
		graph3.getGraphInfo().setScalingRateX(1.5f);
		// Save the Pdf file
		FileOutputStream out = new FileOutputStream(new File("Unicode.pdf"));
		pdf1.save(out);
	}
}
