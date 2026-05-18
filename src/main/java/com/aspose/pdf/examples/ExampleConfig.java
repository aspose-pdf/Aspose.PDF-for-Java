package com.aspose.pdf.examples;

import com.aspose.pdf.License;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class ExampleConfig {
    private static final String LICENSE_PROPERTY = "aspose.pdf.license";
    private static final String LICENSE_ENVIRONMENT_VARIABLE = "ASPOSE_PDF_LICENSE";

    private ExampleConfig() {
    }

    public static ExampleDataDirs initializeDataDir(String categoryPath) throws Exception {
        Path dataDir = projectRoot().resolve("sample-data").resolve(categoryPath);
        Path inputDir = dataDir.resolve("input");
        Path outputDir = dataDir.resolve("output");

        Files.createDirectories(inputDir);
        Files.createDirectories(outputDir);

        return new ExampleDataDirs(inputDir, outputDir);
    }

    public static void setLicense(String licensePath) throws Exception {
        if (licensePath == null || licensePath.isBlank()) {
            return;
        }

        Path path = Paths.get(licensePath).toAbsolutePath().normalize();
        if (!Files.exists(path)) {
            throw new IllegalArgumentException("License file not found: " + path);
        }

        License license = new License();
        license.setLicense(path.toString());
    }

    public static void setLicenseFromRuntime() throws Exception {
        setLicense(resolveLicensePath());
    }

    public static String resolveLicensePath(String[] args) {
        if (args != null && args.length > 0) {
            for (String arg : args) {
                if (arg != null && arg.startsWith("--license=")) {
                    return arg.substring("--license=".length());
                }
            }
            return args[0];
        }

        return resolveLicensePath();
    }

    private static String resolveLicensePath() {
        String licensePath = System.getProperty(LICENSE_PROPERTY);
        if (licensePath == null || licensePath.isBlank()) {
            licensePath = System.getenv(LICENSE_ENVIRONMENT_VARIABLE);
        }
        return licensePath;
    }

    private static Path projectRoot() {
        return Paths.get("").toAbsolutePath().normalize();
    }
}
