package com.aspose.pdf.examples.navigationandinteraction;

import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.navigationandinteraction.bookmarks.AddExamples;
import com.aspose.pdf.examples.navigationandinteraction.bookmarks.GetExamples;
import com.aspose.pdf.examples.navigationandinteraction.links.CreateExamples;
import com.aspose.pdf.examples.navigationandinteraction.links.ExtractExamples;
import com.aspose.pdf.examples.navigationandinteraction.links.UpdateExamples;

public final class NavigationAndInteractionExamples {
    private NavigationAndInteractionExamples() {
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ActionsExamples.runAllExamples(licensePath);
        AddExamples.runAllExamples(licensePath);
        GetExamples.runAllExamples(licensePath);
        CreateExamples.runAllExamples(licensePath);
        ExtractExamples.runAllExamples(licensePath);
        UpdateExamples.runAllExamples(licensePath);
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
