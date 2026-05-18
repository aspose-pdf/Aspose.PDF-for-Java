param(
    [string]$LicensePath = "",
    [switch]$StopOnFailure
)

$ErrorActionPreference = "Stop"

$repoRoot = Resolve-Path (Join-Path $PSScriptRoot "..")

$exampleClasses = @(
    "com.aspose.pdf.examples.basicoperations.BasicOperationsExamples"
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
        "-Dexec.mainClass=$MainClass"
    )

    if (-not [string]::IsNullOrWhiteSpace($LicensePath)) {
        $arguments += "-Dexec.args=--license=$LicensePath"
    }

    & $MavenCommand @arguments
    return $LASTEXITCODE
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
        Write-Host "Failed example runners:"
        foreach ($exampleClass in $failed) {
            Write-Host " - $exampleClass"
        }
        exit 1
    }

    Write-Host "All example runners finished successfully."
}
finally {
    Pop-Location
}
