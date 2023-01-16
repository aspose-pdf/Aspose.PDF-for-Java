package com.aspose.pdf.examples.AsposePdfExamples.StampsAndWatermarks;

import com.aspose.pdf.Annotation;
import com.aspose.pdf.Document;
import com.aspose.pdf.StampAnnotation;
import com.aspose.pdf.TextAbsorber;
import com.aspose.pdf.XForm;
import com.aspose.pdf.examples.Utils;

public class ExtractTextFromStampAnnotation {

	public static void main(String[] args) {
		runExamples();
	}
	public static void runExamples() {
		// The paths to resources and output directories.
		String testID = "com/aspose/pdf/examples/AsposePdf/Stamps-Watermarks/";
		String dataDir = Utils.getDataDir(testID);
//		String outputDir = Utils.getOutDir(testID);

		System.out.println("============================1");
		System.out.println("Example extractTextFromStampAnnotation start");
		extractTextFromStampAnnotation(dataDir);
		System.out.println("Example extractTextFromStampAnnotation end");
	}

	public static void extractTextFromStampAnnotation(String dataDir) {

		//ExStart: ExtractTextFromStampAnnotation

		Document doc = new Document(dataDir+"test.pdf");
	        Annotation item = doc.getPages().get_Item(1).getAnnotations().get_Item(3);
	        if (item instanceof StampAnnotation ) {
	            StampAnnotation annot = (StampAnnotation) item;
	            TextAbsorber ta = new TextAbsorber();
	            XForm ap = annot.getNormalAppearance();
	            ta.visit(ap);
	            System.out.println(ta.getText());
	        }
		//ExEnd: ExtractTextFromStampAnnotation
	}

}
