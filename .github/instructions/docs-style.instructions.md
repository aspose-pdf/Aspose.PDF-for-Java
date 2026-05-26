---
description: "Use when editing Markdown documentation to keep structure, tone, and links consistent across project docs."
name: "Docs Markdown Style"
applyTo: "{README.md,docs/**/*.md}"
---
# Docs Markdown Style

## Scope and Priority

- Treat this as a cross-doc style baseline.
- When editing [README.md](../../README.md), also follow [readme-maintenance.instructions.md](./readme-maintenance.instructions.md) for technical accuracy.

## Structure

- Keep heading hierarchy sequential (`##` after `#`, avoid skipping levels).
- Prefer short, scannable sections with clear titles.
- Use tables only when they improve comparison; otherwise prefer bullet lists.

## Writing Style

- Keep language concise, factual, and task-oriented.
- Avoid marketing-heavy rewrites unless explicitly requested.
- Preserve existing terminology for product, package, and feature names.

## Links and Examples

- Prefer repository-relative links for local files and stable canonical links for external docs.
- Keep code snippets short and directly relevant to the section.
- When possible, point to runnable examples in `src/main/java/com/aspose/pdf/examples` instead of embedding long snippets.

## Safe Editing Boundaries

- Avoid broad formatting-only rewrites that hide meaningful diffs.
- Keep changes scoped to the requested doc area.
- Do not change support or legal links unless explicitly requested.
