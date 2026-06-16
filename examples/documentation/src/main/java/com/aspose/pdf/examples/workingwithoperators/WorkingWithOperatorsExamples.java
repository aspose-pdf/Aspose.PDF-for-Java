package com.aspose.pdf.examples.workingwithoperators;

import com.aspose.pdf.Document;
import com.aspose.pdf.Matrix;
import com.aspose.pdf.Operator;
import com.aspose.pdf.OperatorCollection;
import com.aspose.pdf.Page;
import com.aspose.pdf.Rectangle;
import com.aspose.pdf.XForm;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;
import com.aspose.pdf.operators.ClosePathStroke;
import com.aspose.pdf.operators.ConcatenateMatrix;
import com.aspose.pdf.operators.Do;
import com.aspose.pdf.operators.Fill;
import com.aspose.pdf.operators.GRestore;
import com.aspose.pdf.operators.GSave;
import com.aspose.pdf.operators.Stroke;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public final class WorkingWithOperatorsExamples {
    private WorkingWithOperatorsExamples() {
    }

    public static void addImageUsingPdfOperators(Path inputFile, Path imageFile, Path outputFile) throws Exception {
        try (Document document = new Document(inputFile.toString());
             InputStream imageStream = Files.newInputStream(imageFile)) {
            Page page = document.getPages().get_Item(1);
            String imageName = page.getResources().getImages().add(imageStream);

            Rectangle rectangle = new Rectangle(100, 100, 200, 200, true);
            Matrix matrix = new Matrix(new double[]{
                    rectangle.getURX() - rectangle.getLLX(),
                    0,
                    0,
                    rectangle.getURY() - rectangle.getLLY(),
                    rectangle.getLLX(),
                    rectangle.getLLY()
            });

            page.getContents().add(new GSave());
            page.getContents().add(new ConcatenateMatrix(matrix));
            page.getContents().add(new Do(imageName));
            page.getContents().add(new GRestore());
            document.save(outputFile.toString());
        }
        System.out.println("Image added with PDF operators to " + outputFile);
    }

    public static void drawXFormOnPage(Path inputFile, Path imageFile, Path outputFile) throws Exception {
        try (Document document = new Document(inputFile.toString());
             InputStream imageStream = Files.newInputStream(imageFile)) {
            Page page = document.getPages().get_Item(1);
            OperatorCollection pageContents = page.getContents();

            pageContents.insert(1, new GSave());
            pageContents.add(new GRestore());
            pageContents.add(new GSave());

            XForm form = XForm.createNewForm(page, document);
            page.getResources().getForms().add(form);

            form.getContents().add(new GSave());
            form.getContents().add(new ConcatenateMatrix(200, 0, 0, 200, 0, 0));
            String imageName = form.getResources().getImages().add(imageStream);
            form.getContents().add(new Do(imageName));
            form.getContents().add(new GRestore());

            addFormAt(pageContents, form.getName(), 100, 500);
            addFormAt(pageContents, form.getName(), 100, 300);

            pageContents.add(new GRestore());
            document.save(outputFile.toString());
        }
        System.out.println("XForm drawn on page in " + outputFile);
    }

    public static void removeGraphicsObjects(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            Page page = document.getPages().get_Item(1);
            List<Operator> operatorsToRemove = new ArrayList<>();
            for (Object item : page.getContents()) {
                Operator operator = (Operator) item;
                if (operator instanceof Stroke || operator instanceof ClosePathStroke || operator instanceof Fill) {
                    operatorsToRemove.add(operator);
                }
            }
            page.getContents().delete(operatorsToRemove);
            document.save(outputFile.toString());
        }
        System.out.println("Graphics operators removed in " + outputFile);
    }

    private static void addFormAt(OperatorCollection pageContents, String formName, double x, double y) {
        pageContents.add(new GSave());
        pageContents.add(new ConcatenateMatrix(1, 0, 0, 1, x, y));
        pageContents.add(new Do(formName));
        pageContents.add(new GRestore());
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_operators");

        ExampleRunner.run("Add image using operators",
                () -> addImageUsingPdfOperators(dirs.inputFile("sample.pdf"), dirs.inputFile("PDFOperators.jpg"),
                        dirs.outputFile("add_image_using_pdf_operators.pdf")));
        ExampleRunner.run("Draw XForm on page",
                () -> drawXFormOnPage(dirs.inputFile("sample.pdf"), dirs.inputFile("sample-cover.jpg"),
                        dirs.outputFile("draw_xform_on_page.pdf")));
        ExampleRunner.run("Remove graphics objects",
                () -> removeGraphicsObjects(dirs.inputFile("RemoveGraphicsObjects.pdf"),
                        dirs.outputFile("remove_graphics_objects.pdf")));

        System.out.println();
        System.out.println("All Working With Operators examples finished.");
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
