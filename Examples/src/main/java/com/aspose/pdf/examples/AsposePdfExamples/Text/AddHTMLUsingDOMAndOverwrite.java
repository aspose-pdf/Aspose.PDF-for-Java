package com.aspose.pdf.examples.AsposePdfExamples.Text;

import com.aspose.pdf.Document;
import com.aspose.pdf.HtmlFragment;
import com.aspose.pdf.Page;
import com.aspose.pdf.TextState;

public class AddHTMLUsingDOMAndOverwrite {
    public static void main(String[] args) {
        // ExStart:AddHTMLUsingDOMAndOverwrite
        // Instantiate Document object
        Document doc = new Document();
        // Add a page to pages collection of PDF file
        Page page = doc.getPages().add();
        // Instantiate HtmlFragment with HTML contnets
        HtmlFragment title = new HtmlFragment("<p style='font-family: Verdana'><b><i>Table contains text</i></b></p>");
        //Font-family from 'Verdana' will be reset to 'Arial'
        title.setTextState(new TextState("Arial"));
        title.setTextState(new TextState(20));
        // Set bottom margin information
        title.getMargin().setBottom(10);
        // Set top margin information
        title.getMargin().setTop(400);
        // Add HTML Fragment to paragraphs collection of page
        page.getParagraphs().add(title);
        // Save PDF file
        doc.save("AddHTMLUsingDOMAndOverwrite_out.pdf");
        // ExEnd:AddHTMLUsingDOMAndOverwrite
    }
}
