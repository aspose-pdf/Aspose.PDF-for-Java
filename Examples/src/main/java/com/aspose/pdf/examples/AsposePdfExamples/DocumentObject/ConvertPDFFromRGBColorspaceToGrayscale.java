package com.aspose.pdf.examples.AsposePdfExamples.DocumentObject;

import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.RgbToDeviceGrayConversionStrategy;

public class ConvertPDFFromRGBColorspaceToGrayscale {

    public static void main(String[] args) {
        Document document = new Document("input.pdf");
        RgbToDeviceGrayConversionStrategy strategy = new RgbToDeviceGrayConversionStrategy();
        for (int idxPage = 1; idxPage <= document.getPages().size(); idxPage++) {
            Page page = document.getPages().get_Item(idxPage);
            strategy.convert(page);
        }
        document.save("output.pdf");
    }

}
