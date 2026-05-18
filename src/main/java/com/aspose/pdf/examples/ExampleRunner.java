package com.aspose.pdf.examples;

public final class ExampleRunner {
    private ExampleRunner() {
    }

    public static void run(String exampleName, ExampleAction action) {
        try {
            action.run();
            System.out.println("Success: " + exampleName);
        } catch (Exception ex) {
            System.out.println("Failed: " + exampleName + " - " + ex.getMessage());
        }
    }

    @FunctionalInterface
    public interface ExampleAction {
        void run() throws Exception;
    }
}
