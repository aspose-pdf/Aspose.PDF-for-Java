# AGENTS.md

This file helps AI coding agents work effectively in this repository.

## Scope and Goal

- Repository type: Java Maven examples for Aspose.PDF.
- Primary goal: add and maintain runnable example code under `src/main/java/com/aspose/pdf/examples` and matching sample data under `sample-data`.

## Environment and Build

- Required Java version: JDK 25 or newer (enforced by Maven Enforcer in `pom.xml`).
- Build command: `mvn clean compile`.
- Run one example runner:
  - `mvn -DskipTests exec:java -Dexec.mainClass=com.aspose.pdf.examples.basicoperations.BasicOperationsExamples`
- Run all registered runners:
  - PowerShell: `tools/run-all-examples.ps1 [-LicensePath "C:\path\Aspose.PDF.lic"] [-StopOnFailure]`
  - Bash: `tools/run-all-examples.sh [--license /path/Aspose.PDF.lic] [--stop-on-failure]`

## License Handling

- License can be provided in this precedence order (see `ExampleConfig`):
  - CLI argument: `--license=/path/to/Aspose.PDF.lic`
  - JVM property: `-Daspose.pdf.license=/path/to/Aspose.PDF.lic`
  - Environment variable: `ASPOSE_PDF_LICENSE`
- If no license is provided, examples still run but may operate in evaluation mode.

## Code Layout and Patterns

- Shared helpers:
  - `ExampleConfig`: license resolution + sample-data directory initialization.
  - `ExampleDataDirs`: input/output path helper.
  - `ExampleRunner`: wraps examples and logs success/failure per operation.
- Current implemented category: `basicoperations`.
- Naming convention:
  - Category runner class: `XxxExamples` with `runAllExamples(String licensePath)` and `main(String[] args)`.
  - Operation classes follow the same `*Examples` suffix.
- Typical flow inside `runAllExamples`:
  1. `ExampleConfig.setLicense(licensePath)`
  2. `ExampleConfig.initializeDataDir("category_name")`
  3. `ExampleRunner.run("Operation name", () -> ...)` per operation

## Data Directory Convention

- Keep source and sample-data category names aligned:
  - Java package: `...examples.<categorypackage>`
  - Sample data folder: `sample-data/<category_folder>/input` and `sample-data/<category_folder>/output`
- `initializeDataDir` creates missing directories automatically.

## Editing Guidance for Agents

- Keep examples simple, runnable, and focused on one feature each.
- Prefer `Path` (`java.nio.file.Path`) for file paths and convert to string only at Aspose API boundaries.
- Always close `Document` objects (try-with-resources or try/finally).
- Preserve existing output logging style (`Success:` / `Failed:`) via `ExampleRunner`.
- Do not add heavyweight frameworks; keep dependencies minimal and Maven-based.

## README Update Guidance

- For `README.md` changes, keep runtime/version claims synchronized with `pom.xml` (for example Java and dependency versions).
- Keep quick-start commands runnable and aligned with repository scripts in `tools/`.
- Prefer linking to canonical docs (`docs.aspose.com`, API reference, and repository files) instead of duplicating long procedural content.
- Preserve existing product positioning and support/resource links unless the task explicitly requests branding or navigation changes.
- If README examples are changed, prefer short snippets and point to runnable examples under `src/main/java/com/aspose/pdf/examples`.

## Known Pitfalls

- JDK older than 25 will fail build due to the enforcer rule.
- Many category directories are placeholders; avoid assuming examples already exist there.
- Input files are assumed to exist in `sample-data/<category>/input`; add missing sample files when introducing new examples.

## Useful References

- Project overview: [README.md](README.md)
- Build/tooling: [pom.xml](pom.xml)
- Scripted execution: [tools/run-all-examples.ps1](tools/run-all-examples.ps1), [tools/run-all-examples.sh](tools/run-all-examples.sh)
- Docs style instruction: [.github/instructions/docs-style.instructions.md](.github/instructions/docs-style.instructions.md)
- README-focused instruction: [.github/instructions/readme-maintenance.instructions.md](.github/instructions/readme-maintenance.instructions.md)
- README-focused prompt: [.github/prompts/update-readme.prompt.md](.github/prompts/update-readme.prompt.md)
- Aspose docs: <https://docs.aspose.com/pdf/java/>
- API reference: <https://apireference.aspose.com/pdf/java>
