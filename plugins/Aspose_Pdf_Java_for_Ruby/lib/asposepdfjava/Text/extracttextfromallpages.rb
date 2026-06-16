module Asposepdfjava
  module ExtractTextFromAllPages
    def initialize()
    	# The path to the documents directory.
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'
                
        # Open the target document
        pdf = Rjb::import('com.aspose.pdf.Document').new(data_dir + 'input1.pdf')

        # create TextAbsorber object to extract text
        text_absorber = Rjb::import('com.aspose.pdf.TextAbsorber').new
        
        # accept the absorber for all the pages
        pdf.getPages().accept(text_absorber)
        
        # In order to extract text from specific page of document, we need to specify the particular page using its index against accept(..) method.
        # accept the absorber for particular PDF page
        # pdfDocument.getPages().get_Item(1).accept(textAbsorber);
        
        #get the extracted text
        extracted_text = text_absorber.getText()

        # create a writer and open the file
        writer = Rjb::import('java.io.FileWriter').new(Rjb::import('java.io.File').new(data_dir + "extracted_text.out.txt"))
        writer.write(extracted_text)
        # write a line of text to the file
        # tw.WriteLine(extractedText);
        # close the stream
        writer.close()
        
        puts "Text extracted successfully. Check output file."
    end
  end
end
