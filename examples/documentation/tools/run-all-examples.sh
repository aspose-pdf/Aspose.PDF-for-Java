#!/usr/bin/env bash
set -u

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
EXAMPLES_ROOT="$(cd "$SCRIPT_DIR/.." && pwd)"
REPO_ROOT="$(cd "$SCRIPT_DIR/../../.." && pwd)"

LICENSE_PATH=""
STOP_ON_FAILURE=0

while [[ $# -gt 0 ]]; do
  case "$1" in
    --license)
      LICENSE_PATH="${2:-}"
      shift 2
      ;;
    --stop-on-failure)
      STOP_ON_FAILURE=1
      shift
      ;;
    *)
      echo "Unknown argument: $1"
      echo "Usage: examples/documentation/tools/run-all-examples.sh [--license /path/to/Aspose.PDF.lic] [--stop-on-failure]"
      exit 2
      ;;
  esac
done

EXAMPLE_CLASSES=(
  "com.aspose.pdf.examples.getstarted.GetStartedExamples"
  "com.aspose.pdf.examples.facades.FacadesExamples"
  "com.aspose.pdf.examples.facades.pdfannotationeditor.PdfAnnotationEditorExamples"
  "com.aspose.pdf.examples.facades.pdfbookmarkeditor.UpdateDeleteExamples"
  "com.aspose.pdf.examples.facades.pdfextractor.PdfExtractorExamples"
  "com.aspose.pdf.examples.facades.pdffilemend.PdfFileMendExamples"
  "com.aspose.pdf.examples.facades.pdfpageeditor.PdfPageEditorExamples"
  "com.aspose.pdf.examples.basicoperations.BasicOperationsExamples"
  "com.aspose.pdf.examples.basicoperations.CreateDocumentExamples"
  "com.aspose.pdf.examples.basicoperations.MergeDocumentExamples"
  "com.aspose.pdf.examples.basicoperations.OpenDocumentExamples"
  "com.aspose.pdf.examples.basicoperations.ProtectDocumentExamples"
  "com.aspose.pdf.examples.basicoperations.SaveDocumentExamples"
  "com.aspose.pdf.examples.basicoperations.SplitDocumentExamples"
  "com.aspose.pdf.examples.convertpdfdocument.ConvertPdfDocumentExamples"
  "com.aspose.pdf.examples.convertpdfdocument.HtmlToPdfExamples"
  "com.aspose.pdf.examples.convertpdfdocument.ImagesToPdfExamples"
  "com.aspose.pdf.examples.convertpdfdocument.OtherFileToPdfExamples"
  "com.aspose.pdf.examples.convertpdfdocument.PdfStandardsExamples"
  "com.aspose.pdf.examples.convertpdfdocument.PdfStandardToPdfExamples"
  "com.aspose.pdf.examples.convertpdfdocument.PdfToExcelExamples"
  "com.aspose.pdf.examples.convertpdfdocument.PdfToHtmlExamples"
  "com.aspose.pdf.examples.convertpdfdocument.PdfToImagesExamples"
  "com.aspose.pdf.examples.convertpdfdocument.PdfToOtherFileExamples"
  "com.aspose.pdf.examples.convertpdfdocument.PdfToPowerPointExamples"
  "com.aspose.pdf.examples.convertpdfdocument.PdfToWordExamples"
  "com.aspose.pdf.examples.pdffilemetadata.PdfFileMetadataExamples"
  "com.aspose.pdf.examples.compare.CompareExamples"
  "com.aspose.pdf.examples.attachzugferd.AttachZugferdExamples"
  "com.aspose.pdf.examples.workingwithoperators.WorkingWithOperatorsExamples"
  "com.aspose.pdf.examples.workingwithvectorgraphics.WorkingWithVectorGraphicsExamples"
  "com.aspose.pdf.examples.accessibilitytaggedpdf.AccessibilityTaggedPdfExamples"
  "com.aspose.pdf.examples.accessibilitytaggedpdf.TaggedPdfCreateExamples"
  "com.aspose.pdf.examples.accessibilitytaggedpdf.TaggedPdfExtractExamples"
  "com.aspose.pdf.examples.accessibilitytaggedpdf.TaggedPdfSetPropertiesExamples"
  "com.aspose.pdf.examples.accessibilitytaggedpdf.TaggedPdfTablesExamples"
  "com.aspose.pdf.examples.navigationandinteraction.NavigationAndInteractionExamples"
  "com.aspose.pdf.examples.navigationandinteraction.ActionsExamples"
  "com.aspose.pdf.examples.parsing.ParsingExamples"
  "com.aspose.pdf.examples.parsing.ParsingAcroformsExamples"
  "com.aspose.pdf.examples.parsing.ParsingAnnotationSpecialTextExamples"
  "com.aspose.pdf.examples.parsing.ParsingBasicExtractionExamples"
  "com.aspose.pdf.examples.parsing.ParsingFontsExamples"
  "com.aspose.pdf.examples.parsing.ParsingImagesExamples"
  "com.aspose.pdf.examples.parsing.ParsingMultiColumnExamples"
  "com.aspose.pdf.examples.parsing.ParsingRegionBasedExtractionExamples"
  "com.aspose.pdf.examples.parsing.ParsingTablesExamples"
  "com.aspose.pdf.examples.parsing.ParsingVectorGraphicsExamples"
  "com.aspose.pdf.examples.securingandsigning.SecuringAndSigningExamples"
  "com.aspose.pdf.examples.workingwithannotations.WorkingWithAnnotationsExamples"
  "com.aspose.pdf.examples.workingwithannotations.AnnotationsImportExportExamples"
  "com.aspose.pdf.examples.workingwithannotations.InteractiveAnnotationExamples"
  "com.aspose.pdf.examples.workingwithannotations.MarkupAnnotationExamples"
  "com.aspose.pdf.examples.workingwithannotations.MediaAnnotationExamples"
  "com.aspose.pdf.examples.workingwithannotations.SecurityAnnotationExamples"
  "com.aspose.pdf.examples.workingwithannotations.ShapeAnnotationExamples"
  "com.aspose.pdf.examples.workingwithannotations.TextAnnotationExamples"
  "com.aspose.pdf.examples.workingwithannotations.WatermarkAnnotationExamples"
  "com.aspose.pdf.examples.workingwithartifacts.WorkingWithArtifactsExamples"
  "com.aspose.pdf.examples.workingwithartifacts.ArtifactsBackgroundsExamples"
  "com.aspose.pdf.examples.workingwithartifacts.ArtifactsBatesNumberingExamples"
  "com.aspose.pdf.examples.workingwithartifacts.ArtifactsCountingExamples"
  "com.aspose.pdf.examples.workingwithartifacts.ArtifactsHeaderFooterExamples"
  "com.aspose.pdf.examples.workingwithartifacts.ArtifactsWatermarksExamples"
  "com.aspose.pdf.examples.workingwithattachments.WorkingWithAttachmentsExamples"
  "com.aspose.pdf.examples.workingwithattachments.AttachmentsAddExamples"
  "com.aspose.pdf.examples.workingwithattachments.AttachmentsExtractExamples"
  "com.aspose.pdf.examples.workingwithattachments.AttachmentsPortfolioExamples"
  "com.aspose.pdf.examples.workingwithattachments.AttachmentsRemoveExamples"
  "com.aspose.pdf.examples.workingwithdocuments.WorkingWithDocumentsExamples"
  "com.aspose.pdf.examples.workingwithdocuments.CreatePdfDocumentExamples"
  "com.aspose.pdf.examples.workingwithdocuments.FormattingPdfDocumentExamples"
  "com.aspose.pdf.examples.workingwithdocuments.ManipulatePdfDocumentExamples"
  "com.aspose.pdf.examples.workingwithdocuments.MergePdfDocumentExamples"
  "com.aspose.pdf.examples.workingwithdocuments.OptimizeExamples"
  "com.aspose.pdf.examples.workingwithdocuments.SplitPdfDocumentExamples"
  "com.aspose.pdf.examples.workingwithdocuments.WorkWithLayersExamples"
  "com.aspose.pdf.examples.workingwithforms.WorkingWithFormsExamples"
  "com.aspose.pdf.examples.workingwithforms.AcroformsCreateExamples"
  "com.aspose.pdf.examples.workingwithforms.AcroformsDeleteExamples"
  "com.aspose.pdf.examples.workingwithforms.AcroformsExtractExamples"
  "com.aspose.pdf.examples.workingwithforms.AcroformsFillExamples"
  "com.aspose.pdf.examples.workingwithforms.AcroFormsImportExportExamples"
  "com.aspose.pdf.examples.workingwithforms.AcroformsModifingExamples"
  "com.aspose.pdf.examples.workingwithforms.AcroformsPostingExamples"
  "com.aspose.pdf.examples.workingwithforms.XfaFormsExamples"
  "com.aspose.pdf.examples.workingwithgraphs.WorkingWithGraphsExamples"
  "com.aspose.pdf.examples.workingwithgraphs.GraphsArcExamples"
  "com.aspose.pdf.examples.workingwithgraphs.GraphsCheckBoundsExamples"
  "com.aspose.pdf.examples.workingwithgraphs.GraphsCircleExamples"
  "com.aspose.pdf.examples.workingwithgraphs.GraphsCurveExamples"
  "com.aspose.pdf.examples.workingwithgraphs.GraphsEllipseExamples"
  "com.aspose.pdf.examples.workingwithgraphs.GraphsLineExamples"
  "com.aspose.pdf.examples.workingwithgraphs.GraphsRectangleExamples"
  "com.aspose.pdf.examples.workingwithimages.WorkingWithImagesExamples"
  "com.aspose.pdf.examples.workingwithimages.AddImageExamples"
  "com.aspose.pdf.examples.workingwithimages.DeleteImageExamples"
  "com.aspose.pdf.examples.workingwithimages.ExtractImageExamples"
  "com.aspose.pdf.examples.workingwithimages.GetSearchImageExamples"
  "com.aspose.pdf.examples.workingwithimages.ReplaceImageExamples"
  "com.aspose.pdf.examples.workingwithpages.WorkingWithPagesExamples"
  "com.aspose.pdf.examples.workingwithpages.AddHeaderFooterExamples"
  "com.aspose.pdf.examples.workingwithpages.AddPagesExamples"
  "com.aspose.pdf.examples.workingwithpages.ChangeSizeExamples"
  "com.aspose.pdf.examples.workingwithpages.CropExamples"
  "com.aspose.pdf.examples.workingwithpages.DeletePagesExamples"
  "com.aspose.pdf.examples.workingwithpages.ExtractPagesExamples"
  "com.aspose.pdf.examples.workingwithpages.GetAndSetPagePropertiesExamples"
  "com.aspose.pdf.examples.workingwithpages.MovePagesExamples"
  "com.aspose.pdf.examples.workingwithpages.RotatePagesExamples"
  "com.aspose.pdf.examples.workingwithpages.StampingExamples"
  "com.aspose.pdf.examples.workingwithtables.WorkingWithTablesExamples"
  "com.aspose.pdf.examples.workingwithtables.AddTablesExamples"
  "com.aspose.pdf.examples.workingwithtables.ExtractTableExamples"
  "com.aspose.pdf.examples.workingwithtables.IntegrateTableExamples"
  "com.aspose.pdf.examples.workingwithtables.ManipulateTableExamples"
  "com.aspose.pdf.examples.workingwithtables.RemoveTableExamples"
  "com.aspose.pdf.examples.workingwithtext.WorkingWithTextExamples"
  "com.aspose.pdf.examples.workingwithtext.TextAddingExamples"
  "com.aspose.pdf.examples.workingwithtext.TextFloatingBoxExamples"
  "com.aspose.pdf.examples.workingwithtext.TextFormattingExamples"
  "com.aspose.pdf.examples.workingwithtext.TextReplacingExamples"
  "com.aspose.pdf.examples.workingwithtext.TextRotateExamples"
  "com.aspose.pdf.examples.workingwithtext.TextSearchExamples"
  "com.aspose.pdf.examples.workingwithtext.TextTooltipExamples"
)

if [[ -x "$REPO_ROOT/mvnw" ]]; then
  MAVEN_COMMAND="$REPO_ROOT/mvnw"
elif command -v mvn >/dev/null 2>&1; then
  MAVEN_COMMAND="mvn"
else
  echo "Maven was not found. Install Maven, add it to PATH, or add Maven Wrapper files to the repository."
  exit 1
fi

cd "$EXAMPLES_ROOT" || exit 1

FAILED=()
for EXAMPLE_CLASS in "${EXAMPLE_CLASSES[@]}"; do
  echo
  echo "Running $EXAMPLE_CLASS"

  ARGS=(
    "-DskipTests"
    "exec:java"
    "-Dexec.mainClass=$EXAMPLE_CLASS"
    "-Dexec.cleanupDaemonThreads=false"
  )

  if [[ -n "$LICENSE_PATH" ]]; then
    ARGS+=("-Dexec.args=--license=$LICENSE_PATH")
  fi

  "$MAVEN_COMMAND" "${ARGS[@]}"
  EXIT_CODE=$?

  if [[ $EXIT_CODE -ne 0 ]]; then
    FAILED+=("$EXAMPLE_CLASS")
    if [[ $STOP_ON_FAILURE -eq 1 ]]; then
      break
    fi
  fi
done

echo
if [[ ${#FAILED[@]} -gt 0 ]]; then
  echo "Failed example runners:"
  for EXAMPLE_CLASS in "${FAILED[@]}"; do
    echo " - $EXAMPLE_CLASS"
  done
  exit 1
fi

echo "All example runners finished successfully."
