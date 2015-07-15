module Asposepdfjava
  module SetPdfFileInfo
    def initialize()
    	# The path to the documents directory.
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'
        
        # Open a pdf document.
        doc = Rjb::import('com.aspose.pdf.Document').new(data_dir + "input1.pdf")

        # Get document information
        doc_info = doc.getInfo()
        
        doc_info.setAuthor("Aspose.Pdf for java")
        doc_info.setCreationDate(Rjb::import('java.util.Date').new)
        doc_info.setKeywords("Aspose.Pdf, DOM, API")
        doc_info.setModDate(Rjb::import('java.util.Date').new)
        doc_info.setSubject("PDF Information")
        doc_info.setTitle("Setting PDF Document Information")
        
        # save update document with new information
        doc.save(data_dir + "Updated_Information.pdf")

        puts "Update document information, please check output file."
    end
  end
end
