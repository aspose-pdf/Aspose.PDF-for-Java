---
description: "Use when editing the repository README to keep technical claims and quick-start guidance aligned with the codebase."
name: "README Maintenance Conventions"
applyTo: "README.md"
---
# README Maintenance Conventions

## Accuracy First

- Verify version statements against [pom.xml](../../pom.xml) before updating text.
- Prefer repository-truth commands (`mvn clean compile`, runner commands, and scripts in [examples/documentation/tools](../../examples/documentation/tools)).
- If a statement conflicts with source-of-truth files, update the README to match code and build configuration.

## Keep Documentation Lean

- Link to canonical references instead of duplicating long instructions:
  - [Aspose.PDF Java Docs](https://docs.aspose.com/pdf/java/)
  - [API Reference](https://apireference.aspose.com/pdf/java)
  - [AGENTS.md](../../AGENTS.md)
- Keep examples concise and representative; avoid large code blocks unless requested.

## Consistency Rules

- Keep naming and paths consistent with repository layout (for example `examples/documentation/src/main/java/com/aspose/pdf/examples` and `examples/documentation/sample-data`).
- Preserve existing support/product links unless the task explicitly asks for link changes.
- Use Markdown tables and headings with the existing README style; avoid unrelated formatting rewrites.
