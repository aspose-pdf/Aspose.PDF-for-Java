param(
    [string]$LicensePath = "",
    [switch]$StopOnFailure
)

$ErrorActionPreference = "Stop"

$examplesRoot = Resolve-Path (Join-Path $PSScriptRoot "..")
$repoRoot = Resolve-Path (Join-Path $PSScriptRoot "../../..")

$exampleClasses = @(
    "com.aspose.pdf.examples.getstarted.GetStartedExamples",
    "com.aspose.pdf.examples.facades.FacadesExamples",
    "com.aspose.pdf.examples.facades.pdfannotationeditor.PdfAnnotationEditorExamples",
    "com.aspose.pdf.examples.facades.pdfbookmarkeditor.PdfBookmarkUpdateDeleteExamples",
    "com.aspose.pdf.examples.facades.pdfextractor.PdfExtractorExamples",
    "com.aspose.pdf.examples.facades.pdffilemend.PdfFileMendExamples",
    "com.aspose.pdf.examples.facades.pdfpageeditor.PdfPageEditorExamples",
    "com.aspose.pdf.examples.facades.form.FormExamples",
    "com.aspose.pdf.examples.facades.formeditor.FormEditorExamples",
    "com.aspose.pdf.examples.facades.pdfbookmarkeditor.PdfBookmarkCreateExamples",
    "com.aspose.pdf.examples.facades.pdfbookmarkeditor.PdfBookmarkImportExportExamples",
    "com.aspose.pdf.examples.facades.pdfcontenteditor.PdfContentEditorExamples",
    "com.aspose.pdf.examples.facades.pdfconverter.PdfConverterExamples",
    "com.aspose.pdf.examples.facades.pdffileeditor.PdfFileEditorExamples",
    "com.aspose.pdf.examples.facades.pdffileinfo.PdfFileInfoExamples",
    "com.aspose.pdf.examples.facades.pdffilesecurity.PdfFileSecurityExamples",
    "com.aspose.pdf.examples.facades.pdffilesignature.PdfFileSignatureExamples",
    "com.aspose.pdf.examples.facades.pdffilestamp.PdfFileStampExamples",
    "com.aspose.pdf.examples.facades.pdfviewer.PdfViewerExamples",
    "com.aspose.pdf.examples.facades.pdfxmpmetadata.PdfXmpMetaDataExamples",
    "com.aspose.pdf.examples.facades.stamp.StampExamples",
    "com.aspose.pdf.examples.basicoperations.BasicOperationsExamples",
    "com.aspose.pdf.examples.basicoperations.CreateDocumentExamples",
    "com.aspose.pdf.examples.basicoperations.MergeDocumentExamples",
    "com.aspose.pdf.examples.basicoperations.OpenDocumentExamples",
    "com.aspose.pdf.examples.basicoperations.ProtectDocumentExamples",
    "com.aspose.pdf.examples.basicoperations.SaveDocumentExamples",
    "com.aspose.pdf.examples.basicoperations.SplitDocumentExamples",
    "com.aspose.pdf.examples.convertpdfdocument.ConvertPdfDocumentExamples",
    "com.aspose.pdf.examples.convertpdfdocument.HtmlToPdfExamples",
    "com.aspose.pdf.examples.convertpdfdocument.ImagesToPdfExamples",
    "com.aspose.pdf.examples.convertpdfdocument.OtherFileToPdfExamples",
    "com.aspose.pdf.examples.convertpdfdocument.PdfStandardsExamples",
    "com.aspose.pdf.examples.convertpdfdocument.PdfStandardToPdfExamples",
    "com.aspose.pdf.examples.convertpdfdocument.PdfToExcelExamples",
    "com.aspose.pdf.examples.convertpdfdocument.PdfToHtmlExamples",
    "com.aspose.pdf.examples.convertpdfdocument.PdfToImagesExamples",
    "com.aspose.pdf.examples.convertpdfdocument.PdfToOtherFileExamples",
    "com.aspose.pdf.examples.convertpdfdocument.PdfToPowerPointExamples",
    "com.aspose.pdf.examples.convertpdfdocument.PdfToWordExamples",
    "com.aspose.pdf.examples.pdffilemetadata.PdfFileMetadataExamples",
    "com.aspose.pdf.examples.compare.CompareExamples",
    "com.aspose.pdf.examples.attachzugferd.AttachZugferdExamples",
    "com.aspose.pdf.examples.workingwithoperators.WorkingWithOperatorsExamples",
    "com.aspose.pdf.examples.workingwithvectorgraphics.WorkingWithVectorGraphicsExamples",
    "com.aspose.pdf.examples.accessibilitytaggedpdf.AccessibilityTaggedPdfExamples",
    "com.aspose.pdf.examples.accessibilitytaggedpdf.TaggedPdfCreateExamples",
    "com.aspose.pdf.examples.accessibilitytaggedpdf.TaggedPdfExtractExamples",
    "com.aspose.pdf.examples.accessibilitytaggedpdf.TaggedPdfSetPropertiesExamples",
    "com.aspose.pdf.examples.accessibilitytaggedpdf.TaggedPdfTablesExamples",
    "com.aspose.pdf.examples.navigationandinteraction.NavigationAndInteractionExamples",
    "com.aspose.pdf.examples.navigationandinteraction.ActionsExamples",
    "com.aspose.pdf.examples.navigationandinteraction.bookmarks.AddExamples",
    "com.aspose.pdf.examples.navigationandinteraction.bookmarks.GetExamples",
    "com.aspose.pdf.examples.navigationandinteraction.links.CreateExamples",
    "com.aspose.pdf.examples.navigationandinteraction.links.ExtractExamples",
    "com.aspose.pdf.examples.navigationandinteraction.links.UpdateExamples",
    "com.aspose.pdf.examples.parsing.ParsingExamples",
    "com.aspose.pdf.examples.parsing.ParsingAcroformsExamples",
    "com.aspose.pdf.examples.parsing.ParsingAnnotationSpecialTextExamples",
    "com.aspose.pdf.examples.parsing.ParsingBasicExtractionExamples",
    "com.aspose.pdf.examples.parsing.ParsingFontsExamples",
    "com.aspose.pdf.examples.parsing.ParsingImagesExamples",
    "com.aspose.pdf.examples.parsing.ParsingMultiColumnExamples",
    "com.aspose.pdf.examples.parsing.ParsingRegionBasedExtractionExamples",
    "com.aspose.pdf.examples.parsing.ParsingTablesExamples",
    "com.aspose.pdf.examples.parsing.ParsingVectorGraphicsExamples",
    "com.aspose.pdf.examples.securingandsigning.SecuringAndSigningExamples",
    "com.aspose.pdf.examples.workingwithannotations.WorkingWithAnnotationsExamples",
    "com.aspose.pdf.examples.workingwithannotations.AnnotationsImportExportExamples",
    "com.aspose.pdf.examples.workingwithannotations.InteractiveAnnotationExamples",
    "com.aspose.pdf.examples.workingwithannotations.MarkupAnnotationExamples",
    "com.aspose.pdf.examples.workingwithannotations.MediaAnnotationExamples",
    "com.aspose.pdf.examples.workingwithannotations.SecurityAnnotationExamples",
    "com.aspose.pdf.examples.workingwithannotations.ShapeAnnotationExamples",
    "com.aspose.pdf.examples.workingwithannotations.TextAnnotationExamples",
    "com.aspose.pdf.examples.workingwithannotations.WatermarkAnnotationExamples",
    "com.aspose.pdf.examples.workingwithartifacts.WorkingWithArtifactsExamples",
    "com.aspose.pdf.examples.workingwithartifacts.ArtifactsBackgroundsExamples",
    "com.aspose.pdf.examples.workingwithartifacts.ArtifactsBatesNumberingExamples",
    "com.aspose.pdf.examples.workingwithartifacts.ArtifactsCountingExamples",
    "com.aspose.pdf.examples.workingwithartifacts.ArtifactsHeaderFooterExamples",
    "com.aspose.pdf.examples.workingwithartifacts.ArtifactsWatermarksExamples",
    "com.aspose.pdf.examples.workingwithattachments.WorkingWithAttachmentsExamples",
    "com.aspose.pdf.examples.workingwithattachments.AttachmentsAddExamples",
    "com.aspose.pdf.examples.workingwithattachments.AttachmentsExtractExamples",
    "com.aspose.pdf.examples.workingwithattachments.AttachmentsPortfolioExamples",
    "com.aspose.pdf.examples.workingwithattachments.AttachmentsRemoveExamples",
    "com.aspose.pdf.examples.workingwithdocuments.WorkingWithDocumentsExamples",
    "com.aspose.pdf.examples.workingwithdocuments.CreatePdfDocumentExamples",
    "com.aspose.pdf.examples.workingwithdocuments.FormattingPdfDocumentExamples",
    "com.aspose.pdf.examples.workingwithdocuments.ManipulatePdfDocumentExamples",
    "com.aspose.pdf.examples.workingwithdocuments.MergePdfDocumentExamples",
    "com.aspose.pdf.examples.workingwithdocuments.OptimizeExamples",
    "com.aspose.pdf.examples.workingwithdocuments.SplitPdfDocumentExamples",
    "com.aspose.pdf.examples.workingwithdocuments.WorkWithLayersExamples",
    "com.aspose.pdf.examples.workingwithforms.WorkingWithFormsExamples",
    "com.aspose.pdf.examples.workingwithforms.AcroformsCreateExamples",
    "com.aspose.pdf.examples.workingwithforms.AcroformsDeleteExamples",
    "com.aspose.pdf.examples.workingwithforms.AcroformsExtractExamples",
    "com.aspose.pdf.examples.workingwithforms.AcroformsFillExamples",
    "com.aspose.pdf.examples.workingwithforms.AcroFormsImportExportExamples",
    "com.aspose.pdf.examples.workingwithforms.AcroformsModifingExamples",
    "com.aspose.pdf.examples.workingwithforms.AcroformsPostingExamples",
    "com.aspose.pdf.examples.workingwithforms.XfaFormsExamples",
    "com.aspose.pdf.examples.workingwithgraphs.WorkingWithGraphsExamples",
    "com.aspose.pdf.examples.workingwithgraphs.GraphsArcExamples",
    "com.aspose.pdf.examples.workingwithgraphs.GraphsCheckBoundsExamples",
    "com.aspose.pdf.examples.workingwithgraphs.GraphsCircleExamples",
    "com.aspose.pdf.examples.workingwithgraphs.GraphsCurveExamples",
    "com.aspose.pdf.examples.workingwithgraphs.GraphsEllipseExamples",
    "com.aspose.pdf.examples.workingwithgraphs.GraphsLineExamples",
    "com.aspose.pdf.examples.workingwithgraphs.GraphsRectangleExamples",
    "com.aspose.pdf.examples.workingwithimages.WorkingWithImagesExamples",
    "com.aspose.pdf.examples.workingwithimages.AddImageExamples",
    "com.aspose.pdf.examples.workingwithimages.DeleteImageExamples",
    "com.aspose.pdf.examples.workingwithimages.ExtractImageExamples",
    "com.aspose.pdf.examples.workingwithimages.GetSearchImageExamples",
    "com.aspose.pdf.examples.workingwithimages.ReplaceImageExamples",
    "com.aspose.pdf.examples.workingwithpages.WorkingWithPagesExamples",
    "com.aspose.pdf.examples.workingwithpages.AddHeaderFooterExamples",
    "com.aspose.pdf.examples.workingwithpages.AddPagesExamples",
    "com.aspose.pdf.examples.workingwithpages.ChangeSizeExamples",
    "com.aspose.pdf.examples.workingwithpages.CropExamples",
    "com.aspose.pdf.examples.workingwithpages.DeletePagesExamples",
    "com.aspose.pdf.examples.workingwithpages.ExtractPagesExamples",
    "com.aspose.pdf.examples.workingwithpages.GetAndSetPagePropertiesExamples",
    "com.aspose.pdf.examples.workingwithpages.MovePagesExamples",
    "com.aspose.pdf.examples.workingwithpages.RotatePagesExamples",
    "com.aspose.pdf.examples.workingwithpages.StampingExamples",
    "com.aspose.pdf.examples.workingwithtables.WorkingWithTablesExamples",
    "com.aspose.pdf.examples.workingwithtables.AddTablesExamples",
    "com.aspose.pdf.examples.workingwithtables.ExtractTableExamples",
    "com.aspose.pdf.examples.workingwithtables.IntegrateTableExamples",
    "com.aspose.pdf.examples.workingwithtables.ManipulateTableExamples",
    "com.aspose.pdf.examples.workingwithtables.RemoveTableExamples",
    "com.aspose.pdf.examples.workingwithtext.WorkingWithTextExamples",
    "com.aspose.pdf.examples.workingwithtext.TextAddingExamples",
    "com.aspose.pdf.examples.workingwithtext.TextFloatingBoxExamples",
    "com.aspose.pdf.examples.workingwithtext.TextFormattingExamples",
    "com.aspose.pdf.examples.workingwithtext.TextReplacingExamples",
    "com.aspose.pdf.examples.workingwithtext.TextRotateExamples",
    "com.aspose.pdf.examples.workingwithtext.TextSearchExamples",
    "com.aspose.pdf.examples.workingwithtext.TextTooltipExamples"
)

function Get-MavenCommand {
    $mavenWrapper = Join-Path $repoRoot "mvnw.cmd"
    if (Test-Path $mavenWrapper) {
        return $mavenWrapper
    }

    $maven = Get-Command mvn -ErrorAction SilentlyContinue
    if ($null -eq $maven) {
        throw "Maven was not found. Install Maven, add it to PATH, or add Maven Wrapper files to the repository."
    }

    return $maven.Source
}

function Invoke-ExampleClass {
    param(
        [string]$MavenCommand,
        [string]$MainClass
    )

    Write-Host ""
    Write-Host "Running $MainClass"

    $arguments = @(
        "-DskipTests",
        "exec:java",
        "-Dexec.mainClass=$MainClass",
        "-Dexec.cleanupDaemonThreads=false"
    )

    if (-not [string]::IsNullOrWhiteSpace($LicensePath)) {
        $arguments += "-Dexec.args=--license=$LicensePath"
    }

    & $MavenCommand @arguments 2>&1 | ForEach-Object {
        $line = $_.ToString()
        if ($line -like "*Success:*") {
            Write-Host $line -ForegroundColor Green
        }
        elseif ($line -like "*Failed:*") {
            Write-Host $line -ForegroundColor Red
        }
        else {
            Write-Host $line
        }
    }

    $exitCode = $LASTEXITCODE
    return $exitCode
}

Push-Location $examplesRoot
try {
    $mavenCommand = Get-MavenCommand
    $failed = @()

    foreach ($exampleClass in $exampleClasses) {
        $exitCode = Invoke-ExampleClass -MavenCommand $mavenCommand -MainClass $exampleClass
        if ($exitCode -ne 0) {
            $failed += $exampleClass
            if ($StopOnFailure) {
                break
            }
        }
    }

    Write-Host ""
    if ($failed.Count -gt 0) {
        Write-Host "Failed example runners:" -ForegroundColor Red
        foreach ($exampleClass in $failed) {
            Write-Host " - $exampleClass" -ForegroundColor Red
        }
        exit 1
    }

    Write-Host "All example runners finished successfully." -ForegroundColor Green
}
finally {
    Pop-Location
}
