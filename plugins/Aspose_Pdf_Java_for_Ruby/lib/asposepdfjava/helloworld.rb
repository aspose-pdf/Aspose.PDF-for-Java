module Asposepdfjava
  module HelloWorld
    def run
        data_dir = File.dirname(File.dirname(File.dirname(__FILE__))) + '/data/'
                
        # Create PDF document
        doc = Asposepdfjava.java_class('com.aspose.pdf.Document').new
        
        # Add a page into the PDF document
        page = doc.getPages().add()
        
        # Add a text paragraph into the section
        page.getParagraphs().add(Asposepdfjava.java_class('com.aspose.pdf.TextFragment').new("Hello World"))

        # Save the document
        doc.save(data_dir + "HelloWorld.pdf")

        puts "Document has been saved, please check the output file."
    end
  end
end
