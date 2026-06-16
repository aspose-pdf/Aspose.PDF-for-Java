module Asposepdfjava
  module AddHtml
    def initialize()
    	# The path to the documents directory.
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'
                
        # Instantiate Document object
        doc = Rjb::import('com.aspose.pdf.Document').new

        # Add a page to pages collection of PDF file
        page = doc.getPages().add()
        
        # Instantiate HtmlFragment with HTML contents
        title = Rjb::import('com.aspose.pdf.HtmlFragment').new("<fontsize=10><b><i>Table</i></b></fontsize>")
        
        # set MarginInfo for margin details
        margin = Rjb::import('com.aspose.pdf.MarginInfo').new
        margin.setBottom(10)
        margin.setTop(200)
        
        # Set margin information
        title.setMargin(margin)
        
        # Add HTML Fragment to paragraphs collection of page
        page.getParagraphs().add(title)
        
        # Save PDF file
        doc.save(data_dir + "html.output.pdf")

        puts "HTML added successfully"
    end
  end
end
