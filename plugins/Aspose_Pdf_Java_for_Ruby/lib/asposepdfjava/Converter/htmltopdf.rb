module Asposepdfjava
  module HtmlToPdf
    def run
    	# The path to the documents directory.
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'

        htmloptions = Asposepdfjava.java_class('com.aspose.pdf.HtmlLoadOptions').new(data_dir)
        
        # Load HTML file
        pdf = Asposepdfjava.java_class('com.aspose.pdf.Document').new(data_dir + "index.html", htmloptions)

        # Save the concatenated output file (the target document)
        pdf.save(data_dir+ "html.pdf")

        puts "Document has been converted successfully"
    end
  end
end
