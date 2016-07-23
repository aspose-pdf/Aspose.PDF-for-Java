package com.aspose.pdf.examples.AsposePdfLegacy.Graphs;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import aspose.pdf.Circle;
import aspose.pdf.Graph;
import aspose.pdf.Pdf;
import aspose.pdf.Section;

public class GraphsFormat {

	public static void main(String[] args) throws IOException {
		// Instantiate Pdf document by calling its empty constructor
		Pdf pdf1 = new Pdf();
		// Add a section to the Pdf document
		Section sec1 = pdf1.getSections().add();
		// Create a graph object in the section with Width=100 and Height=400
		Graph graph1 = new Graph(sec1, 400, 400);
		// Add the graph object to the paragraphs collection of the section
		sec1.getParagraphs().add(graph1);
		// Create a circle shape in the graph with X=200, Y=50 and Radius=30
		Circle circle1 = new Circle(200, 50, 30);
		// Add the circle in the shapes collection of the graph
		graph1.getShapes().add(circle1);
		// Set fill color of the circle using GraphInfo property of circle object
		circle1.getGraphInfo().setFillColor(new aspose.pdf.Color("Green"));
		// Enable the circle to be filled with the color specified above line
		circle1.getGraphInfo().isFilled(true);
		// Save the Pdf
		FileOutputStream out = new FileOutputStream(new File("Unicode.pdf"));
		pdf1.save(out);
	}
}
