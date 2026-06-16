module Asposepdfjava
  module GetNumberOfPages
    def initialize()
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'
                
        # Create PDF document
        pdf = Rjb::import('com.aspose.pdf.Document').new(data_dir + 'input1.pdf')
        
        page_count = pdf.getPages().size()

        puts "Page Count:" + page_count.to_s
    end
  end
end
