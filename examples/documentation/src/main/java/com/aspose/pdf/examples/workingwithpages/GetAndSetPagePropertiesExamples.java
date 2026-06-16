package com.aspose.pdf.examples.workingwithpages;

import com.aspose.pdf.ColorType;
import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.Rectangle;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;

public final class GetAndSetPagePropertiesExamples {
    private GetAndSetPagePropertiesExamples() {
    }

    public static void getPageCount(Path inputFile) {
        try (Document document = new Document(inputFile.toString())) {
            System.out.println("Page Count: " + document.getPages().size());
        }
    }

    public static void getPageCountWithoutSaving(Path inputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();
            for (int i = 0; i < 300; i++) {
                page.getParagraphs().add(new TextFragment("Pages count test"));
            }
            document.processParagraphs();
            System.out.println("Number of pages in document = " + document.getPages().size());
        }
    }

    public static void getPageProperties(Path inputFile) {
        try (Document document = new Document(inputFile.toString())) {
            Page page = document.getPages().get_Item(1);
            Map<String, Rectangle> boxes = new LinkedHashMap<>();
            boxes.put("ArtBox", page.getArtBox());
            boxes.put("BleedBox", page.getBleedBox());
            boxes.put("CropBox", page.getCropBox());
            boxes.put("MediaBox", page.getMediaBox());
            boxes.put("TrimBox", page.getTrimBox());
            boxes.put("Rect", page.getRect());

            for (Map.Entry<String, Rectangle> entry : boxes.entrySet()) {
                Rectangle box = entry.getValue();
                System.out.println(entry.getKey() + " : Height=" + box.getHeight()
                        + ",Width=" + box.getWidth()
                        + ",LLX=" + box.getLLX()
                        + ",LLY=" + box.getLLY()
                        + ",URX=" + box.getURX()
                        + ",URY=" + box.getURY());
            }

            System.out.println("Page Number : " + page.getNumber());
            System.out.println("Rotate : " + page.getRotate());
        }
    }

    public static void getPageColorType(Path inputFile) {
        try (Document document = new Document(inputFile.toString())) {
            for (int pageNumber = 1; pageNumber <= document.getPages().size(); pageNumber++) {
                ColorType pageColorType = document.getPages().get_Item(pageNumber).getColorType();
                String colorDescription = switch (pageColorType) {
                    case BlackAndWhite -> "Black and white";
                    case Grayscale -> "Gray Scale";
                    case Rgb -> "RGB";
                    case Undefined -> "undefined";
                };
                System.out.println("Page # " + pageNumber + " is " + colorDescription + ".");
            }
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_pages");
        Path inputFile = dirs.inputFile("sample4pages.pdf");

        ExampleRunner.run("get_page_count", () -> getPageCount(inputFile));
        ExampleRunner.run("get_page_count_without_saving", () -> getPageCountWithoutSaving(inputFile));
        ExampleRunner.run("get_page_properties", () -> getPageProperties(inputFile));
        ExampleRunner.run("get_page_color_type", () -> getPageColorType(inputFile));

        System.out.println();
        System.out.println("All examples of getting page properties are complete.");
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
