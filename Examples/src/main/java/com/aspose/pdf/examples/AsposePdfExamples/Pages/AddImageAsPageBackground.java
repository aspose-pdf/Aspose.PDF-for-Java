package com.aspose.pdf.examples.AsposePdfExamples.Pages;

import java.io.FileInputStream;

import com.aspose.pdf.BackgroundArtifact;
import com.aspose.pdf.Document;
import com.aspose.pdf.Page;

public class AddImageAsPageBackground {

	public static void main(String[] args) throws Exception {
		String myDir = "PathToDir";
		// Create a new Document object
		Document doc = new Document();
		// Add a new page to document object
		Page page = doc.getPages().add();
		// Create BackgroundArtifact object
		BackgroundArtifact background = new BackgroundArtifact();
		// Specify the image for backgroundartifact object
		background.setBackgroundImage(new FileInputStream(myDir + "logo.png"));
		// Add backgroundartifact to artifacts collection of page
		page.getArtifacts().add(background);
		// Save the document
		doc.save(myDir + "BackGround.pdf");
	}
}
