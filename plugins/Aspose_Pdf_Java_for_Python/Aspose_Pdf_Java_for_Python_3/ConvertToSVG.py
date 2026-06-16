# Import module
import string

import jpype.imports


# Launch the JVM with adding aspose.pdf-22.5.jar in classpath
jpype.startJVM(classpath=['jars/aspose.pdf-22.5.jar'])

# import the Java modules
from com.aspose.pdf import Document
from com.aspose.pdf import BuildVersionInfo
from com.aspose.pdf import SvgSaveOptions

name = "converters/pdftosvg/input"
inputPath = "testdata/" + name + ".pdf"
doc = Document(inputPath)
options = SvgSaveOptions()
options.setCompressOutputToZipArchive(False);
output = "testout/" + name + str(BuildVersionInfo.FileVersion) + ".svg"
doc.save(output, options)

print('Document has been converted in: ' + output)
