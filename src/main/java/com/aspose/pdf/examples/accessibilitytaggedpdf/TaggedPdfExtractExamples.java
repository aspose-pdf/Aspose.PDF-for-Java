package com.aspose.pdf.examples.accessibilitytaggedpdf;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;
import com.aspose.pdf.tagged.ITaggedContent;
import com.aspose.pdf.tagged.logicalstructure.ElementList;
import com.aspose.pdf.tagged.logicalstructure.elements.Element;
import com.aspose.pdf.tagged.logicalstructure.elements.StructureElement;

import java.nio.file.Path;

public final class TaggedPdfExtractExamples {
    private TaggedPdfExtractExamples() {
    }

    public static void getTaggedContent(Path outputFile) {
        try (Document document = new Document()) {
            ITaggedContent taggedContent = document.getTaggedContent();
            taggedContent.setTitle("Simple Tagged Pdf Document");
            taggedContent.setLanguage("en-US");
            document.save(outputFile.toString());
        }
    }

    public static void getRootStructure(Path outputFile) {
        try (Document document = new Document()) {
            ITaggedContent taggedContent = document.getTaggedContent();
            taggedContent.setTitle("Tagged Pdf Document");
            taggedContent.setLanguage("en-US");

            System.out.println("StructTreeRootElement: " + taggedContent.getStructTreeRootElement());
            System.out.println("RootElement: " + taggedContent.getRootElement());

            document.save(outputFile.toString());
        }
    }

    public static void accessChildElements(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            ITaggedContent taggedContent = document.getTaggedContent();

            ElementList elementList = taggedContent.getStructTreeRootElement().getChildElements();
            for (Object element : elementList) {
                if (element instanceof StructureElement structureElement) {
                    System.out.println("StructureElement properties - "
                            + "title: " + structureElement.getTitle()
                            + ", language: " + structureElement.getLanguage()
                            + ", actual_text: " + structureElement.getActualText()
                            + ", expansion_text: " + structureElement.getExpansionText()
                            + ", alternative_text: " + structureElement.getAlternativeText());
                }
            }

            Element firstChild = taggedContent.getRootElement().getChildElements().get_Item(1);
            for (Object element : firstChild.getChildElements()) {
                if (element instanceof StructureElement structureElement) {
                    structureElement.setTitle("title");
                    structureElement.setLanguage("fr-FR");
                    structureElement.setActualText("actual text");
                    structureElement.setExpansionText("exp");
                    structureElement.setAlternativeText("alt");
                }
            }

            document.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("accessibility_tagged_pdf");

        ExampleRunner.run("Get Tagged Content",
                () -> getTaggedContent(dirs.outputFile("tagged_pdf_content.pdf")));
        ExampleRunner.run("Get Root Structure",
                () -> getRootStructure(dirs.outputFile("root_structure.pdf")));
        ExampleRunner.run("Access Child Elements",
                () -> accessChildElements(dirs.inputFile("StructureElementsTree.pdf"),
                        dirs.outputFile("access_child_elements.pdf")));

        System.out.println();
        System.out.println("All Extract Tagged Content examples finished.");
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
