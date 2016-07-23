package com.aspose.pdf.examples.AsposePdfFacades.Forms;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.aspose.pdf.facades.Form;

public class ExportDataToXMLFromAPDFFile {

	public static void main(String[] args) throws IOException {
		// open document
		Form form = new Form();
		form.bindPdf("student.pdf");
		// create XML file.
		OutputStream xmlOutputStream = new FileOutputStream("student.xml");
		// export data
		form.exportXml(xmlOutputStream);
		// close file stream
		xmlOutputStream.close();
		// dispose the form object
		form.dispose();
	}
}
