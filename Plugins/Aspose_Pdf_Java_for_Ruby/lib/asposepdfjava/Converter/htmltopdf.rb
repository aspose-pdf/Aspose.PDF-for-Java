module Asposepdfjava
  module HtmlToPdf
    def initialize()
    	# The path to the documents directory.
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'

        htmloptions = Rjb::import('com.aspose.pdf.HtmlLoadOptions').new(data_dir)
        
        # Load HTML file
        pdf = Rjb::import('com.aspose.pdf.Document').new(data_dir + "index.html", htmloptions)

        # Save the concatenated output file (the target document)
        pdf.save(data_dir+ "html.pdf")

        puts "Document has been converted successfully"
    end
  end
end
