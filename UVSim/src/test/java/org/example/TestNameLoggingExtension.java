package org.example;

import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import java.util.Optional;
import org.junit.jupiter.api.extension.TestWatcher;

public class TestNameLoggingExtension implements BeforeEachCallback, TestWatcher {

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        System.out.println("Starting test method: " + context.getDisplayName());
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        System.out.println("Test case disabled: " + context.getDisplayName());
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        System.out.println("Test case passed: " + context.getDisplayName());
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        System.out.println("Test case aborted: " + context.getDisplayName());
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        System.out.println("Test case failed: " + context.getDisplayName());
    }
}
