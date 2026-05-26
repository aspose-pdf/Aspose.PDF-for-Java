package com.aspose.pdf.examples;

public final class ExampleRunner {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";

    private ExampleRunner() {
    }

    public static void run(String exampleName, ExampleAction action) {
        try {
            action.run();
            logSuccess(exampleName);
        } catch (Exception ex) {
            logFailure(exampleName, ex);
        }
    }

    private static void logSuccess(String exampleName) {
        String message = "Success: " + exampleName;
        System.out.println(useAnsiColors() ? ANSI_GREEN + message + ANSI_RESET : message);
    }

    private static void logFailure(String exampleName, Exception ex) {
        String message = "Failed: " + exampleName + " - " + ex.getMessage();
        System.out.println(useAnsiColors() ? ANSI_RED + message + ANSI_RESET : message);
    }

    private static boolean useAnsiColors() {
        String noColor = System.getenv("NO_COLOR");
        if (noColor != null && !noColor.isBlank()) {
            return false;
        }

        String forceColor = System.getenv("FORCE_COLOR");
        if (forceColor != null && !forceColor.isBlank() && !"0".equals(forceColor)) {
            return true;
        }

        String term = System.getenv("TERM");
        if (term != null && "dumb".equalsIgnoreCase(term.trim())) {
            return false;
        }

        String ci = System.getenv("CI");
        if (ci != null && !ci.isBlank()) {
            return false;
        }

        return true;
    }

    @FunctionalInterface
    public interface ExampleAction {
        void run() throws Exception;
    }
}
