package com.aspose.pdf.examples.workingwithpages;

import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.Rectangle;
import com.aspose.pdf.Rotation;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;

public final class ChangeSizeExamples {
    private ChangeSizeExamples() {
    }

    public static void setPageSize(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            Page page = document.getPages().get_Item(1);
            printBoxes("Before set", page);
            page.setPageSize(597.6, 842.4);
            printBoxes("After set", page);
            document.save(outputFile.toString());
        }
    }

    public static void getPageSize(Path inputFile) {
        try (Document document = new Document(inputFile.toString())) {
            Rectangle rectangle = document.getPages().get_Item(1).getPageRect(true);
            System.out.println(rectangle.getWidth() + " : " + rectangle.getHeight());
        }
    }

    public static void getPageSizeRotation(Path inputFile) {
        try (Document document = new Document(inputFile.toString())) {
            Page page = document.getPages().get_Item(1);
            page.setRotate(Rotation.on90);
            Rectangle rectangle = page.getPageRect(false);
            System.out.println(rectangle.getWidth() + " : " + rectangle.getHeight());
            rectangle = page.getPageRect(true);
            System.out.println(rectangle.getWidth() + " : " + rectangle.getHeight());
        }
    }

    private static void printBoxes(String title, Page page) {
        System.out.println(title);
        System.out.println("CropBox: " + page.getCropBox().getWidth() + " x " + page.getCropBox().getHeight());
        System.out.println("TrimBox: " + page.getTrimBox().getWidth() + " x " + page.getTrimBox().getHeight());
        System.out.println("ArtBox: " + page.getArtBox().getWidth() + " x " + page.getArtBox().getHeight());
        System.out.println("BleedBox: " + page.getBleedBox().getWidth() + " x " + page.getBleedBox().getHeight());
        System.out.println("MediaBox: " + page.getMediaBox().getWidth() + " x " + page.getMediaBox().getHeight());
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_pages");
        Path inputFile = dirs.inputFile("sample.pdf");

        ExampleRunner.run("set_page_size", () -> setPageSize(inputFile, dirs.outputFile("set_page_size_out.pdf")));
        ExampleRunner.run("get_page_size", () -> getPageSize(inputFile));
        ExampleRunner.run("get_page_size_rotation", () -> getPageSizeRotation(inputFile));

        System.out.println();
        System.out.println("All page extraction examples finished. Check output in " + dirs.getOutputDir());
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
