package com.aspose.pdf.examples.AsposePdfExamples.QuickStart;

public class ApplyMeteredLicense {
	String publicKey = "";
	String privateKey = "";

	Metered m = new Metered();
	m.setMeteredKey(publicKey, privateKey);

	// Optionally, the following two lines returns true if a valid license has been applied;
	// false if the component is running in evaluation mode.
	License lic = new License();
	System.out.println("License is set = " + lic.isLicensed());
}
