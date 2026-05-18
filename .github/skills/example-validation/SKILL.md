---
name: example-validation
description: 'Validate Aspose.PDF Java example changes by compiling, running example runners, and checking expected output files. Use when editing example classes, adding new categories, or reviewing regressions.'
argument-hint: 'Runner class, license path, expected output files'
user-invocable: true
---
# Example Validation Workflow

Use this skill after changing Java examples to confirm they still compile and produce expected output files.

## When to Use

- After modifying files in src/main/java/com/aspose/pdf/examples
- After adding a new category runner or operation class
- Before opening a PR for examples changes

## Inputs

- Runner class (optional): fully qualified class name, for example com.aspose.pdf.examples.basicoperations.BasicOperationsExamples
- License path (optional): absolute path to Aspose.PDF license file
- Expected outputs (optional): output filenames relative to sample-data/<category>/output

## Procedure

1. Confirm Java toolchain and compile:
   - mvn clean compile
2. Run the selected runner if provided:
   - mvn -DskipTests exec:java -Dexec.mainClass=<runner class>
3. If no runner is provided, run the repository-wide script:
   - Windows PowerShell:
     - tools/run-all-examples.ps1
     - tools/run-all-examples.ps1 -LicensePath "<license path>"
   - Bash:
     - tools/run-all-examples.sh
     - tools/run-all-examples.sh --license <license path>
4. Check output artifacts:
   - Verify expected files exist under sample-data/<category>/output
   - Flag missing files and list them explicitly
5. Summarize validation status:
   - compile: pass or fail
   - run: pass or fail
   - outputs: pass or fail
   - blockers and next actions

## Validation Notes

- JDK 21 is required; builds fail on other versions.
- If no license is provided, examples may run in evaluation mode.
- initializeDataDir creates directories automatically, so missing folders alone do not prove success.

## References

- [AGENTS.md](../../../AGENTS.md)
- [pom.xml](../../../pom.xml)
- [run-all-examples.ps1](../../../tools/run-all-examples.ps1)
- [run-all-examples.sh](../../../tools/run-all-examples.sh)
