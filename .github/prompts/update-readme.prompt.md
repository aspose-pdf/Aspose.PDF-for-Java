---
description: "Audit and update README.md for technical accuracy and command consistency with this repository. Use when asked to refresh, fix, or modernize README content."
name: "Update README"
argument-hint: "Scope of changes, for example: Java version section, quick-start commands, or links"
agent: "agent"
---
Update [README.md](../../README.md) with the requested scope while keeping the document aligned with repository truth.

Tasks:
1. Read and compare:
   - [README.md](../../README.md)
   - [pom.xml](../../pom.xml)
   - [examples/documentation/pom.xml](../../examples/documentation/pom.xml)
   - [AGENTS.md](../../AGENTS.md)
   - [examples/documentation/tools/run-all-examples.ps1](../../examples/documentation/tools/run-all-examples.ps1)
   - [examples/documentation/tools/run-all-examples.sh](../../examples/documentation/tools/run-all-examples.sh)
2. Correct outdated technical claims (versions, commands, paths) to match current files.
3. Preserve existing README structure and product messaging unless the prompt explicitly asks for restructuring.
4. Prefer links to canonical docs over long embedded explanations.
5. Keep edits focused to the requested scope and avoid unrelated rewrites.

Output:
- Summary of what changed
- Any assumptions made
- Follow-up items that need repository maintainer confirmation
