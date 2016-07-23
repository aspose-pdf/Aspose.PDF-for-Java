package com.aspose.pdf.examples.AsposePdfLegacy.AttachmentsAndAnnotations;

import aspose.pdf.Attachment;
import aspose.pdf.AttachmentType;
import aspose.pdf.Pdf;
import aspose.pdf.RectangleArea;
import aspose.pdf.Section;

public class CustomizeThePositionOfNotesPopUpWindow {

	public static void main(String[] args) {
		// Instntiate the Pdf object by calling its empty constructor
		Pdf pdf1 = new Pdf();
		// Create the section in the Pdf object
		Section sec1 = pdf1.getSections().add();
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
		noteAttachment.setNoteWindowPosition(new RectangleArea(36, 72, 0, 0));
		// Set the note to be opened when PDF document is opened
		noteAttachment.isNoteOpen(true);
	}
}
