package com.aspose.pdf.examples.AsposePdfExamples.Text;

import com.aspose.pdf.Document;
import com.aspose.pdf.TextFragment;

public class DetermineLineBreak {

	public static void main(String[] args) {
		String myDir = "PathToDir";
		// Load source PDF file
		Document doc = new Document();
		com.aspose.pdf.Page page = doc.getPages().add();

		for (int i = 0; i < 4; i++)
		{
		    TextFragment text = new TextFragment("Lorem ipsum \r\ndolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
		    text.getTextState().setFontSize(20);
		    page.getParagraphs().add(text);
		}
		doc.save(myDir + "DetermineLineBreak_out.pdf");

		String notifications = doc.getPages().get_Item(1).getNotifications();
		System.out.println(notifications);
	}
}
