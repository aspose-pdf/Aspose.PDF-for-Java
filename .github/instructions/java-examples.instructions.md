---
description: "Use when creating or modifying Java example classes for Aspose.PDF examples, including runners, category orchestration, file path usage, and sample-data folder alignment."
name: "Java Examples Conventions"
applyTo: "examples/documentation/src/main/java/com/aspose/pdf/examples/**/*.java"
---
# Java Examples Conventions

## Follow Existing Structure

- Keep classes in package paths under examples/documentation/src/main/java/com/aspose/pdf/examples.
- Use final utility-style classes with a private constructor for example groups.
- Keep the category runner pattern:
  - runAllExamples(String licensePath)
  - main(String[] args)

## Required Runtime Flow

1. Resolve or pass through license path with ExampleConfig.
2. Call ExampleConfig.setLicense(licensePath).
3. Initialize category data directories with ExampleConfig.initializeDataDir("category_name").
4. Wrap each example operation with ExampleRunner.run("Operation name", () -> ...).

## File and Data Path Rules

- Use java.nio.file.Path for local file handling.
- Convert to String only where Aspose APIs require it.
- Keep sample-data category names aligned with code intent:
  - examples/documentation/sample-data/<category>/input
  - examples/documentation/sample-data/<category>/output

## Resource Safety

- Always close com.aspose.pdf.Document instances.
- Prefer try-with-resources where possible; otherwise use try/finally.

## Agent Guardrails

- Keep examples small and runnable as standalone methods.
- Do not add new frameworks or dependencies unless the task explicitly requires it.
- Preserve existing console output style used by ExampleRunner.
- If adding a new category runner, ensure examples/documentation/tools/run-all-examples scripts are updated when appropriate.

## References

- [AGENTS.md](../../AGENTS.md)
- [ExampleConfig.java](../../examples/documentation/src/main/java/com/aspose/pdf/examples/ExampleConfig.java)
- [ExampleRunner.java](../../examples/documentation/src/main/java/com/aspose/pdf/examples/ExampleRunner.java)
