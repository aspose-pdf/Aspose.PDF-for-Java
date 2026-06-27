module Asposepdfjava
  module RemoveMetadata
    def run
    	# The path to the documents directory.
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'
        
        # Open a pdf document.
        doc = Asposepdfjava.java_class('com.aspose.pdf.Document').new(data_dir + "input1.pdf")

        if doc.getMetadata().contains("pdfaid:part")
            doc.getMetadata().removeItem("pdfaid:part")
        end    
        
        if doc.getMetadata().contains("dc:format")
            doc.getMetadata().removeItem("dc:format")
        end

        # save update document with new information
        doc.save(data_dir + "Remove_Metadata.pdf")

        puts "Removed metadata successfully, please check output file."
    end
  end
end
