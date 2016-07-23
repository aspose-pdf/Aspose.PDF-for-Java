package com.aspose.pdf.examples.AsposePdfLegacy.Sections;

import aspose.pdf.MarginInfo;
import aspose.pdf.PageSize;
import aspose.pdf.Pdf;
import aspose.pdf.Section;

public class SetPageSizeAndMargins {

	public static void main(String[] args) {
		PageSizeUsingStaticReadOnlyFields();
		PageSizeInUnits();
		PageMargins();
	}

	public static void PageSizeUsingStaticReadOnlyFields() {
		// Instantiate Pdf object by calling its empty constructor
		Pdf pdf1 = new Pdf();
		// Get section of the Pdf object
		Section sec1 = pdf1.getSections().get_Item(0);
		sec1.getPageInfo().setPageWidth(PageSize.A3_WIDTH);
		sec1.getPageInfo().setPageHeight(PageSize.A3_HEIGHT);
	}

	public static void PageSizeInUnits() {
		// Instantiate Pdf object by calling its empty constructor
		Pdf pdf1 = new Pdf();
		// Get section of the Pdf object
		Section sec1 = pdf1.getSections().get_Item(0);
		sec1.getPageInfo().setPageWidth(576);
		sec1.getPageInfo().setPageWidth((float) 707.5);
	}

	public static void PageMargins() {
		// Instantiate Pdf object by calling its empty constructor
		Pdf pdf1 = new Pdf();
		// Get section of the Pdf object
		Section sec1 = pdf1.getSections().get_Item(0);
		// Instantiate the MarginInfo instance
		MarginInfo marginInfo = new MarginInfo();
		// Set the margin Top.
		marginInfo.setTop(72);
		// Set the margin Bottom. This value is in points, but if using XML to PDF conversion,
		// other units like inches and centimeters can also be used i.e. 12inch or 12cm
		marginInfo.setBottom(72);
		// Set the margin Left.
		marginInfo.setLeft(90);
		// Set the margin Right.
		marginInfo.setRight(90);
		// Assign the marginInfo instance to Margin property of sec1.PageInfo
		sec1.getPageInfo().setMargin(marginInfo);
	}

}
