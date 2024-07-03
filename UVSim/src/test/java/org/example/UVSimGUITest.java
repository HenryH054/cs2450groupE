package org.example;

import org.assertj.swing.annotation.GUITest;
import org.assertj.swing.core.matcher.JButtonMatcher;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.example.presentation.UVSimGUI;
import static org.assertj.swing.assertions.Assertions.assertThat;


/**
 * Unit tests for the UVSimGUI class.
 * @author Damon Morgan
 */
class UVSimGUITest {

    private FrameFixture window;

    @BeforeEach
    public void setUp() {
        UVSimGUI frame = GuiActionRunner.execute(UVSimGUI::new);
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
        window.fileChooser().click();
        assertThat(window.textBox("outputArea").text()).contains("Loading Program...");
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
        assertThat(window.textBox("outputArea").text()).contains("Program executed.");
    }

    @Test
    @GUITest
    public void testResetProgramButton() {
        window.button(JButtonMatcher.withText("Reset Program")).click();
        assertThat(window.textBox("outputArea").text()).contains("Program reset.");
    }
}