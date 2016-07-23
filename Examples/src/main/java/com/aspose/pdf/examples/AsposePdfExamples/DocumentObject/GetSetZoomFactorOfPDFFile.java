package com.aspose.pdf.examples.AsposePdfExamples.DocumentObject;

import com.aspose.pdf.Document;
import com.aspose.pdf.FitHExplicitDestination;
import com.aspose.pdf.FitVExplicitDestination;
import com.aspose.pdf.GoToAction;
import com.aspose.pdf.XYZExplicitDestination;

public class GetSetZoomFactorOfPDFFile {

	public static void main(String[] args) {
		getSetZoomFactorOfPDFFile();
		getZoomFactor();
	}

	public static void getSetZoomFactorOfPDFFile() {
		String myDir = "pathTodir";
		double zoom = .5;
		// instantiate new Document object
		Document doc = new Document(myDir + "HelloWorld.pdf");
		// setting zoom factor of document
		GoToAction actionzoom = new GoToAction(new XYZExplicitDestination(doc.getPages().get_Item(1), doc.getPages().get_Item(1).getMediaBox().getWidth(), doc.getPages().get_Item(1).getMediaBox().getHeight(), zoom));
		// setting action to fit to page width zoom
		GoToAction actionFittoWidth = new GoToAction(new FitHExplicitDestination(doc.getPages().get_Item(1), doc.getPages().get_Item(1).getMediaBox().getWidth()));
		// setting action to fit to page height zoom
		GoToAction actionFittoHeight = new GoToAction(new FitVExplicitDestination(doc.getPages().get_Item(1), doc.getPages().get_Item(1).getMediaBox().getHeight()));
		doc.setOpenAction(actionzoom);
		doc.save(myDir + "Zoomed_actionzoom.pdf");
	}

	public static void getZoomFactor() {
		String myDir = "pathTodir";
		// Instantiate new Document object
		Document doc1 = new Document(myDir + "Zoomed_actionzoom.pdf");
		// Create GoToAction object
		GoToAction action = (GoToAction) doc1.getOpenAction();
		// Get the Zoom factor of PDF file
		System.out.println(((XYZExplicitDestination) action.getDestination()).getZoom());
	}
}
