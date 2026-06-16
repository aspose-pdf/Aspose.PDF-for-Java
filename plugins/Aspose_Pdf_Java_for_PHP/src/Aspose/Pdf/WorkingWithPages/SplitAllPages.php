<?php

namespace Aspose\Pdf\WorkingWithPages;

use com\aspose\pdf\Document as Document;

class SplitAllPages {

    public static function run($dataDir=null)
    {
        # Open the target document
        $pdf = new Document($dataDir . 'input1.pdf');

        # loop through all the pages
        $pdf_page = 1;
        $total_size = $pdf->getPages()->size();
        #for (int pdfPage = 1; pdfPage<= pdfDocument1.getPages().size(); pdfPage++)
        while ($pdf_page <= $total_size)
        {
            # create a new Document object
            $new_document = new Document();

            # get the page at particular index of Page Collection
            $new_document->getPages()->add($pdf->getPages()->get_Item($pdf_page));

            # save the newly generated PDF file
            $new_document->save($dataDir . "page_#{$pdf_page}.pdf");

            $pdf_page++;
        }

        print "Split process completed successfully!";
    }
}