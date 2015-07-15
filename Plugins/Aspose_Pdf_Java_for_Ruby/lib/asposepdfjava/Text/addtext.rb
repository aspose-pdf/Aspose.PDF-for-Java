module Asposepdfjava
  module AddText
    def initialize()
    	# The path to the documents directory.
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'
                
        # Instantiate Document object
        doc = Rjb::import('com.aspose.pdf.Document').new(data_dir + 'input1.pdf')

        # get particular page
        pdf_page = doc.getPages().get_Item(1)
        
        # create text fragment
        text_fragment = Rjb::import('com.aspose.pdf.TextFragment').new("main text")
        text_fragment.setPosition(Rjb::import('com.aspose.pdf.Position').new(100, 600))

        
        font_repository = Rjb::import('com.aspose.pdf.FontRepository')
        color = Rjb::import('com.aspose.pdf.Color')

        # set text properties
        text_fragment.getTextState().setFont(font_repository.findFont("Verdana"))
        text_fragment.getTextState().setFontSize(14)
        #text_fragment.getTextState().setForegroundColor(color.BLUE)
        #text_fragment.getTextState().setBackgroundColor(color.GRAY)

        # create TextBuilder object
        text_builder = Rjb::import('com.aspose.pdf.TextBuilder').new(pdf_page)
        
        # append the text fragment to the PDF page
        text_builder.appendText(text_fragment)
        
        # Save PDF file
        doc.save(data_dir + "Text_Added.pdf")

        puts "Text added successfully"
    end
  end
end
