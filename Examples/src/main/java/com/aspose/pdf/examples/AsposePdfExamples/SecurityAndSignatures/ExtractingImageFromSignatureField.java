package com.aspose.pdf.examples.AsposePdfExamples.SecurityAndSignatures;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.aspose.pdf.Document;
import com.aspose.pdf.Field;
import com.aspose.pdf.SignatureField;

public class ExtractingImageFromSignatureField {

	public static void main(String[] args) {
		String myDir = "PathToString";
		// Load source PDF file
		Document pdfDocument = new Document(myDir + "test.pdf");
		int i = 0;
		try {
			for (Field field : pdfDocument.getForm().getFields()) {
				SignatureField sf = (SignatureField)field;
				if (sf != null) {
					FileOutputStream output = new FileOutputStream(myDir + "im" + i + ".jpeg");
					InputStream tempStream = sf.extractImage();
					byte[] b = new byte[tempStream.available()];
					tempStream.read(b);
					output.write(b);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (pdfDocument != null)
				pdfDocument.dispose();
		}
	}
}
