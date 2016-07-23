package com.aspose.pdf.examples.AsposePdfExamples.Text;

import com.aspose.pdf.Color;
import com.aspose.pdf.Document;
import com.aspose.pdf.GraphInfo;
import com.aspose.pdf.Note;
import com.aspose.pdf.Page;
import com.aspose.pdf.TextFragment;

public class FootNotesAndEndNotes {

	public static void main(String[] args) {
		customLineStyleForFootNote();
		customizeFootnoteLabel();
		howToCreateEndNotes();
	}

	public static void customLineStyleForFootNote() {
		String myDir = "PathToDir";
		// create Document instance
		Document doc = new Document();
		// add page to pages collection of PDF
		Page page = doc.getPages().add();
		// create GraphInfo object
		GraphInfo graph = new GraphInfo();
		// set line width as 2
		graph.setLineWidth(2);
		// set the color for graph object
		graph.setColor(Color.getRed());
		// set dash array value as 3
		graph.setDashArray(new int[] { 3 });
		// set dash phase value as 1
		graph.setDashPhase(1);
		// set footnote line style for page as graph
		page.setNoteLineStyle(graph);
		// create TextFragment instance
		TextFragment text = new TextFragment("Hello World");
		// set FootNote value for TextFragment
		text.setFootNote(new Note("foot note for test text 1"));
		// add TextFragment to paragraphs collection of first page of document
		page.getParagraphs().add(text);
		// create second TextFragment
		text = new TextFragment("Aspose.Pdf for .NET");
		// set FootNote for second text fragment
		text.setFootNote(new Note("foot note for test text 2"));
		// add second text fragment to paragraphs collection of PDF file
		page.getParagraphs().add(text);
		// save the PDF file
		doc.save(myDir + "CustomFootNote_Line.pdf");
	}

	public static void customizeFootnoteLabel() {
		String myDir = "PathToDir";
		// create Document instance
		Document doc = new Document();
		// add page to pages collection of PDF
		Page page = doc.getPages().add();
		// create GraphInfo object
		GraphInfo graph = new GraphInfo();
		// set line width as 2
		graph.setLineWidth(2);
		// set the color for graph object
		graph.setColor(Color.getRed());
		// set dash array value as 3
		graph.setDashArray(new int[] { 3 });
		// set dash phase value as 1
		graph.setDashPhase(1);
		// set footnote line style for page as graph
		page.setNoteLineStyle(graph);
		// create TextFragment instance
		TextFragment text = new TextFragment("Hello World");
		// set FootNote value for TextFragment
		text.setFootNote(new Note("foot note for test text 1"));
		// specify custom label for FootNote
		text.getFootNote().setText("Aspose(2015)");
		// add TextFragment to paragraphs collection of first page of document
		page.getParagraphs().add(text);
		// save the PDF file
		doc.save(myDir + "CustomFootNote_Line.pdf");
	}

	public static void howToCreateEndNotes() {
		String myDir = "PathToDir";
		// create Document instance
		Document doc = new Document();
		// add page to pages collection of PDF
		Page page = doc.getPages().add();
		// create TextFragment instance
		TextFragment text = new TextFragment("Hello World");
		// set FootNote value for TextFragment
		text.setEndNote(new Note("sample End note"));
		// specify custom label for FootNote
		text.getEndNote().setText(" Aspose(2015)");
		// add TextFragment to paragraphs collection of first page of document
		page.getParagraphs().add(text);
		// save the PDF file
		doc.save(myDir + "EndNote.pdf");
	}
}
