package com.aspose.pdf.examples.AsposePdfExamples.Images;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.aspose.pdf.Document;
import com.aspose.pdf.Image;
import com.aspose.pdf.Page;
import com.aspose.pdf.XImageCollection;

public class SettingDPIOrPPIOfImagesInPDF {

	public static void main(String[] args) throws FileNotFoundException {
		String myDir = "pathTodir";
		File fileIn = new File(myDir + "image.jpg");
		FileInputStream in = new FileInputStream(fileIn);
		File fileOut = new File(myDir + "image.pdf");
		FileOutputStream out = new FileOutputStream(fileOut);
		// Test PDF creation
		Document doc = new Document();
		Page page = doc.getPages().add();
		Image image1 = new Image();
		image1.setImageStream(in);
		image1.setFixHeight(page.getMediaBox().getHeight() / 4);
		image1.setFixWidth(page.getMediaBox().getWidth() / 2);
		page.getParagraphs().add(image1);
		page.getPageInfo().getMargin().setLeft(5);
		page.getPageInfo().getMargin().setRight(0);
		page.getPageInfo().getMargin().setTop(0);
		page.getPageInfo().getMargin().setBottom(0);
		doc.save(out);
		// Internal image resolution change
		doc = new Document(myDir + "image.pdf");
		XImageCollection images = doc.getPages().get_Item(1).getResources().getImages();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		images.get_Item(1).save(baos, 10, 10);// define horizontal and vertical // resolutions
		images.get_Item(1).replace(new ByteArrayInputStream(baos.toByteArray()));
		doc.save(myDir + "imageWithNewResolution.pdf");
	}
}
