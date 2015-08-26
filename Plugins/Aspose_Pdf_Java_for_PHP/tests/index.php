<?php

require_once("../../java/Java.inc");

require_once __DIR__ . '/../vendor/autoload.php';

use Aspose\Pdf\WorkingWithDocumentObject\AddJavascript;
use Aspose\Pdf\WorkingWithDocumentObject\AddToc;
use Aspose\Pdf\WorkingWithDocumentObject\GetDocumentWindow;
use Aspose\Pdf\WorkingWithDocumentObject\GetPdfFileInfo;
use Aspose\Pdf\WorkingWithDocumentObject\SetPdfFileInfo;
use Aspose\Pdf\WorkingWithDocumentObject\GetXMPMetadata;
use Aspose\Pdf\WorkingWithDocumentObject\Optimize;
use Aspose\Pdf\WorkingWithDocumentObject\RemoveMetadata;
use Aspose\Pdf\WorkingWithDocumentObject\SetExpiration;
use Aspose\Pdf\WorkingWithPages\GetNumberOfPages;
use Aspose\Pdf\WorkingWithPages\GetPageProperties;
use Aspose\Pdf\WorkingWithPages\ConcatenatePdfFiles;
use Aspose\Pdf\WorkingWithPages\InsertEmptyPage;
use Aspose\Pdf\WorkingWithPages\InsertEmptyPageAtEndOfFile;
use Aspose\Pdf\WorkingWithPages\SplitAllPages;
use Aspose\Pdf\WorkingWithPages\GetPage;
use Aspose\Pdf\WorkingWithPages\DeletePage;
use Aspose\Pdf\WorkingWithPages\UpdatePageDimensions;
use Aspose\Pdf\WorkingWithText\AddHtml;
use Aspose\Pdf\WorkingWithText\AddText;
use Aspose\Pdf\WorkingWithText\ExtractTextFromAllPages;
use Aspose\Pdf\WorkingWithDocumentConversion\PdfToDoc;
use Aspose\Pdf\WorkingWithDocumentConversion\PdfToExcel;
use Aspose\Pdf\WorkingWithDocumentConversion\PdfToSvg;
use Aspose\Pdf\WorkingWithDocumentConversion\SvgToPdf;


print "Running Aspose\\Pdf\\WorkingWithDocumentObject\\AddJavascript::run()" . PHP_EOL;
AddJavascript::run(__DIR__ . '/data/WorkingWithDocumentObject/AddJavascript/');

print "Running Aspose\\Pdf\\WorkingWithDocumentObject\\AddToc::run()" . PHP_EOL;
AddToc::run(__DIR__ . '/data/WorkingWithDocumentObject/AddToc/');

print "Running Aspose\\Pdf\\WorkingWithDocumentObject\\GetDocumentWindow::run()" . PHP_EOL;
GetDocumentWindow::run(__DIR__ . '/data/WorkingWithDocumentObject/GetDocumentWindow/');

print "Running Aspose\\Pdf\\WorkingWithDocumentObject\\GetPdfFileInfo::run()" . PHP_EOL;
GetPdfFileInfo::run(__DIR__ . '/data/WorkingWithDocumentObject/GetPdfFileInfo/');

print "Running Aspose\\Pdf\\WorkingWithDocumentObject\\SetPdfFileInfo::run()" . PHP_EOL;
SetPdfFileInfo::run(__DIR__ . '/data/WorkingWithDocumentObject/SetPdfFileInfo/');

print "Running Aspose\\Pdf\\WorkingWithDocumentObject\\GetXMPMetadata::run()" . PHP_EOL;
GetXMPMetadata::run(__DIR__ . '/data/WorkingWithDocumentObject/GetXMPMetadata/');

print "Running Aspose\\Pdf\\WorkingWithDocumentObject\\Optimize::run()" . PHP_EOL;
Optimize::run(__DIR__ . '/data/WorkingWithDocumentObject/Optimize/');

print "Running Aspose\\Pdf\\WorkingWithDocumentObject\\RemoveMetadata::run()" . PHP_EOL;
RemoveMetadata::run(__DIR__ . '/data/WorkingWithDocumentObject/RemoveMetadata/');

print "Running Aspose\\Pdf\\WorkingWithDocumentObject\\SetExpiration::run()" . PHP_EOL;
SetExpiration::run(__DIR__ . '/data/WorkingWithDocumentObject/SetExpiration/');

print "Running Aspose\\Pdf\\WorkingWithPages\\GetNumberOfPages::run()" . PHP_EOL;
GetNumberOfPages::run(__DIR__ . '/data/WorkingWithPages/GetNumberOfPages/');

print "Running Aspose\\Pdf\\WorkingWithPages\\GetPageProperties::run()" . PHP_EOL;
GetPageProperties::run(__DIR__ . '/data/WorkingWithPages/GetPageProperties/');

print "Running Aspose\\Pdf\\WorkingWithPages\\ConcatenatePdfFiles::run()" . PHP_EOL;
ConcatenatePdfFiles::run(__DIR__ . '/data/WorkingWithPages/ConcatenatePdfFiles/');

print "Running Aspose\\Pdf\\WorkingWithPages\\InsertEmptyPage::run()" . PHP_EOL;
InsertEmptyPage::run(__DIR__ . '/data/WorkingWithPages/InsertEmptyPage/');

print "Running Aspose\\Pdf\\WorkingWithPages\\InsertEmptyPageAtEndOfFile::run()" . PHP_EOL;
InsertEmptyPageAtEndOfFile::run(__DIR__ . '/data/WorkingWithPages/InsertEmptyPageAtEndOfFile/');

print "Running Aspose\\Pdf\\WorkingWithPages\\SplitAllPages::run()" . PHP_EOL;
SplitAllPages::run(__DIR__ . '/data/WorkingWithPages/SplitAllPages/');

print "Running Aspose\\Pdf\\WorkingWithPages\\GetPage::run()" . PHP_EOL;
GetPage::run(__DIR__ . '/data/WorkingWithPages/GetPage/');

print "Running Aspose\\Pdf\\WorkingWithPages\\DeletePage::run()" . PHP_EOL;
DeletePage::run(__DIR__ . '/data/WorkingWithPages/DeletePage/');

print "Running Aspose\\Pdf\\WorkingWithPages\\UpdatePageDimensions::run()" . PHP_EOL;
UpdatePageDimensions::run(__DIR__ . '/data/WorkingWithPages/UpdatePageDimensions/');

print "Running Aspose\\Pdf\\WorkingWithText\\AddHtml::run()" . PHP_EOL;
AddHtml::run(__DIR__ . '/data/WorkingWithText/AddHtml/');

print "Running Aspose\\Pdf\\WorkingWithText\\AddText::run()" . PHP_EOL;
AddText::run(__DIR__ . '/data/WorkingWithText/AddText/');

print "Running Aspose\\Pdf\\WorkingWithText\\ExtractTextFromAllPages::run()" . PHP_EOL;
ExtractTextFromAllPages::run(__DIR__ . '/data/WorkingWithText/ExtractTextFromAllPages/');

print "Running Aspose\\Pdf\\WorkingWithDocumentConversion\\PdfToDoc::run()" . PHP_EOL;
PdfToDoc::run(__DIR__ . '/data/WorkingWithDocumentConversion/PdfToDoc/');

print "Running Aspose\\Pdf\\WorkingWithDocumentConversion\\PdfToExcel::run()" . PHP_EOL;
PdfToExcel::run(__DIR__ . '/data/WorkingWithDocumentConversion/PdfToExcel/');

print "Running Aspose\\Pdf\\WorkingWithDocumentConversion\\PdfToSvg::run()" . PHP_EOL;
PdfToSvg::run(__DIR__ . '/data/WorkingWithDocumentConversion/PdfToSvg/');

print "Running Aspose\\Pdf\\WorkingWithDocumentConversion\\SvgToPdf::run()" . PHP_EOL;
SvgToPdf::run(__DIR__ . '/data/WorkingWithDocumentConversion/SvgToPdf/');
