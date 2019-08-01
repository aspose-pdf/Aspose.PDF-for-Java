package com.aspose.pdf.examples.AsposePdfExamples.TaggedPDFs;

import com.aspose.pdf.*;
import com.aspose.pdf.examples.AsposePdfExamples.Utilities.Utils;
import com.aspose.pdf.tagged.ITaggedContent;
import com.aspose.pdf.tagged.logicalstructure.elements.StructureElement;
import com.aspose.pdf.tagged.logicalstructure.elements.bls.*;

public class StyleTableRow {
    public static void main(String[] args) {
        // ExStart:1
        // The path to the documents directory.
        String path = Utils.getDataDir() + "TaggedPDFs\\";

        // Create document
        Document document = new Document();
        ITaggedContent taggedContent = document.getTaggedContent();

        taggedContent.setTitle("Example table row style");
        taggedContent.setLanguage("en-US");

        // Get root structure element
        StructureElement rootElement = taggedContent.getRootElement();


        // Create table structure element
        TableElement tableElement = taggedContent.createTableElement();
        rootElement.appendChild(tableElement);


        TableTHeadElement tableTHeadElement = tableElement.createTHead();
        TableTBodyElement tableTBodyElement = tableElement.createTBody();
        TableTFootElement tableTFootElement = tableElement.createTFoot();
        int rowCount = 7;
        int colCount = 3;
        int rowIndex;
        int colIndex;

        TableTRElement headTrElement = tableTHeadElement.createTR();
        headTrElement.setAlternativeText("Head Row");

        for (colIndex = 0; colIndex < colCount; colIndex++)
        {
            TableTHElement thElement = headTrElement.createTH();
            thElement.setText(String.format("Head %s", colIndex));
        }

        for (rowIndex = 0; rowIndex < rowCount; rowIndex++)
        {
            TableTRElement trElement = tableTBodyElement.createTR();
            trElement.setAlternativeText(String.format("Row %s", rowIndex));

            trElement.setBackgroundColor(Color.getLightSeaGreen());
            trElement.setBorder(new BorderInfo(BorderSide.All, 0.75F, Color.getDarkGray()));

            trElement.setDefaultCellBorder(new BorderInfo(BorderSide.All, 0.50F, Color.getBlue()));
            trElement.setMinRowHeight(100.0);
            trElement.setFixedRowHeight(120.0);
            trElement.setRowBroken(true);

            TextState cellTextState = new TextState();
            cellTextState.setForegroundColor(Color.getRed());
            trElement.setDefaultCellTextState(cellTextState);

            trElement.setDefaultCellPadding(new MarginInfo(16.0, 2.0, 8.0, 2.0));
            trElement.setVerticalAlignment(VerticalAlignment.Bottom);

            for (colIndex = 0; colIndex < colCount; colIndex++)
            {
                TableTDElement tdElement = trElement.createTD();
                tdElement.setText(String.format("Cell [{0}, {1}]", rowIndex, colIndex));
            }
        }

        TableTRElement footTrElement = tableTFootElement.createTR();
        footTrElement.setAlternativeText("Foot Row");

        for (colIndex = 0; colIndex < colCount; colIndex++)
        {
            TableTDElement tdElement = footTrElement.createTD();
            tdElement.setText(String.format("Foot %s", colIndex));
        }



        // Save Tagged Pdf Document
        document.save(path + "StyleTableRow.pdf");
        // ExEnd:1
    }
}
