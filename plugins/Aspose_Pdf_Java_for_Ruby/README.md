# Aspose PDF Java for Ruby

Aspose.PDF Java for Ruby is a JRuby gem that demonstrates and provides Aspose.PDF for Java API usage examples from Ruby.

## Installation

Execute following command.

```bash
jruby -S gem install asposepdfjava
```

To download Aspose.PDF for Java API to be used with these examples, please navigate to [Releases Page](https://releases.aspose.com/pdf/java/).

Note: Create a `jars` folder at the root of the gem and copy the downloaded Aspose.PDF for Java component into it. You can also set `jar_dir` in `config/aspose.yml`.

For most complete documentation of the project, check [Aspose.PDF Java for Ruby Docs](https://docs.aspose.com/pdf/java/aspose-pdf-java-for-ruby/)

## Usage

```ruby
require "asposepdfjava"

include Asposepdfjava
include Asposepdfjava::HelloWorld

initialize_aspose_pdf
run
```

Let's understand the above code

* The first line loads the gem.
* The include lines make the shared setup and selected example available.
* `initialize_aspose_pdf` loads the jars from `config/aspose.yml` and applies the license when configured.
* `run` executes the selected example.
