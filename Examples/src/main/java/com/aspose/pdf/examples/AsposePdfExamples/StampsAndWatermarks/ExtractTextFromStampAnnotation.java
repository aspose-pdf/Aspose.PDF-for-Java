package com.aspose.pdf.examples.AsposePdfExamples.StampsAndWatermarks;

import com.aspose.pdf.Annotation;
import com.aspose.pdf.Document;
import com.aspose.pdf.StampAnnotation;
import com.aspose.pdf.TextAbsorber;
import com.aspose.pdf.XForm;
import com.aspose.pdf.examples.Utils;

public class ExtractTextFromStampAnnotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//ExStart: ExtractTextFromStampAnnotation
		String dataDir = Utils.getSharedDataDir(ExtractTextFromStampAnnotation.class) + "Stamps-Watermarks/";		
		
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
