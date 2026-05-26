param(
    [string]$LicensePath = "",
    [switch]$StopOnFailure
)

$ErrorActionPreference = "Stop"

$repoRoot = Resolve-Path (Join-Path $PSScriptRoot "..")

$exampleClasses = @(
    "com.aspose.pdf.examples.getstarted.GetStartedExamples",
    "com.aspose.pdf.examples.facades.FacadesExamples",
    "com.aspose.pdf.examples.basicoperations.BasicOperationsExamples",
    "com.aspose.pdf.examples.convertpdfdocument.ConvertPdfDocumentExamples",
    "com.aspose.pdf.examples.pdffilemetadata.PdfFileMetadataExamples",
    "com.aspose.pdf.examples.compare.CompareExamples",
    "com.aspose.pdf.examples.attachzugferd.AttachZugferdExamples",
    "com.aspose.pdf.examples.workingwithoperators.WorkingWithOperatorsExamples",
    "com.aspose.pdf.examples.workingwithvectorgraphics.WorkingWithVectorGraphicsExamples",
    "com.aspose.pdf.examples.accessibilitytaggedpdf.AccessibilityTaggedPdfExamples",
    "com.aspose.pdf.examples.navigationandinteraction.NavigationAndInteractionExamples",
    "com.aspose.pdf.examples.parsing.ParsingExamples",
    "com.aspose.pdf.examples.securingandsigning.SecuringAndSigningExamples",
    "com.aspose.pdf.examples.workingwithannotations.WorkingWithAnnotationsExamples",
    "com.aspose.pdf.examples.workingwithartifacts.WorkingWithArtifactsExamples",
    "com.aspose.pdf.examples.workingwithattachments.WorkingWithAttachmentsExamples",
    "com.aspose.pdf.examples.workingwithdocuments.WorkingWithDocumentsExamples",
    "com.aspose.pdf.examples.workingwithforms.WorkingWithFormsExamples",
    "com.aspose.pdf.examples.workingwithgraphs.WorkingWithGraphsExamples",
    "com.aspose.pdf.examples.workingwithimages.WorkingWithImagesExamples",
    "com.aspose.pdf.examples.workingwithpages.WorkingWithPagesExamples",
    "com.aspose.pdf.examples.workingwithtables.WorkingWithTablesExamples",
    "com.aspose.pdf.examples.workingwithtext.WorkingWithTextExamples"
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

Push-Location $repoRoot
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
