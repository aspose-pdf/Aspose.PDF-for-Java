package com.aspose.pdf.examples.AsposePdfExamples.Utilities;

import java.io.File;

public class Utils {
    public static String getDataDir() {
        File dir = new File(System.getProperty("user.dir"));
        dir = new File(dir, "src");
        dir = new File(dir, "main");
        dir = new File(dir, "resources");
        System.out.println("Using data directory: " + dir.toString());
        return dir.toString() + File.separator;
    }
}
