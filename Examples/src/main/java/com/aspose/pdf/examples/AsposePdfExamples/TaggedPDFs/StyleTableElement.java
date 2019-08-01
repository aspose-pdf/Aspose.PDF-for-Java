package com.aspose.pdf.examples.AsposePdfExamples.TaggedPDFs;

import com.aspose.pdf.*;
import com.aspose.pdf.examples.AsposePdfExamples.Utilities.Utils;
import com.aspose.pdf.tagged.ITaggedContent;
import com.aspose.pdf.tagged.logicalstructure.AttributeKey;
import com.aspose.pdf.tagged.logicalstructure.AttributeOwnerStandard;
import com.aspose.pdf.tagged.logicalstructure.StructureAttributes;
import com.aspose.pdf.tagged.logicalstructure.elements.StructureAttribute;
import com.aspose.pdf.tagged.logicalstructure.elements.StructureElement;
import com.aspose.pdf.tagged.logicalstructure.elements.bls.*;

public class StyleTableElement {
    public static void main(String[] args) {
        // ExStart:1
        // The path to the documents directory.
        String path = Utils.getDataDir() + "TaggedPDFs\\";

        // Create document
        Document document = new Document();
        ITaggedContent taggedContent = document.getTaggedContent();

        taggedContent.setTitle("Example table style");
        taggedContent.setLanguage("en-US");

        // Get root structure element
        StructureElement rootElement = taggedContent.getRootElement();


        // Create table structure element
        TableElement tableElement = taggedContent.createTableElement();
        rootElement.appendChild(tableElement);


        tableElement.setBackgroundColor(Color.getBeige());
        tableElement.setBorder(new BorderInfo(BorderSide.All, 0.80F, Color.getGray()));
        tableElement.setAlignment(HorizontalAlignment.Center);
        tableElement.setBroken(TableBroken.Vertical);
        tableElement.setColumnAdjustment(ColumnAdjustment.AutoFitToWindow);
        tableElement.setColumnWidths("80 80 80 80 80");
        tableElement.setDefaultCellBorder(new BorderInfo(BorderSide.All, 0.50F, Color.getDarkBlue()));
        tableElement.setDefaultCellPadding(new MarginInfo(16.0, 2.0, 8.0, 2.0));
        tableElement.getDefaultCellTextState().setForegroundColor(Color.getDarkCyan());
        tableElement.getDefaultCellTextState().setFontSize(8F);
        tableElement.setDefaultColumnWidth("70");

        tableElement.setBroken(false);
        tableElement.setBordersIncluded(true);

        tableElement.setLeft(0F);
        tableElement.setTop(40F);

        tableElement.setRepeatingColumnsCount(2);
        tableElement.setRepeatingRowsCount(3);
        TextState rowStyle = new TextState();
        rowStyle.setBackgroundColor(Color.getLightCoral());
        tableElement.setRepeatingRowsStyle(rowStyle);




        TableTHeadElement tableTHeadElement = tableElement.createTHead();
        TableTBodyElement tableTBodyElement = tableElement.createTBody();
        TableTFootElement tableTFootElement = tableElement.createTFoot();
        int rowCount = 10;
        int colCount = 5;
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

            for (colIndex = 0; colIndex < colCount; colIndex++)
            {
                TableTDElement tdElement = trElement.createTD();
                tdElement.setText(String.format("Cell [%s, %s]", rowIndex, colIndex));
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
        document.save(path + "StyleTableElement.pdf");
        // ExEnd:1
    }
}
