# Import module
import string

import jpype.imports

# Launch the JVM with adding aspose.pdf-22.5.jar in classpath
jpype.startJVM(classpath=['jars/aspose.pdf-22.5.jar'])

# import the Java modules
from com.aspose.pdf import Document
from com.aspose.pdf import License

licenseInstance = License()
licenseInstance.setLicense("testdata/aspose.PDF.Java.lic")
print('Document is licensed? : ' + str(Document.isLicensed()))


