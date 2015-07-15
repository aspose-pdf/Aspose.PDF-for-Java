# Aspose_Pdf_Java_for_Ruby
Aspose.Pdf Java for Ruby is a gem that demonstrates / provides the Aspose.Pdf for Java API usage examples in Ruby by using Rjb - Ruby Java Bridge.

## Installation

Execute following command.

    $ gem install asposepdfjava

To download Aspose.Pdf for Java API to be used with these examples through RJB, Please navigate to:

http://www.aspose.com/community/files/72/java-components/aspose.pdf-for-java/

Note: Create jars folder at root of the gem and copy downloaded Aspose.Pdf for java component into it.

For most complete documentation of the project, check Aspose.Pdf Java for Ruby confluence wiki link:

http://www.aspose.com/docs/display/pdfjava/2.+Aspose.Pdf+Java+For+Ruby

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