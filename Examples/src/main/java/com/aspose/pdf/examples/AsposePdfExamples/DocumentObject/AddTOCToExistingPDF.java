package com.aspose.pdf.examples.AsposePdfExamples.DocumentObject;

import com.aspose.pdf.Document;
import com.aspose.pdf.FontStyles;
import com.aspose.pdf.Heading;
import com.aspose.pdf.Page;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.TextSegment;
import com.aspose.pdf.TocInfo;

public class AddTOCToExistingPDF {

    public static void main(String[] args) {
        // Load an existing PDF files
        Document doc = new Document("source.pdf");
        // Get access to first page of PDF file
        Page tocPage = doc.getPages().insert(1);
        // Create object to represent TOC information
        TocInfo tocInfo = new TocInfo();
        TextFragment title = new TextFragment("Table Of Contents");
        title.getTextState().setFontSize(20);
        title.getTextState().setFontStyle(FontStyles.Bold);
        // Set the title for TOC
        tocInfo.setTitle(title);
        tocPage.setTocInfo(tocInfo);
        // Create string objects which will be used as TOC elements
        String[] titles = new String[4];
        titles[0] = "First page";
        titles[1] = "Second page";
        titles[2] = "Third page";
        titles[3] = "Fourth page";
        for (int i = 0; i < 4; i++) {
            // Create Heading object
            Heading heading2 = new Heading(1);
            TextSegment segment2 = new TextSegment();
            heading2.setTocPage(tocPage);
            heading2.getSegments().add(segment2);
            // Specify the destination page for heading object
            heading2.setDestinationPage(doc.getPages().get_Item(i + 2));
            // Destination page
            heading2.setTop(doc.getPages().get_Item(i + 2).getRect().getHeight());
            // Destination coordinate
            segment2.setText(titles[i]);
            // Add heading to page containing TOC
            tocPage.getParagraphs().add(heading2);
        }
        // Save the updated document
        doc.save("TOC_Output_Java.pdf");
    }
}
