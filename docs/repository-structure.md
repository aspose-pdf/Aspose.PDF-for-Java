# Repository Structure

This repository separates documentation examples from product-specific plugin integrations.

## Documentation Examples

Use `examples/documentation` for runnable Java examples that are referenced from Aspose.PDF documentation.

- Java code belongs under `examples/documentation/src/main/java/com/aspose/pdf/examples`.
- Sample files belong under `examples/documentation/sample-data/<category>/input`.
- Generated outputs should go under `examples/documentation/sample-data/<category>/output`.
- Register new category runners in both scripts under `examples/documentation/tools`.

## Plugin Integrations

Use `plugins/<plugin-name>` for integrations such as Jython or PHP.

- Keep plugin-specific code, sample data, tools, and README files inside the plugin folder.
- Add a plugin module to the root `pom.xml` only when it is Maven-buildable.
- Do not place plugin examples under `examples/documentation`; those examples serve a different audience and usually have different setup requirements.

## Shared Files

Prefer keeping sample data beside the examples that use it. Add shared folders only when multiple sections truly reuse the same assets or scripts.
