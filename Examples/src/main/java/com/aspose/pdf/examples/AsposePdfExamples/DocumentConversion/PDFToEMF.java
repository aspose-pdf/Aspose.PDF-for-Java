package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.devices.EmfDevice;
import com.aspose.pdf.devices.Resolution;

public class PDFToEMF {

	public static void main(String[] args) {
		// instantiate EmfDevice object
		EmfDevice device = new EmfDevice(new Resolution(96));
		// load existing PDF file
		Document doc = new Document("Input.pdf");
		// save first page of PDF file as Emf image
		device.process(doc.getPages().get_Item(1), "output.emf");
	}

}
