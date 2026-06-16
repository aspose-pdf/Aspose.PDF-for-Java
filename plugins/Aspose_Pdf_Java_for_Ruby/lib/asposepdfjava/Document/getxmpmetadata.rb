module Asposepdfjava
  module GetXMPMetadata
    def initialize()
    	# The path to the documents directory.
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'
        
        # Open a pdf document.
        doc = Rjb::import('com.aspose.pdf.Document').new(data_dir + "input1.pdf")

        # Get properties
        puts "xmp:CreateDate: " + doc.getMetadata().get_Item("xmp:CreateDate").to_s
        puts "xmp:Nickname: " + doc.getMetadata().get_Item("xmp:Nickname").to_s
        puts "xmp:CustomProperty: " + doc.getMetadata().get_Item("xmp:CustomProperty").to_s
    end
  end
end
