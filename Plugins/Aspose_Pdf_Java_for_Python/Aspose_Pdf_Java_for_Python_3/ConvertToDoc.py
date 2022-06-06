# Import module
import string

import jpype.imports


# Launch the JVM with adding aspose.pdf-22.5.jar in classpath
jpype.startJVM(classpath=['jars/aspose.pdf-22.5.jar'])

# import the Java modules
from com.aspose.pdf import Document
from com.aspose.pdf import BuildVersionInfo
from com.aspose.pdf import SaveFormat

name = "converters/pdftodoc/input"
inputPath = "testdata/" + name + ".pdf"
doc = Document(inputPath)
output = "testout/" + name + str(BuildVersionInfo.FileVersion) + ".doc"
doc.save(output, SaveFormat.Doc)

print('Document has been converted in: ' + output)
