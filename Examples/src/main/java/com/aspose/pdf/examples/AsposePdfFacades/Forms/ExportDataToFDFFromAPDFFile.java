package com.aspose.pdf.examples.AsposePdfFacades.Forms;

import java.io.FileOutputStream;
import java.io.IOException;

import com.aspose.pdf.facades.Form;

public class ExportDataToFDFFromAPDFFile {

	public static void main(String[] args) throws IOException {
		// open document
		Form form = new Form();
		form.bindPdf("student.pdf");
		// create fdf file.
		FileOutputStream fdfOutputStream = new FileOutputStream("student.fdf");
		// export data
		form.exportFdf(fdfOutputStream);
		// close file stream
		fdfOutputStream.close();
		// save updated document
		form.dispose();
	}
}
