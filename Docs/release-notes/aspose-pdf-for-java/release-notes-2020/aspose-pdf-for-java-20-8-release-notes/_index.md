---
title: Aspose.PDF for Java 20.8 Release Notes
type: docs
weight: 55
url: /java/aspose-pdf-for-java-20-8-release-notes/
---

{{% alert color="primary" %}}

This page contains release notes information for Aspose.PDF for Java 20.8.

{{% /alert %}}
## **Improvements and Changes**

|**Key**|**Summary**|**Category**|
| :- | :- | :- |
|PDFJAVA-39694| PDF/X-1A standard inquiry|	Enhancement|
|PDFJAVA-39558| PDF to PDF/A - Output document is not valid|Bug|
|PDFJAVA-39468| PDF file not properly converted to XLSX|	Bug
|PDFJAVA-39407| JpegDevice.process throws exception|	Bug|
|PDFJAVA-36404| Bad results while converting html and embedded css file|Bug|
|PDFJAVA-35445| PDF to PDF/A - Exception during conversion|	Bug|
|PDFJAVA-39593| PDF to XLSX, cell shifted to the left|	Bug|
|PDFJAVA-39574| too many open files because of log handler|	Bug|
|PDFJAVA-39521| Abnormalities while generating PDF/X-1a documents|Bug|
|PDFJAVA-39409| PDF file not properly converted to HTML|Bug|

## **Public API and Backwards Incompatible Changes**

### Added New Methods
 * com.aspose.pdf.XForm.getResources(boolean)

### Removed Deprecated Methods
 * com.aspose.pdf.AppearanceDictionary.contains(Object)
 * com.aspose.pdf.AppearanceDictionary.get(Object)
 * com.aspose.pdf.AppearanceDictionary.removeItemInternal(Object)
 * com.aspose.pdf.AppearanceDictionary.set(Object,XForm)
 * com.aspose.pdf.AppearanceDictionary.iterator_Rename_Namesake

### Added New Class
 * com.aspose.pdf.ConvertSoftMaskAction

### Added New Constants
 * com.aspose.pdf.PdfFormat.PDF_X_1A_2001 = 14;

### Renamed Methods
 * com.aspose.pdf.PdfASymbolicFontEncodingStrategy.QueueItem.getPlatformID() ->
 * com.aspose.pdf.PdfASymbolicFontEncodingStrategy.QueueItem.getPlatformId
 * com.aspose.pdf.PdfASymbolicFontEncodingStrategy.QueueItem.setPlatformID(int) ->  
 * com.aspose.pdf.PdfASymbolicFontEncodingStrategy.QueueItem.setPlatformId(int)
 * com.aspose.pdf.PdfASymbolicFontEncodingStrategy.QueueItem.getPlatformSpecificID() ->
 * com.aspose.pdf.PdfASymbolicFontEncodingStrategy.QueueItem.getPlatformSpecificId
 * com.aspose.pdf.PdfASymbolicFontEncodingStrategy.QueueItem.setPlatformSpecificID(int) ->
 * com.aspose.pdf.PdfASymbolicFontEncodingStrategy.QueueItem.setPlatformSpecificId(int)
