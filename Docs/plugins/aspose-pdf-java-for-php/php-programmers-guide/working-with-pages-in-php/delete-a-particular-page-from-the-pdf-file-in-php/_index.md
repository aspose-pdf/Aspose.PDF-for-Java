---
title: Delete a Particular Page from the PDF File In PHP
type: docs
weight: 20
url: /java/delete-a-particular-page-from-the-pdf-file-in-php/
---

## <ins>**Aspose.PDF - Delete Page**
<ins>To delete a Particular Page from the PDF document using **Aspose.PDF Java for PHP**, simply invoke **DeletePage** class.

**PHP Code**
```

# Open the target document
$pdf = new Document($dataDir . 'input1.pdf');

# delete a particular page
$pdf->getPages()->delete(2);

# save the newly generated PDF file
$pdf->save($dataDir . "output.pdf");

print "Page deleted successfully!";

```

## <ins>**Download Running Code**
Download **Delete Page (Aspose.PDF)** from any of the below mentioned social coding sites:

- [GitHub](https://github.com/aspose-pdf/Aspose.PDF-for-Java/blob/master/Plugins/Aspose_Pdf_Java_for_PHP/src/Aspose/Pdf/WorkingWithPages/DeletePage.php)
