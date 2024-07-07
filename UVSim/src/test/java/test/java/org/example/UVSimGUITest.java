package test.java.org.example;

import org.assertj.swing.annotation.GUITest;
import org.assertj.swing.core.matcher.JButtonMatcher;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.example.presentation.UVSimGUI;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for the UVSimGUI class.
 * @author Damon Morgan
 */
class UVSimGUITest {

    private FrameFixture window;

    @BeforeEach
    public void setUp() {
        UVSimGUI frame = GuiActionRunner.execute(() -> new UVSimGUI());
        window = new FrameFixture(frame);
        window.show(); // Shows the frame to test
    }

    @AfterEach
    public void tearDown() {
        window.cleanUp();
    }

    @Test
    @GUITest
    public void testLoadProgramButton() {
        window.button(JButtonMatcher.withText("Load Program")).click();
    }

    @Test
    @GUITest
    public void testFileChooserWindowApprove() {
        window.button(JButtonMatcher.withText("Load Program")).click();
        window.fileChooser().approve();
    }

    @Test
    @GUITest
    public void testRunProgramButton() {
        window.button(JButtonMatcher.withText("Run Program")).click();
        window.textBox("outputArea").requireText("Program executed.\n");
    }

    @Test
    @GUITest
    public void testResetProgramButton() {
        window.button(JButtonMatcher.withText("Reset Program")).click();
        window.textBox("outputArea").requireText("Program reset.\n");
    }

    @Test
    public void testGetInputField() {
        String input = JOptionPane.showInputDialog("Please enter a four-digit instruction:");
        assertNotNull(input);
        assertTrue(input.matches("^[-]?\\d{4}$"));
    }
}