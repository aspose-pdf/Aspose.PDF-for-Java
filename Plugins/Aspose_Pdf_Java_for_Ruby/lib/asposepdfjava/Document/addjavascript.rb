module Asposepdfjava
  module AddJavaScript
    def initialize()
    	# The path to the documents directory.
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'
        
        # Open a pdf document.
        doc = Rjb::import('com.aspose.pdf.Document').new(data_dir + "input1.pdf")

        # Adding JavaScript at Document Level
        # Instantiate JavascriptAction with desried JavaScript statement
        javaScript = Rjb::import('com.aspose.pdf.JavascriptAction').new("this.print({bUI:true,bSilent:false,bShrinkToFit:true});");

        # Assign JavascriptAction object to desired action of Document
        doc.setOpenAction(javaScript)

        # Adding JavaScript at Page Level
        doc.getPages().get_Item(2).getActions().setOnOpen(Rjb::import('com.aspose.pdf.JavascriptAction').new("app.alert('page 2 is opened')"))
        doc.getPages().get_Item(2).getActions().setOnClose(Rjb::import('com.aspose.pdf.JavascriptAction').new("app.alert('page 2 is closed')"))

        # Save PDF Document
        doc.save(data_dir + "JavaScript-Added.pdf")

        puts "Added JavaScript Successfully, please check the output file."
    end
  end
end
