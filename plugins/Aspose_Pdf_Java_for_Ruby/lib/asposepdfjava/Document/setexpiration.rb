module Asposepdfjava
  module SetExpiration
    def initialize()
    	# The path to the documents directory.
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'
        
        # Open a pdf document.
        doc = Rjb::import('com.aspose.pdf.Document').new(data_dir + "input1.pdf")

        javascript = Rjb::import('com.aspose.pdf.JavascriptAction').new(
            "var year=2014;
            var month=4;
            today = new Date();
            today = new Date(today.getFullYear(), today.getMonth());
            expiry = new Date(year, month);
            if (today.getTime() > expiry.getTime())
            app.alert('The file is expired. You need a new one.');")
        doc.setOpenAction(javascript)
        
        # save update document with new information
        doc.save(data_dir + "set_expiration.pdf")

        puts "Update document information, please check output file."
    end
  end
end
