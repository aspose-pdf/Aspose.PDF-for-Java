module Asposepdfjava
  module Optimize
    def initialize()
    	# Optimize document for the web
        #optimize_web()

        # Optimize document for the web
        optimize_filesize()
    end

    def optimize_web()
        # The path to the documents directory.
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'
        
        # Open a pdf document.
        doc = Rjb::import('com.aspose.pdf.Document').new(data_dir + "input1.pdf")

        # Optimize for web
        doc.optimize()
        
        #Save output document
        doc.save(data_dir + "Optimized_Web.pdf")

        puts "Optimized PDF for the Web, please check output file."
    end    

    def optimize_filesize()
        # The path to the documents directory.
        data_dir = File.dirname(File.dirname(File.dirname(File.dirname(__FILE__)))) + '/data/'
        
        # Open a pdf document.
        doc = Rjb::import('com.aspose.pdf.Document').new(data_dir + "input1.pdf")

        # Optimize the file size by removing unused objects
        opt = Rjb::import('aspose.document.OptimizationOptions').new
        opt.setRemoveUnusedObjects(true)
        opt.setRemoveUnusedStreams(true)
        opt.setLinkDuplcateStreams(true)
        doc.optimizeResources(opt)
        
        # Save output document
        doc.save(data_dir + "Optimized_Filesize.pdf")

        puts "Optimized PDF Filesize, please check output file."
    end  
  end
end
