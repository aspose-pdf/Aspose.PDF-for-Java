package com.aspose.pdf.examples.AsposePdfExamples.TaggedPDFs;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.AsposePdfExamples.Utilities.Utils;
import com.aspose.pdf.tagged.ITaggedContent;
import com.aspose.pdf.tagged.logicalstructure.elements.StructureElement;
import com.aspose.pdf.tagged.logicalstructure.elements.grouping.ArtElement;
import com.aspose.pdf.tagged.logicalstructure.elements.grouping.DivElement;
import com.aspose.pdf.tagged.logicalstructure.elements.grouping.SectElement;

public class CreateStructureElementTree {
    public static void main(String[] args) {
        // ExStart:CreateStructureElementTree
        // The path to the documents directory.
        String path = Utils.getDataDir() + "TaggedPDFs\\";
        // Create Pdf Document
        Document document = new Document();

        // Get Content for work with TaggedPdf
        ITaggedContent taggedContent = document.getTaggedContent();

        // Set Title and Language for Documnet
        taggedContent.setTitle("Tagged Pdf Document");
        taggedContent.setLanguage("en-US");

        // Get root structure element (Document)
        StructureElement rootElement = taggedContent.getRootElement();

        // Create Logical Structure
        SectElement sect1 = taggedContent.createSectElement();
        rootElement.appendChild(sect1);

        SectElement sect2 = taggedContent.createSectElement();
        rootElement.appendChild(sect2);

        DivElement div11 = taggedContent.createDivElement();
        sect1.appendChild(div11);

        DivElement div12 = taggedContent.createDivElement();
        sect1.appendChild(div12);

        ArtElement art21 = taggedContent.createArtElement();
        sect2.appendChild(art21);

        ArtElement art22 = taggedContent.createArtElement();
        sect2.appendChild(art22);

        DivElement div211 = taggedContent.createDivElement();
        art21.appendChild(div211);

        DivElement div212 = taggedContent.createDivElement();
        art21.appendChild(div212);

        DivElement div221 = taggedContent.createDivElement();
        art22.appendChild(div221);

        DivElement div222 = taggedContent.createDivElement();
        art22.appendChild(div222);

        SectElement sect3 = taggedContent.createSectElement();
        rootElement.appendChild(sect3);

        DivElement div31 = taggedContent.createDivElement();
        sect3.appendChild(div31);

        // Save Tagged Pdf Document
        document.save(path + "StructureElementsTree.pdf");
        // ExEnd:CreateStructureElementTree
    }

}
