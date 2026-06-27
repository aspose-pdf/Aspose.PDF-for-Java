# Repository Guidelines

## Project Structure & Module Organization

This repository is a Ruby gem that exposes Aspose.PDF for Java examples through RJB.

- `lib/asposepdfjava.rb` is the main entry point and loads RJB, configuration, and feature modules.
- `lib/asposepdfjava/` contains grouped modules such as `Document`, `Pages`, `Text`, and `Converter`.
- `samples/` contains runnable usage examples; `samples/test.rb` is the current smoke sample.
- `data/` stores sample PDFs, HTML, and SVG inputs used by examples.
- `jars/` contains the Aspose.PDF Java jar, javadocs, schemas, and license/readme artifacts.
- `config/aspose.yml` defines local jar, license, and JVM settings.

## Build, Test, and Development Commands

- `bundle install` installs gem dependencies from `Gemfile` and `asposepdfjava.gemspec`.
- `bundle exec rake build` builds the gem package using Bundler gem tasks.
- `bundle exec rake install` builds and installs the gem locally.
- `ruby samples/test.rb` runs the current smoke example from the `samples` directory.
- `bundle exec rspec` runs specs once a `spec/` directory is added.

Run commands from the repository root unless a sample uses relative paths that require its own directory.

## Coding Style & Naming Conventions

Use Ruby style consistent with the existing code: two-space indentation, `snake_case` method names, and module names under `Asposepdfjava`. Keep feature files grouped by domain, for example `lib/asposepdfjava/Pages/getpage.rb` or `lib/asposepdfjava/Text/addtext.rb`. Prefer `require_relative` for internal files. Keep Java class imports close to the methods that use them, and avoid changing public module names without updating samples.

## Testing Guidelines

RSpec is declared as a development dependency, but no test suite is currently present. Add new tests under `spec/`, using names like `spec/asposepdfjava/document_spec.rb`. For behavior that requires Aspose jars or a license, include a small fixture in `data/` and document any required `config/aspose.yml` setting. At minimum, run `bundle exec rspec` and a relevant sample before opening a pull request.

## Commit & Pull Request Guidelines

The current history only contains `Initial commit`, so use clear imperative commit messages such as `Add page extraction sample` or `Fix license loading path`. Pull requests should include a short description, affected modules or samples, commands run, and any required Aspose jar/license configuration. Link related issues when available, and include output snippets for sample or smoke-test changes.

## Security & Configuration Tips

Do not commit private Aspose license files or machine-specific absolute paths. Keep local paths in `config/aspose.yml`, and prefer documenting required setup over embedding credentials or license material in source files.
