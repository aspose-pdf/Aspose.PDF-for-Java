---
description: "Create a new Aspose.PDF Java example category with package, runner class, operation stubs, sample-data folders, and optional script registration. Use when adding a new feature area."
name: "Add Example Category"
argument-hint: "Category package name + sample-data folder name + operation list"
agent: "agent"
---
Create a new example category in this repository.

Input format:
- category package name: lower-case package segment, for example workingwithforms
- sample-data folder name: snake_case folder, for example working_with_forms
- optional operation names: comma-separated, for example CreateFormExample, FillFormExample
- optional register-runner: yes or no

Tasks:
1. Inspect existing patterns in:
   - [AGENTS.md](../../AGENTS.md)
   - [ExampleConfig.java](../../examples/documentation/src/main/java/com/aspose/pdf/examples/ExampleConfig.java)
   - [ExampleRunner.java](../../examples/documentation/src/main/java/com/aspose/pdf/examples/ExampleRunner.java)
   - [BasicOperationsExamples.java](../../examples/documentation/src/main/java/com/aspose/pdf/examples/basicoperations/BasicOperationsExamples.java)
2. Create package folder under examples/documentation/src/main/java/com/aspose/pdf/examples/<category package name>.
3. Create a category runner class named in PascalCase with Examples suffix.
4. Add operation example classes (if provided), each with:
   - static example methods
   - runAllExamples(String licensePath)
   - main(String[] args)
5. Ensure runner and operation classes use:
   - ExampleConfig.setLicense
   - ExampleConfig.initializeDataDir("<sample-data folder name>")
   - ExampleRunner.run for each operation
6. Create sample-data directories:
   - examples/documentation/sample-data/<sample-data folder name>/input
   - examples/documentation/sample-data/<sample-data folder name>/output
7. If register-runner is yes, add the new runner to examples/documentation/tools scripts that execute all runners.
8. Run a compile check and report any failures.

Output:
- List of created or modified files
- Any assumptions made
- Follow-up actions needed for missing input sample PDFs
