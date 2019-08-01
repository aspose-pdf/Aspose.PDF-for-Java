package com.aspose.pdf.examples.AsposePdfExamples.TaggedPDFs;

import com.aspose.pdf.*;
import com.aspose.pdf.examples.AsposePdfExamples.Utilities.Utils;
import com.aspose.pdf.tagged.ITaggedContent;
import com.aspose.pdf.tagged.logicalstructure.AttributeKey;
import com.aspose.pdf.tagged.logicalstructure.AttributeOwnerStandard;
import com.aspose.pdf.tagged.logicalstructure.StructureAttributes;
import com.aspose.pdf.tagged.logicalstructure.elements.*;
import com.aspose.pdf.tagged.logicalstructure.elements.bls.*;

public class CreateTableElement {
    public static void main(String[] args) {
        // ExStart:1
        // The path to the documents directory.
        String path = Utils.getDataDir() + "TaggedPDFs\\";

        // Create document
        Document document = new Document();
        ITaggedContent taggedContent = document.getTaggedContent();

        taggedContent.setTitle("Example table");
        taggedContent.setLanguage("en-US");

        // Get root structure element
        StructureElement rootElement = taggedContent.getRootElement();


        TableElement tableElement = taggedContent.createTableElement();
        rootElement.appendChild(tableElement);

        tableElement.setBorder(new BorderInfo(BorderSide.All, 1.2F, Color.getDarkBlue()));

        TableTHeadElement tableTHeadElement = tableElement.createTHead();
        TableTBodyElement tableTBodyElement = tableElement.createTBody();
        TableTFootElement tableTFootElement = tableElement.createTFoot();
        int rowCount = 50;
        int colCount = 4;
        int rowIndex;
        int colIndex;

        TableTRElement headTrElement = tableTHeadElement.createTR();
        headTrElement.setAlternativeText("Head Row");

        headTrElement.setBackgroundColor(Color.getLightGray());

        for (colIndex = 0; colIndex < colCount; colIndex++)
        {
            TableTHElement thElement = headTrElement.createTH();
            thElement.setText(String.format("Head %s", colIndex));

            thElement.setBackgroundColor(Color.getGreenYellow());
            thElement.setBorder(new BorderInfo(BorderSide.All, 4.0F, Color.getLightGray()));

            thElement.setMargin(new MarginInfo(16.0, 2.0, 8.0, 2.0));

            thElement.setAlignment(HorizontalAlignment.Right);
        }

        for (rowIndex = 0; rowIndex < rowCount; rowIndex++)
        {
            TableTRElement trElement = tableTBodyElement.createTR();
            trElement.setAlternativeText(String.format("Row %s", rowIndex));

            for (colIndex = 0; colIndex < colCount; colIndex++)
            {
                int colSpan = 1;
                int rowSpan = 1;

                if (colIndex == 1 && rowIndex == 1)
                {
                    colSpan = 2;
                    rowSpan = 2;
                }
                else if (colIndex == 2 && (rowIndex == 1 || rowIndex == 2))
                {
                    continue;
                }
                else if (rowIndex == 2 && (colIndex == 1 || colIndex == 2))
                {
                    continue;
                }

                TableTDElement tdElement = trElement.createTD();
                tdElement.setText(String.format("Cell [%s, %s]", rowIndex, colIndex));


                tdElement.setBackgroundColor(Color.getYellow());
                tdElement.setBorder(new BorderInfo(BorderSide.All, 4.0F, Color.getGray()));


                tdElement.setMargin(new MarginInfo(8.0, 2.0, 8.0, 2.0));

                tdElement.setAlignment(HorizontalAlignment.Center);

                TextState cellTextState = new TextState();
                cellTextState.setForegroundColor(Color.getDarkBlue());
                cellTextState.setFontSize(7.5F);
                cellTextState.setFontStyle(FontStyles.Bold);
                cellTextState.setFont(FontRepository.findFont("Arial"));
                tdElement.setDefaultCellTextState(cellTextState);

                tdElement.isWordWrapped();
                tdElement.setVerticalAlignment(VerticalAlignment.Center);

                tdElement.setColSpan(colSpan);
                tdElement.setRowSpan(rowSpan);
            }
        }

        TableTRElement footTrElement = tableTFootElement.createTR();
        footTrElement.setAlternativeText("Foot Row");

        footTrElement.setBackgroundColor(Color.getLightSeaGreen());

        for (colIndex = 0; colIndex < colCount; colIndex++)
        {
            TableTDElement tdElement = footTrElement.createTD();
            tdElement.setText(String.format("Foot %s", colIndex));

            tdElement.setAlignment(HorizontalAlignment.Center);
            tdElement.getStructureTextState().setFontSize(7F);
            tdElement.getStructureTextState().setFontStyle(FontStyles.Bold);
        }


        StructureAttributes tableAttributes = tableElement.getAttributes().getAttributes(AttributeOwnerStandard.Table);
        StructureAttribute summaryAttribute = new StructureAttribute(AttributeKey.Summary);
        summaryAttribute.setStringValue("The summary text for table");
        tableAttributes.setAttribute(summaryAttribute);


        // Save Tagged Pdf Document
        document.save(path + "CreateTableElement.pdf");
        // ExEnd:1
    }
}
