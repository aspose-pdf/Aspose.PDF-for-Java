module Asposepdfjava
  module PdfToExcel
    def initialize()
    	# The path to the documents directory.
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'
                
        # Open the target document
        pdf = Rjb::import('com.aspose.pdf.Document').new(data_dir + 'input1.pdf')

        # Instantiate ExcelSave Option object
        excelsave = Rjb::import('com.aspose.pdf.ExcelSaveOptions').new

        # Save the output to XLS format
        pdf.save(data_dir + "Converted_Excel.xls", excelsave)

        puts "Document has been converted successfully"
    end
  end
end
