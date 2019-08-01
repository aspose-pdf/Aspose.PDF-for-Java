package com.aspose.pdf.examples.AsposePdfExamples.TaggedPDFs;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.AsposePdfExamples.Utilities.Utils;
import com.aspose.pdf.tagged.ITaggedContent;
import com.aspose.pdf.tagged.logicalstructure.ElementList;
import com.aspose.pdf.tagged.logicalstructure.elements.Element;
import com.aspose.pdf.tagged.logicalstructure.elements.StructureElement;

public class AccessChildrenElements {
    public static void main(String[] args) {
        // ExStart:AccessChildrenElements
        String path = Utils.getDataDir() + "TaggedPDFs\\";
        // Open Pdf Document
        Document document = new Document( path +"StructureElements.pdf");

        // Get Content for work with TaggedPdf
        ITaggedContent taggedContent = document.getTaggedContent();

        // Access to root element(s)
        ElementList elementList = taggedContent.getStructTreeRootElement().getChildElements();
        for (Element element : elementList)
        {
            if (element instanceof StructureElement)
            {
                StructureElement structureElement =  (StructureElement)element;

                // Get properties
                String title = structureElement.getTitle();
                String language = structureElement.getLanguage();
                String actualText = structureElement.getActualText();
                String expansionText = structureElement.getExpansionText();
                String alternativeText = structureElement.getAlternativeText();
            }
        }

        // Access to children elements of first element in root element
        elementList = taggedContent.getRootElement().getChildElements().get_Item(1).getChildElements();
        for (Element element : elementList)
        {
            if (element instanceof StructureElement)
            {
                StructureElement structureElement = (StructureElement)element;

                // Set properties
                structureElement.setTitle("title");
                structureElement.setLanguage("fr-FR");
                structureElement.setActualText("actual text");
                structureElement.setExpansionText("exp");
                structureElement.setAlternativeText("alt");
            }
        }

        // Save Tagged Pdf Document
        document.save( path +"AccessChildrenElements.pdf");

        // ExEnd:AccessChildrenElements
        }
}
