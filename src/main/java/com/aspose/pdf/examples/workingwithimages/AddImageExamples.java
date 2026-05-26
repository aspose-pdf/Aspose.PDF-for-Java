package com.aspose.pdf.examples.workingwithimages;

import com.aspose.pdf.Document;
import com.aspose.pdf.ImageFilterType;
import com.aspose.pdf.Matrix;
import com.aspose.pdf.Page;
import com.aspose.pdf.Rectangle;
import com.aspose.pdf.XImage;
import com.aspose.pdf.XImageCollection;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;
import com.aspose.pdf.operators.ConcatenateMatrix;
import com.aspose.pdf.operators.Do;
import com.aspose.pdf.operators.GRestore;
import com.aspose.pdf.operators.GSave;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public final class AddImageExamples {
    private AddImageExamples() {
    }

    public static void addImage(Path imageFile, Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();
            page.addImage(imageFile.toString(), new Rectangle(20, 730, 120, 830, true));
            document.save(outputFile.toString());
        }
    }

    public static void addImageUsingOperators(Path imageFile, Path outputFile) throws Exception {
        try (Document document = new Document();
             InputStream imageStream = Files.newInputStream(imageFile)) {
            Page page = document.getPages().add();
            page.setPageSize(842, 595);

            XImageCollection resourcesImages = page.getResources().getImages();
            String imageId = resourcesImages.add(imageStream);
            XImage xImage = resourcesImages.get_Item(resourcesImages.size());

            Rectangle rectangle = new Rectangle(
                    0,
                    0,
                    page.getMediaBox().getWidth(),
                    (page.getMediaBox().getWidth() * xImage.getHeight()) / xImage.getWidth(),
                    true);

            page.getContents().add(new GSave());

            Matrix matrix = new Matrix(
                    rectangle.getURX() - rectangle.getLLX(),
                    0,
                    0,
                    rectangle.getURY() - rectangle.getLLY(),
                    rectangle.getLLX(),
                    rectangle.getLLX() + (page.getMediaBox().getHeight() - rectangle.getHeight()) / 2);
            page.getContents().add(new ConcatenateMatrix(matrix));
            page.getContents().add(new Do(imageId));
            page.getContents().add(new GRestore());

            document.save(outputFile.toString());
        }
    }

    public static void addImageSetAlternativeTextForImage(Path imageFile, Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();
            page.setPageSize(842, 595);

            page.addImage(imageFile.toString(), new Rectangle(0, 0, 842, 595, true));

            XImage xImage = page.getResources().getImages().get_Item(1);
            boolean result = xImage.trySetAlternativeText("Alternative text for image", page);
            if (result) {
                System.out.println("Text has been added successfuly");
            }
            document.save(outputFile.toString());
        }
    }

    public static void addImageToPdfWithFlateCompression(Path imageFile, Path outputFile) throws Exception {
        try (Document document = new Document();
             InputStream imageStream = Files.newInputStream(imageFile)) {
            Page page = document.getPages().add();
            XImageCollection resourcesImages = page.getResources().getImages();
            String imageId = resourcesImages.add(imageStream, ImageFilterType.Flate);

            page.getContents().add(new GSave());

            Rectangle rectangle = new Rectangle(0, 0, 600, 600, true);
            Matrix matrix = new Matrix(
                    rectangle.getURX() - rectangle.getLLX(),
                    0,
                    0,
                    rectangle.getURY() - rectangle.getLLY(),
                    rectangle.getLLX(),
                    rectangle.getLLY());

            page.getContents().add(new ConcatenateMatrix(matrix));
            page.getContents().add(new Do(imageId));
            page.getContents().add(new GRestore());

            document.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_images");
        Path inputFile = dirs.inputFile("sample.jpg");

        ExampleRunner.run("Add image", () -> addImage(inputFile, dirs.outputFile("Add image_out.pdf")));
        ExampleRunner.run("Add image using operators",
                () -> addImageUsingOperators(inputFile, dirs.outputFile("Add image using operators_out.pdf")));
        ExampleRunner.run("Add image with alt text",
                () -> addImageSetAlternativeTextForImage(inputFile, dirs.outputFile("Add image with alt text_out.pdf")));
        ExampleRunner.run("Add image to PDF with Flate Compression",
                () -> addImageToPdfWithFlateCompression(
                        inputFile,
                        dirs.outputFile("Add image to PDF with Flate Compression_out.pdf")));
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
