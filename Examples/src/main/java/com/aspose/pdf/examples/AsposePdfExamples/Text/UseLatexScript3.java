package com.aspose.pdf.examples.AsposePdfExamples.Text;

import com.aspose.pdf.Document;
import com.aspose.pdf.LatexFragment;
import com.aspose.pdf.Page;
import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.examples.AsposePdfExamples.StampsAndWatermarks.AddImageStampAsBackgroundInFloatingBox;

public class UseLatexScript3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//ExStart: UseLatexScript3
		String dataDir = Utils.getSharedDataDir(UseLatexScript3.class) + "Text/";		
		
		String s =
                "\\usepackage{amsmath,amsthm}" +
                "\\begin{document}" +
                "\\begin{proof} The proof is a follows: " +
                "\\begin{align}" +
                "(x+y)^3&=(x+y)(x+y)^2" +
                "(x+y)(x^2+2xy+y^2)\\\\" +
                "&=x^3+3x^2y+3xy^3+x^3.\\qedhere" +
                "\\end{align}" +
                "\\end{proof}" +
                "\\end{document}";

        Document doc = new Document();
        Page page = doc.getPages().add();

        LatexFragment latex = new LatexFragment(s);

        page.getParagraphs().add(latex);
        
        doc.save(dataDir + "Script_out.pdf");
		//ExEnd: UseLatexScript3
	}

}
