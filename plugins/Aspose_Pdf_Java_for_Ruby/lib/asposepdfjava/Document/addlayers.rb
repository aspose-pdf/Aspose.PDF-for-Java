module Asposepdfjava
  module AddLayers
    def run
    	# The path to the documents directory.
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'

        doc = Asposepdfjava.java_class('com.aspose.pdf.Document').new
        page = doc.getPages().add()

        operator = Asposepdfjava.java_class('com.aspose.pdf.Operator')

        layer = Asposepdfjava.java_class('com.aspose.pdf.Layer').new("oc1", "Red Line")
        layer.getContents().add(operator.SetRGBColorStroke(1, 0, 0))
        layer.getContents().add(operator.MoveTo(500, 700))
        layer.getContents().add(operator.LineTo(400, 700))
        layer.getContents().add(operator.Stroke())
        page.setLayers(Asposepdfjava.java_class('java.util.ArrayList').new)
        page.getLayers().add(layer)
        
        layer = Asposepdfjava.java_class('com.aspose.pdf.Layer').new("oc2", "Green Line")
        layer.getContents().add(operator.SetRGBColorStroke(0, 1, 0))
        layer.getContents().add(operator.MoveTo(500, 750))
        layer.getContents().add(operator.LineTo(400, 750))
        layer.getContents().add(operator.Stroke())
        page.getLayers().add(layer)
        
        layer = Asposepdfjava.java_class('com.aspose.pdf.Layer').new("oc3", "Blue Line")
        layer.getContents().add(operator.SetRGBColorStroke(0, 0, 1))
        layer.getContents().add(operator.MoveTo(500, 800))
        layer.getContents().add(operator.LineTo(400, 800))
        layer.getContents().add(operator.Stroke())
        page.getLayers().add(layer)

        # Save PDF Document
        doc.save(data_dir + "Layers-Added.pdf")

        puts "Added Layers Successfully, please check the output file."
    end
  end
end
