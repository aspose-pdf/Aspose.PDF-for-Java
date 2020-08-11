---
title: Convert PDF to Excel Workbook in PHP
type: docs
weight: 20
url: /java/convert-pdf-to-excel-workbook-in-php/
---

## <ins>**Aspose.PDF - Convert PDF to Excel Workbook**
<ins>To convert PDF document to Excel Workbook using **Aspose.PDF Java for PHP**, simply invoke **PdfToExcel** module.

**PHP Code**
```
# Open the target document
$pdf = new Document($dataDir . 'input1.pdf');

# Instantiate ExcelSave Option object
$excelsave = new ExcelSaveOptions();

# Save the output to XLS format
$pdf->save($dataDir . "Converted_Excel.xls", $excelsave);

print "Document has been converted successfully" . PHP_EOL;

```

## <ins>**Download Running Code**
Download **Convert PDF to Excel Workbook (Aspose.PDF)** from any of the below mentioned social coding sites:

- [GitHub](https://github.com/aspose-pdf/Aspose.PDF-for-Java/blob/master/Plugins/Aspose_Pdf_Java_for_PHP/src/Aspose/Pdf/WorkingWithDocumentConversion/PdfToExcel.php)
