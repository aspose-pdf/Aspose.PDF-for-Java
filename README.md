![GitHub all releases](https://img.shields.io/github/downloads/aspose-pdf/Aspose.pdf-for-Java/total) ![GitHub](https://img.shields.io/github/license/aspose-pdf/Aspose.pdf-for-java)
# Java API to Process & Manipulate PDF Files

[Aspose.PDF for Java](https://products.aspose.com/pdf/java) is a PDF document creation component that enables your Java applications to read, write and manipulate PDF documents without using Adobe Acrobat.

Directory | Description
--------- | -----------
[Examples](Examples) | A collection of Java examples that help you learn the product features.

<p align="center">
  <a title="Download Examples ZIP" href="https://github.com/aspose-pdf/Aspose.pdf-for-Java/archive/master.zip">
	<img src="https://raw.github.com/AsposeExamples/java-examples-dashboard/master/images/downloadZip-Button-Large.png" />
  </a>
</p>

## `aspose.pdf` Package Features

### PDF Document Featres

- Set basic information (e.g. author, creator) of the PDF document.
- Configure PDF Page properties (e.g. width, height, cropbox, bleedbox etc.).
- Set page numbering, bookmark level, page sizes etc.
- Apply document open action, open mode as well as appearance.
- Document can have different page transition effects such as dissolve or box.
- Create PDF documents via `XML`, `API` or `XML` and `API` combined.
- Ability to work with text, paragraphs, headings, hyperlinks, graphs, attachments etc.

### Security Features

- PDF documents can be encrypted up to 128 bits.
- Master and user passwords can be set for PDF encryption.
- Apply rescriptions on content modification, copying, printing and other operations.

### Conversion Features

- Convert an existing XML file (`.XML`) or `XmlDocument` to a new PDF document or a PDF file stream.
- Convert conventional Image formats into PDF file.
- Convert `PCL` files into PDF file.

For a more comprehensive list of features, please visit [Features of `aspose.pdf` Package](https://docs.aspose.com/pdf/java/features-of-aspose-pdf-package/).

## `com.aspose.pdf` Package Features

- Supports 14 core fonts.
- Support for `Type 1`, `TrueType`, `Type 3`, `CJK` fonts.
- `Unicode` support is available.
- Add, search, extract and replace text in PDF files.
- Add/delete, extract and replace images.
- Insert, delete, split PDF pages.
- Support for Linearization (optimization for the web).
- Set and get XMP metadata.
- Validate (`PDF/A-1a`, `PDF/A-1b`).
- Work with bookmarks, annotations, PDF forms, stamps, watermarks and more.

For a more comprehensive list of features, please visit [Features of `com.aspose.pdf` Package](https://docs.aspose.com/pdf/java/features-of-com-aspose-pdf-package/).

## `com.aspose.pdf.facades` Package Features

- Supports 14 core fonts.
- Support for `Type 1`, `TrueType`, `Type 3`, `CJK` fonts.
- `Unicode` support is available.
- Add, replace and extract text & images (from the entire PDF, a particular page, or a range of pages).
- Work with bookmarks, annotations, PDF forms, links, actions, signature and more.
- Print PDF to default, specified, physical, or virtual printer.
- Print PDF to `XPS` file or XPS printer.

For a more comprehensive list of features, please visit [Features of `com.aspose.pdf.facades` Package](https://docs.aspose.com/pdf/java/features-of-com-aspose-pdf-facades-package/).

## Read & Write PDF & Other Formats

**Fixed Layout:** PDF, XPS\
**Books:** EPUB\
**Web:** HTML
**Other:** TEX, XML, SVG

## Save PDF Documents As

**Microsoft Office:** DOC, DOCX, XLS, XLSX, PPTX\
**Images:** JPEG, PNG, BMP, TIFF, EMF\
**Other:** MobiXML, XML, TEXT

## Read Formats

CGM, MHT, PCL, PS, XSLFO, MD

## Supported Environments

- **Microsoft Windows:** Windows Desktop & Server (x86, x64)
- **macOS:** Mac OS X
- **Linux:** Ubuntu, OpenSUSE, CentOS, and others
- **Java Versions:** `J2SE 8.0 (1.8)` or above

## Get Started with Aspose.PDF for Java

Aspose hosts all Java APIs at the [Aspose Repository](https://repository.aspose.com/webapp/#/artifacts/browse/tree/General/repo/com/aspose/aspose-pdf). You can easily use Aspose.PDF for Java API directly in your Maven projects with simple configurations. For the detailed instructions please visit [Installing Aspose.PDF for Java from Aspose Repository](https://docs.aspose.com/pdf/java/installation/) documentation page.

## Extract text from a PDF file using Java

```java
// For complete examples and data files, please go to https://github.com/aspose-pdf/Aspose.Pdf-for-Java
// Open document
Document pdfDocument = new Document("input.pdf");

// Create TextAbsorber object to extract text
TextAbsorber textAbsorber = new TextAbsorber();

// Accept the absorber for all the pages
pdfDocument.getPages().accept(textAbsorber);

// Get the extracted text
String extractedText = textAbsorber.getText();

// Create a writer and open the file
java.io.FileWriter writer = new java.io.FileWriter(new java.io.File("Extracted_text.txt"));
writer.write(extractedText);

// Write a line of text to the file tw.WriteLine(extractedText);
// Close the stream
writer.close();
```

[Product Page](https://products.aspose.com/pdf/java) | [Docs](https://docs.aspose.com/pdf/java/) | [Demos](https://products.aspose.app/pdf/family) | [API Reference](https://apireference.aspose.com/pdf/java) | [Examples](https://github.com/aspose-pdf/Aspose.PDF-for-Java/tree/master/Examples) | [Blog](https://blog.aspose.com/category/pdf/) | [Search](https://search.aspose.com/) | [Free Support](https://forum.aspose.com/c/pdf) | [Temporary License](https://purchase.aspose.com/temporary-license)
