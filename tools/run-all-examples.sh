#!/usr/bin/env bash
set -u

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
REPO_ROOT="$(cd "$SCRIPT_DIR/.." && pwd)"

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
      echo "Usage: tools/run-all-examples.sh [--license /path/to/Aspose.PDF.lic] [--stop-on-failure]"
      exit 2
      ;;
  esac
done

EXAMPLE_CLASSES=(
  "com.aspose.pdf.examples.getstarted.GetStartedExamples"
  "com.aspose.pdf.examples.facades.FacadesExamples"
  "com.aspose.pdf.examples.basicoperations.BasicOperationsExamples"
  "com.aspose.pdf.examples.convertpdfdocument.ConvertPdfDocumentExamples"
  "com.aspose.pdf.examples.pdffilemetadata.PdfFileMetadataExamples"
  "com.aspose.pdf.examples.compare.CompareExamples"
  "com.aspose.pdf.examples.attachzugferd.AttachZugferdExamples"
  "com.aspose.pdf.examples.workingwithoperators.WorkingWithOperatorsExamples"
  "com.aspose.pdf.examples.workingwithvectorgraphics.WorkingWithVectorGraphicsExamples"
  "com.aspose.pdf.examples.accessibilitytaggedpdf.AccessibilityTaggedPdfExamples"
  "com.aspose.pdf.examples.navigationandinteraction.NavigationAndInteractionExamples"
  "com.aspose.pdf.examples.parsing.ParsingExamples"
  "com.aspose.pdf.examples.securingandsigning.SecuringAndSigningExamples"
  "com.aspose.pdf.examples.workingwithannotations.WorkingWithAnnotationsExamples"
  "com.aspose.pdf.examples.workingwithartifacts.WorkingWithArtifactsExamples"
  "com.aspose.pdf.examples.workingwithattachments.WorkingWithAttachmentsExamples"
  "com.aspose.pdf.examples.workingwithdocuments.WorkingWithDocumentsExamples"
  "com.aspose.pdf.examples.workingwithforms.WorkingWithFormsExamples"
  "com.aspose.pdf.examples.workingwithgraphs.WorkingWithGraphsExamples"
  "com.aspose.pdf.examples.workingwithimages.WorkingWithImagesExamples"
  "com.aspose.pdf.examples.workingwithpages.WorkingWithPagesExamples"
  "com.aspose.pdf.examples.workingwithtables.WorkingWithTablesExamples"
  "com.aspose.pdf.examples.workingwithtext.WorkingWithTextExamples"
)

if [[ -x "$REPO_ROOT/mvnw" ]]; then
  MAVEN_COMMAND="$REPO_ROOT/mvnw"
elif command -v mvn >/dev/null 2>&1; then
  MAVEN_COMMAND="mvn"
else
  echo "Maven was not found. Install Maven, add it to PATH, or add Maven Wrapper files to the repository."
  exit 1
fi

cd "$REPO_ROOT" || exit 1

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
