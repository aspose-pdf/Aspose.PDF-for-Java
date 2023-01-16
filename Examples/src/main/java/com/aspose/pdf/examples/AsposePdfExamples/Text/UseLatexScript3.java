package com.aspose.pdf.examples.AsposePdfExamples.Text;

import com.aspose.pdf.Document;
import com.aspose.pdf.LatexFragment;
import com.aspose.pdf.Page;
import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.examples.AsposePdfExamples.StampsAndWatermarks.AddImageStampAsBackgroundInFloatingBox;

public class UseLatexScript3 {


    public static void main(String[] args) {
        runExamples();
    }
    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Text/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================1");
        System.out.println("Example useLatexScript3 start");
        useLatexScript3(dataDir, outputDir);
        System.out.println("Example useLatexScript3 end");
    }

    public static void useLatexScript3(String dataDir, String outputDir) {

		//ExStart: UseLatexScript3

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
        
        doc.save(outputDir + "Script_out.pdf");
		//ExEnd: UseLatexScript3
	}

}
