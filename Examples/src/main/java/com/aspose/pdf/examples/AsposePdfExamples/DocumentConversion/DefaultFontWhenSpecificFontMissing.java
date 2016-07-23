package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.Font;
import com.aspose.pdf.FontRepository;
import com.aspose.pdf.HtmlSaveOptions;
import com.aspose.pdf.text.CustomFontSubstitutionBase;

public class DefaultFontWhenSpecificFontMissing {

	public static void main(String[] args) {
		String myDir = "PathToDir";
		Document pdf = new Document(myDir + "Redis.pdf");
		// configure font substitution
		CustomSubst1 subst1 = new CustomSubst1();
		FontRepository.getSubstitutions().add(subst1);
		// Configure notifier to console
		pdf.FontSubstitution.add(new Document.FontSubstitutionHandler() {
			public void invoke(Font font, Font newFont) {
				// print substituted FontNames into console
				System.out.println("Warning: Font " + font.getFontName() + " was substituted with another font -> " + newFont.getFontName());
			}
		});
		HtmlSaveOptions htmlSaveOps = new HtmlSaveOptions();
		pdf.save(myDir + "Redis_1150_substitutedWithMSGothic_release.html", htmlSaveOps);
	}
	/**
	 * The class to implement font substitution
	 */
	private static class CustomSubst1 extends CustomFontSubstitutionBase {
		public boolean trySubstitute(OriginalFontSpecification originalFontSpecification, /* out */com.aspose.pdf.Font[] substitutionFont) {
			// 1. substitute Arial font with TimesNewRoman font
			// if
			// ("Arial".equals(originalFontSpecification.getOriginalFontName()))
			// {
			// substitutionFont[0] =
			// FontRepository.findFont("TimesNewRoman");
			// return true;
			// }
			// else
			// return super.trySubstitute(originalFontSpecification, /*out*/
			// substitutionFont);
			// 2. or substitute all the fonts with the MSGothic font
			substitutionFont[0] = FontRepository.findFont("MSGothic");
			return true;
		}
	}
}
