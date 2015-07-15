module Asposepdfjava
  module GetPdfFileInfo
    def initialize()
    	# The path to the documents directory.
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'
        
        # Open a pdf document.
        doc = Rjb::import('com.aspose.pdf.Document').new(data_dir + "input1.pdf")

        # Get document information
        doc_info = doc.getInfo()
        
        # Show document information
        puts "Author:-" + doc_info.getAuthor().to_s
        puts "Creation Date:-" + doc_info.getCreationDate().to_string
        puts "Keywords:-" + doc_info.getKeywords().to_s
        puts "Modify Date:-" + doc_info.getModDate().to_string
        puts "Subject:-" + doc_info.getSubject().to_s
        puts "Title:-" + doc_info.getTitle().to_s
    end
  end
end
