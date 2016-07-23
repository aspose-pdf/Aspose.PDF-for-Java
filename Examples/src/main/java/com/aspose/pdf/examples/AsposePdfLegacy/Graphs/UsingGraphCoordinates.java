package com.aspose.pdf.examples.AsposePdfLegacy.Graphs;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import aspose.pdf.Curve;
import aspose.pdf.Graph;
import aspose.pdf.Pdf;
import aspose.pdf.Section;

public class UsingGraphCoordinates {

	public static void main(String[] args) throws IOException {
		// Instantiate a Pdf document object
		Pdf pdf1 = new Pdf();
		// Add a section to the Pdf document
		Section sec1 = pdf1.getSections().add();
		// Create a graph object in the section with Width=100 and Height=400
		Graph graph1 = new Graph(sec1, 400, 400);
		// Add the graph object to the paragraphs collection of the section
		sec1.getParagraphs().add(graph1);
		// Create an array containing the (X,Y) values of 4 control points required to position a curve
		float[] posArr = new float[] { 0, 0, 200, 80, 300, 40, 350, 90 };
		// Create a curve in the graph with the coordinates given as an array to the constructor of curve class
		Curve curve1 = new Curve(posArr);
		// Add the curve shape into the shapes collection of the graph
		graph1.getShapes().add(curve1);
		// Save the Pdf
		FileOutputStream out = new FileOutputStream(new File("Unicode.pdf"));
		pdf1.save(out);
	}
}
