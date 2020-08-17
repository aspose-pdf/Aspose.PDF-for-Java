---
title: Aspose.PDF for Java 20.5 Release Notes
type: docs
weight: 80
url: /java/aspose-pdf-for-java-20-5-release-notes/
---

{{% alert color="primary" %}}

This page contains release notes information for Aspose.PDF for Java 20.5.

{{% /alert %}}
## **Improvements and Changes**

|**Key**|**Summary**|**Category**|
| :- | :- | :- |
|PDFJAVA-38236|Takes very long time to convert pdf to image|	Enhancement|
|PDFJAVA-38173|	StackOverflowError while converting PDF to DOC|	Bug|
|PDFJAVA-35806|	Exception when trying to extract text from PDF on Unix system|	Bug|
|PDFJAVA-38180|	PDF to DOC - StackOverFlowException occurred|	Bug|
|PDFJAVA-39333|	Missing package com.aspose.pdf.groupprocessor|	Bug|
|PDFJAVA-39316|	PDF to TIFF OOM|	Bug|
|PDFJAVA-39020|	Formating issue after import from XFDF|	Bug|
|PDFJAVA-39215|	Setting Table in PDF on a specific position|	Bug|
|PDFJAVA-39302|	Generate output on XLSX template base from input PDF|	Bug|

## **Public API and Backwards Incompatible Changes**

### Removed internal Field
 * com.aspose.pdf.DocSaveOptions.RecognitionMode.EnhancedFlow

### Added New Classes
 * com.aspose.pdf.groupprocessor.interfaces.IPdfTypeExtractor
 * com.aspose.pdf.groupprocessor.TextExtractor
 * com.aspose.pdf.groupprocessor.ExtractorFactory
