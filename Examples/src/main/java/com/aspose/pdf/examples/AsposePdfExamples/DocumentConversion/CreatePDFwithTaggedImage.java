package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.*;
import com.aspose.pdf.tagged.ITaggedContent;
import com.aspose.pdf.tagged.logicalstructure.elements.IllustrationElement;
import com.aspose.pdf.tagged.logicalstructure.elements.bls.HeaderElement;
import com.aspose.pdf.tagged.logicalstructure.elements.bls.ParagraphElement;

public class CreatePDFwithTaggedImage {
	public static void main(String[] args) {
        // ExStart:CreatePDFWithTaggedImage
        Document document = new Document();
        ITaggedContent taggedContent = document.getTaggedContent();

        taggedContent.setTitle("CreatePDFwithTaggedImage");
        taggedContent.setLanguage("en-US");

        IllustrationElement figure1 = taggedContent.createFigureElement();
        taggedContent.getRootElement().appendChild(figure1);
        figure1.setAlternativeText("Aspose Logo");
        figure1.setTitle("Image 1");
        figure1.setTag("Fig");
        // Add image with resolution 300 DPI (by default)
        figure1.setImage("aspose-logo.jpg");
        // Save PDF Document
        document.save("PDFwithTaggedImage.pdf");
        // ExEnd:CreatePDFWithTaggedImage
	}

}
