package com.aspose.pdf.examples.AsposePdfLegacy.AttachmentsAndAnnotations;

import aspose.pdf.Attachment;
import aspose.pdf.AttachmentType;
import aspose.pdf.Color;
import aspose.pdf.FileIconType;
import aspose.pdf.Pdf;
import aspose.pdf.Section;

public class AttachAnyFileToPDFDocument {

	public static void main(String[] args) {
		// Instntiate the Pdf object by calling its empty constructor
		Pdf pdf1 = new Pdf();
		// Create the section in the Pdf object
		Section sec1 = pdf1.getSections().add();
		// Instantiate attachment instance by calling its empty constructor
		Attachment fileAttachment = new Attachment();
		// Add attachment in the paragraphs collection of the section
		sec1.getParagraphs().add(fileAttachment);
		// Set attachment type to File using AttachmentType enumeration
		fileAttachment.setAttachmentType(AttachmentType.File);
		// Set the path of the attachment file
		fileAttachment.setAttachedFileName("ccitt.tif");
		// Set the file icon type to Graph
		fileAttachment.setFileIconType(FileIconType.Graph);
		// Set the color of the icon to Brown
		fileAttachment.setIconColor(new Color("Blue"));
	}
}
