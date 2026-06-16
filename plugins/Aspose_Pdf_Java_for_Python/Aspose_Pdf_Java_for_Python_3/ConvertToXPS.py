# Import module
import string

import jpype.imports


# Launch the JVM with adding aspose.pdf-22.5.jar in classpath
jpype.startJVM(classpath=['jars/aspose.pdf-22.5.jar'])

# import the Java modules
from com.aspose.pdf import Document
from com.aspose.pdf import BuildVersionInfo
from com.aspose.pdf import XpsSaveOptions
# from com.aspose.pdf import License
#
# licenseInstance = License()
# licenseInstance.setLicense("testdata/License/Aspose.PDF.Java.lic")

name = "converters/pdftoxps/input"
inputPath = "testdata/" + name + ".pdf"
doc = Document(inputPath)
options = XpsSaveOptions()
options.setSaveTransparentTexts(True)
output = "testout/" + name + str(BuildVersionInfo.FileVersion) + "_lic.xps"
doc.save(output, options)

print('Document has been converted in: ' + output)
