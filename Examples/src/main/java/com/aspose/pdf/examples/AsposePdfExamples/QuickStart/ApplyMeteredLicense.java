package com.aspose.pdf.examples.AsposePdfExamples.QuickStart;

public class ApplyMeteredLicense {
    
    public static void main(String[] args) {
	
    }
    
    @SuppressWarnings("static-access")
	public void Run()
	{
		String publicKey = "";
		String privateKey = "";
	
		com.aspose.pdf.Metered m = new com.aspose.pdf.Metered();
		m.setMeteredKey(publicKey, privateKey);
	
		// Optionally, the following two lines returns true if a valid license has been applied;
		// false if the component is running in evaluation mode.
		com.aspose.pdf.Document lic = new com.aspose.pdf.Document();
		System.out.println("License is set = " + lic.isLicensed());
	}
}
