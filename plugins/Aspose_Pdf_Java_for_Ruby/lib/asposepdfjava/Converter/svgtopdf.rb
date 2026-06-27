module Asposepdfjava
  module SvgToPdf
    def run
    	# The path to the documents directory.
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'

        # Instantiate LoadOption object using SVG load option
        options = Asposepdfjava.java_class('com.aspose.pdf.SvgLoadOptions').new
                
        # Create document object
        pdf = Asposepdfjava.java_class('com.aspose.pdf.Document').new(data_dir + 'example.svg', options)

        # Save the output to XLS format
        pdf.save(data_dir + "SVG.pdf")

        puts "Document has been converted successfully"
    end
  end
end
