package com.aspose.pdf.examples.AsposePdfLegacy.AdvanceFeatures;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import aspose.pdf.Attachment;
import aspose.pdf.AttachmentType;
import aspose.pdf.Graph;
import aspose.pdf.Pdf;
import aspose.pdf.Rectangle;
import aspose.pdf.RectangleArea;
import aspose.pdf.Section;
import aspose.pdf.Text;

public class CustomPositioning {

	public static void main(String[] args) throws IOException {
		// Instantiate a Pdf object by calling its empty constructor
		Pdf pdf1 = new Pdf();
		// Create a section in the Pdf object
		Section sec1 = pdf1.getSections().add();
		// Create a new text paragraph and pass the text to its constructor as argument
		Text t1 = new Text(sec1, "This is a text paragraph.");
		// Set the id of the paragraph to "text1" so that it can referenced uniquely
		// text1.ID = "text1";
		// Add this left hanging text paragraph to the section
		sec1.getParagraphs().add(t1);
		// Create a graph object in the section with Width=100 and Height=400
		Graph graph1 = new Graph(sec1, 400, 400);
		// Add the circle in the shapes collection of the graph
		graph1.getShapes().add(new Rectangle(100, 300, 200, 50));
		// Add the graph object to the paragraphs collection of the section
		sec1.getParagraphs().add(graph1);
		// Instantiate attachment instance by calling its empty constructor
		Attachment noteAttachment = new Attachment();
		// Add attachment in the paragraphs collection of the section
		sec1.getParagraphs().add(noteAttachment);
		// Set attachment type to File using AttachmentType enumeration
		noteAttachment.setAttachmentType(AttachmentType.Note);
		// Set the content of the note annotation
		noteAttachment.setNoteContent("This is a note.");
		// Set the title or heading of the note
		noteAttachment.setNoteHeading("The title");
		// set the note position
		noteAttachment.setNoteWindowPosition(new RectangleArea(215, 770, 0, 0));
		// Set the note to be opened when PDF document is opened
		noteAttachment.isNoteOpen(true);
		FileOutputStream out = new FileOutputStream(new File("Test.pdf"));
		pdf1.save(out);
	}
}
