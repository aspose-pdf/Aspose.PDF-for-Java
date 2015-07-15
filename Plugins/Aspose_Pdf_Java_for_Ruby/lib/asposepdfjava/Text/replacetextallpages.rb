module Asposepdfjava
  module ReplaceTextAllPages
    def initialize()
    	# The path to the documents directory.
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'
                
        # Open the target document
        pdf_document = Rjb::import('com.aspose.pdf.Document').new(data_dir + 'input.pdf')

        # Create TextAbsorber object to find all instances of the input search phrase
        text_fragment_absorber = Rjb::import('com.aspose.pdf.TextFragmentAbsorber').new("sample")

        # Accept the absorber for first page of document
        pdf_document.getPages().accept(text_fragment_absorber)

        # Get the extracted text fragments into collection
        text_fragment_collection = text_fragment_absorber.getTextFragments()
        
        color = Rjb::import('com.aspose.pdf.Color')
        font_repository = Rjb::import('com.aspose.pdf.FontRepository')
        text_fragment = Rjb::import('com.aspose.pdf.TextFragment')
        
        # Loop through the fragments
        #for(text_fragment : (Iterable<com.aspose.pdf.TextFragment>)textFragmentCollection)
        i = 0
        while i < text_fragment_collection
            # Update text and other properties
            text_fragment.setText("New Phrase")
            text_fragment.getTextState().setFont(font_repository.findFont("Verdana"))
            text_fragment.getTextState().setFontSize(22)
            text_fragment.getTextState().setForegroundColor(color.getBlue())
            text_fragment.getTextState().setBackgroundColor(color.getGray())
            i +=1
        end
        # Save the updated PDF file
        pdfDocument.save(data_dir+ "ReplaceTextAllPages.pdf")
    end
  end
end
