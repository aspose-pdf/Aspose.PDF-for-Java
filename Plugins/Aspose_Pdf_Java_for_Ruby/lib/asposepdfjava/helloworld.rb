module Asposepdfjava
  module HelloWorld
    def initialize()
        data_dir = File.dirname(File.dirname(File.dirname(__FILE__))) + '/data/'
                
        # Create PDF document
        pdf = Rjb::import('aspose.pdf.Pdf').new
        
        # Add a section into the PDF document
        section = pdf.getSections().add()
        
        # Add a text paragraph into the section
        section.getParagraphs().add(Rjb::import('aspose.pdf.Text').new("Hello World"))

        # Save the document
        pdf.save(data_dir + "HelloWorld.pdf")

        puts "Document has been saved, please check the output file."
    end
  end
end
