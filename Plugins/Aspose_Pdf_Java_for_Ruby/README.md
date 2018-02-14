# Aspose_PDF_Java_for_Ruby
Aspose.PDF Java for Ruby is a gem that demonstrates / provides the Aspose.PDF for Java API usage examples in Ruby by using Rjb - Ruby Java Bridge.

## Installation

Execute following command.

    $ gem install asposepdfjava

To download Aspose.PDF for Java API to be used with these examples through RJB, Please navigate to:

http://maven.aspose.com/artifactory/simple/ext-release-local/com/aspose/aspose-pdf/

Note: Create jars folder at root of the gem and copy downloaded Aspose.PDF for java component into it.

For most complete documentation of the project, check Aspose.PDF Java for Ruby confluence wiki link:

https://docs.aspose.com/display/pdfjava/Aspose.Pdf+Java+for+Ruby

## Usage

```ruby
require File.dirname(File.dirname(File.dirname(__FILE__))) + '/lib/asposepdfjava'
include Asposepdfjava
include Asposepdfjava::HelloWorld
initialize_aspose_pdf
```
Lets understand the above code
* The first line makes sure that the aspose pdf is loaded and available 
* Include the files that are required to access the aspose pdf
* Initialize the libraries. The aspose JAVA classes are loaded from the path provided in the aspose.yml file
