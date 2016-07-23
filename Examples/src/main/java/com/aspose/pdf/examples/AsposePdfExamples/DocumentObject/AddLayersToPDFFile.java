package com.aspose.pdf.examples.AsposePdfExamples.DocumentObject;

import java.util.ArrayList;

import com.aspose.pdf.Document;
import com.aspose.pdf.Layer;
import com.aspose.pdf.Operator;
import com.aspose.pdf.Page;

public class AddLayersToPDFFile {

	public static void main(String[] args) {

		Document doc = new Document();
		Page page = doc.getPages().add();
		Layer layer = new Layer("oc1", "Red Line");
		layer.getContents().add(new Operator.SetRGBColorStroke(1, 0, 0));
		layer.getContents().add(new Operator.MoveTo(500, 700));
		layer.getContents().add(new Operator.LineTo(400, 700));
		layer.getContents().add(new Operator.Stroke());
		page.setLayers(new ArrayList());
		page.getLayers().add(layer);
		layer = new Layer("oc2", "Green Line");
		layer.getContents().add(new Operator.SetRGBColorStroke(0, 1, 0));
		layer.getContents().add(new Operator.MoveTo(500, 750));
		layer.getContents().add(new Operator.LineTo(400, 750));
		layer.getContents().add(new Operator.Stroke());
		page.getLayers().add(layer);
		layer = new Layer("oc3", "Blue Line");
		layer.getContents().add(new Operator.SetRGBColorStroke(0, 0, 1));
		layer.getContents().add(new Operator.MoveTo(500, 800));
		layer.getContents().add(new Operator.LineTo(400, 800));
		layer.getContents().add(new Operator.Stroke());
		page.getLayers().add(layer);
		doc.save("output.pdf");
	}

}
