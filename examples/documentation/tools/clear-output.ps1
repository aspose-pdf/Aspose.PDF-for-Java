<#
.SYNOPSIS
Clears documentation sample-data output folders, preserving the folders themselves.
.EXAMPLE
./clear-output-folders.ps1 -WhatIf
.EXAMPLE
./clear-output-folders.ps1
#>
[CmdletBinding(SupportsShouldProcess)]
param()

$ErrorActionPreference = "Stop"
$sampleDataRoot = [System.IO.Path]::GetFullPath((Join-Path $PSScriptRoot "../sample-data"))
$rootPrefix = $sampleDataRoot + [System.IO.Path]::DirectorySeparatorChar

if (-not (Test-Path -LiteralPath $sampleDataRoot -PathType Container)) {
    throw "Sample-data directory not found: $sampleDataRoot"
}

# Inspect without following symbolic links or junctions, including inside outputs.
function Get-SafeDirectories {
    param([string]$Path)

    $directory = Get-Item -LiteralPath $Path -Force
    if ($directory.Attributes -band [System.IO.FileAttributes]::ReparsePoint) {
        throw "Refusing to traverse a symbolic link or junction: $Path"
    }
    $directory
    foreach ($child in Get-ChildItem -LiteralPath $Path -Force) {
        if ($child.Attributes -band [System.IO.FileAttributes]::ReparsePoint) {
            throw "Refusing to traverse a symbolic link or junction: $($child.FullName)"
        }
        if ($child.PSIsContainer) {
            Get-SafeDirectories -Path $child.FullName
        }
    }
}

# Complete validation before removing anything.
$outputDirectories = @(Get-SafeDirectories -Path $sampleDataRoot |
    Where-Object { $_.Name -eq "output" } |
    Sort-Object { $_.FullName.Length } -Descending)

foreach ($directory in $outputDirectories) {
    $targetPath = [System.IO.Path]::GetFullPath($directory.FullName)
    if (-not $targetPath.StartsWith($rootPrefix, [System.StringComparison]::OrdinalIgnoreCase)) {
        throw "Output directory is outside sample-data: $targetPath"
    }
    if ($PSCmdlet.ShouldProcess($targetPath, "Remove all output contents")) {
        Get-ChildItem -LiteralPath $targetPath -Force |
            Remove-Item -Recurse -Force
        Write-Host "Cleared: $targetPath"
    }
}
