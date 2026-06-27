module Asposepdfjava
  module ConvertPagesToImages
    def run
    	# The path to the documents directory.
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'
                
        converter = Asposepdfjava.java_class('com.aspose.pdf.facades.PdfConverter').new
        converter.bindPdf(data_dir + 'input1.pdf')
        converter.doConvert()
        suffix = ".jpg"
        image_count = 1
        image_format_internal = Asposepdfjava.java_class('com.aspose.pdf.ImageFormatInternal')
        while converter.hasNextImage()
            converter.getNextImage(data_dir + "image#{image_count}#{suffix}", image_format_internal.getJpeg())
            image_count +=1
        end

        puts "PDF pages are converted to individual images successfully!"
    end
  end
end
