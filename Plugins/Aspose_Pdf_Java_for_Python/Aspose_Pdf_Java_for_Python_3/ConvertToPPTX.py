# Import module
import string

import jpype.imports


# Launch the JVM with adding aspose.pdf-22.5.jar in classpath
jpype.startJVM(classpath=['jars/aspose.pdf-22.5.jar'])

# import the Java modules
from com.aspose.pdf import Document
from com.aspose.pdf import BuildVersionInfo
from com.aspose.pdf import PptxSaveOptions

name = "converters/pdftopptx/input"
inputPath = "testdata/" + name + ".pdf"
doc = Document(inputPath)
options = PptxSaveOptions()
output = "testout/" + name + str(BuildVersionInfo.FileVersion) + ".pptx"
doc.save(output, options)

print('Document has been converted in: ' + output)
