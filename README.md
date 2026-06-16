![GitHub all releases](https://img.shields.io/github/downloads/aspose-pdf/Aspose.pdf-for-Java/total) ![GitHub](https://img.shields.io/github/license/aspose-pdf/Aspose.pdf-for-java)
# Java API to Process & Manipulate PDF Files

[Aspose.PDF for Java](https://products.aspose.com/pdf/java) is a PDF document creation component that enables your Java applications to read, write and manipulate PDF documents without using Adobe Acrobat.

Directory | Description
--------- | -----------
[examples/documentation](examples/documentation/) | Runnable Java examples used by Aspose.PDF documentation.
[plugins/jython](plugins/jython/) | Jython integration examples and plugin-specific assets.
[plugins/php](plugins/php/) | PHP integration examples and plugin-specific assets.
[docs](docs/) | Repository structure and contribution guidance.

<p align="center">
  <a title="Download Examples ZIP" href="https://github.com/aspose-pdf/Aspose.pdf-for-Java/archive/master.zip">
	<img src="https://raw.github.com/AsposeExamples/java-examples-dashboard/master/images/downloadZip-Button-Large.png" />
  </a>
</p>

## `aspose.pdf` Package Features

### PDF Document Features

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
- Apply restrictions on content modification, copying, printing and other operations.

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
**Web:** HTML\
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
- **Java Version:** JDK 25 or newer

## Get Started with Aspose.PDF for Java

Aspose hosts Java APIs at the [Aspose Java Repository](https://releases.aspose.com/java/repo/). You can use Aspose.PDF for Java directly in Maven projects with simple configuration. For detailed setup instructions, see [Installing Aspose.PDF for Java from Aspose Repository](https://docs.aspose.com/pdf/java/installation/).

Build all Maven modules from the repository root with:

```bash
mvn clean compile
```

Run one documentation example runner with:

```bash
cd examples/documentation
mvn -DskipTests exec:java "-Dexec.mainClass=com.aspose.pdf.examples.basicoperations.BasicOperationsExamples"
```

## Extract text from a PDF file using Java

```java
import com.aspose.pdf.Document;
import com.aspose.pdf.TextAbsorber;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

try (Document pdfDocument = new Document("input.pdf")) {
  TextAbsorber textAbsorber = new TextAbsorber();
  pdfDocument.getPages().accept(textAbsorber);
  Files.writeString(Path.of("Extracted_text.txt"), textAbsorber.getText(), StandardCharsets.UTF_8);
}
```

[Product Page](https://products.aspose.com/pdf/java) | [Docs](https://docs.aspose.com/pdf/java/) | [Demos](https://products.aspose.app/pdf/family) | [API Reference](https://apireference.aspose.com/pdf/java) | [Examples](https://github.com/aspose-pdf/Aspose.PDF-for-Java/tree/master/examples/documentation/src/main/java/com/aspose/pdf/examples) | [Blog](https://blog.aspose.com/category/pdf/) | [Search](https://search.aspose.com/) | [Free Support](https://forum.aspose.com/c/pdf) | [Temporary License](https://purchase.aspose.com/temporary-license)
