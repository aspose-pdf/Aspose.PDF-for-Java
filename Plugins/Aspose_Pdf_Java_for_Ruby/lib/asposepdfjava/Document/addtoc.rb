module Asposepdfjava
  module AddToc
    def initialize()
    	# The path to the documents directory.
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'
        
        # Open a pdf document.
        doc = Rjb::import('com.aspose.pdf.Document').new(data_dir + "input1.pdf")

        # Get access to first page of PDF file
        toc_page = doc.getPages().insert(1)

        # Create object to represent TOC information
        toc_info = Rjb::import('com.aspose.pdf.TocInfo').new
        title = Rjb::import('com.aspose.pdf.TextFragment').new("Table Of Contents")
        title.getTextState().setFontSize(20)
        #title.getTextState().setFontStyle(Rjb::import('com.aspose.pdf.FontStyles.Bold'))

        # Set the title for TOC
        toc_info.setTitle(title)
        toc_page.setTocInfo(toc_info)

        # Create string objects which will be used as TOC elements
        titles = Array["First page", "Second page"]

        i = 0
        while i < 2
            # Create Heading object
            heading2 = Rjb::import('com.aspose.pdf.Heading').new(1)

            segment2 = Rjb::import('com.aspose.pdf.TextSegment').new
            heading2.setTocPage(toc_page)
            heading2.getSegments().add(segment2)

            # Specify the destination page for heading object
            heading2.setDestinationPage(doc.getPages().get_Item(i + 2))

            # Destination page
            heading2.setTop(doc.getPages().get_Item(i + 2).getRect().getHeight())

            # Destination coordinate
            segment2.setText(titles[i])

            # Add heading to page containing TOC
            toc_page.getParagraphs().add(heading2)

            i +=1
        end

        # Save PDF Document
        doc.save(data_dir + "TOC.pdf")

        puts "Added TOC Successfully, please check the output file."
    end
  end
end
