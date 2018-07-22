package com.aspose.pdf.examples.AsposePdfExamples.Miscellaneous;

import com.aspose.pdf.Document;
import com.aspose.pdf.Operator;
import com.aspose.pdf.OperatorCollection;

public class ChangingColorSpaceOfPDFDocument {

	public static void main(String[] args) {
		Document doc = new Document("input_color.pdf");
		OperatorCollection contents = doc.getPages().get_Item(1).getContents();
		System.out.println("Values of RGB color operators in the pdf document");
		for (int j = 1; j <= contents.size(); j++) {
			Operator oper = contents.get_Item(j);
			if (oper instanceof com.aspose.pdf.operators.SetRGBColor || oper instanceof com.aspose.pdf.operators.SetRGBColorStroke)
				try {
					// Converting RGB to CMYK color
					System.out.println(oper.toString());
					double[] rgbFloatArray = new double[] { Double.valueOf(oper.getParameters().get(0).toString()), Double.valueOf(oper.getParameters().get(1).toString()), Double.valueOf(oper.getParameters().get(2).toString()), };
					double[] cmyk = new double[4];
					if (oper instanceof com.aspose.pdf.operators.SetRGBColor) {
						((com.aspose.pdf.operators.SetRGBColor) oper).getCMYKColor(rgbFloatArray, cmyk);
						contents.set_Item(j, new com.aspose.pdf.operators.SetCMYKColor(cmyk[0], cmyk[1], cmyk[2], cmyk[3]));
					} else if (oper instanceof com.aspose.pdf.operators.SetRGBColorStroke) {
						((com.aspose.pdf.operators.SetRGBColorStroke) oper).getCMYKColor(rgbFloatArray, cmyk);
						contents.set_Item(j, new com.aspose.pdf.operators.SetCMYKColorStroke(cmyk[0], cmyk[1], cmyk[2], cmyk[3]));
					} else
						throw new java.lang.Throwable("Unsupported command");
				} catch (Throwable e) {
					e.printStackTrace();
				}
		}
		doc.save("input_colorout.pdf");
		// Testing the result
		System.out.println("Values of converted CMYK color operators in the result pdf document");
		doc = new Document("input_colorout.pdf");
		contents = doc.getPages().get_Item(1).getContents();
		for (int j = 1; j <= contents.size(); j++) {
			Operator oper = contents.get_Item(j);
			if (oper instanceof com.aspose.pdf.operators.SetCMYKColor || oper instanceof com.aspose.pdf.operators.SetCMYKColorStroke) {
				System.out.println(oper.toString());
			}
		}
	}
}
