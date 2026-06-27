module Asposepdfjava
  module GetNumberOfPages
    def run
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'
                
        # Create PDF document
        pdf = Asposepdfjava.java_class('com.aspose.pdf.Document').new(data_dir + 'input1.pdf')
        
        page_count = pdf.getPages().size()

        puts "Page Count:" + page_count.to_s
    end
  end
end
