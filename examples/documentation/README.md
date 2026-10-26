![GitHub all releases](https://img.shields.io/github/downloads/aspose-pdf/Aspose.pdf-for-Java/total) ![GitHub](https://img.shields.io/github/license/aspose-pdf/Aspose.pdf-for-java)
# Java API to Process & Manipulate PDF Files

[Aspose.PDF for Java](https://products.aspose.com/pdf/java) is a PDF document creation component that enables your Java applications to read, write and manipulate PDF documents without using Adobe Acrobat.

This module contains runnable Java examples used by Aspose.PDF documentation.

## Layout

Directory | Description
--------- | -----------
`src/main/java/com/aspose/pdf/examples` | Java example runners and operation classes.
`sample-data` | Input and generated output files grouped by example category.
`tools` | Scripts for running all registered example runners.

## Build

From this directory:

```bash
mvn clean compile
```

From the repository root:

```bash
mvn -f examples/documentation/pom.xml clean compile
```

## Run Examples

Run one example runner:

```bash
mvn -DskipTests exec:java "-Dexec.mainClass=com.aspose.pdf.examples.basicoperations.BasicOperationsExamples"
```

Run all registered runners:

```bash
tools/run-all-examples.sh
```

```powershell
tools/run-all-examples.ps1
```

## License

Examples can run without a license in evaluation mode. Provide a license with one of:

- CLI argument: `--license=/path/to/Aspose.PDF.lic`
- JVM property: `-Daspose.pdf.license=/path/to/Aspose.PDF.lic`
- Environment variable: `ASPOSE_PDF_LICENSE`
