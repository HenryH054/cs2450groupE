//package org.example;
//
//import org.assertj.swing.annotation.GUITest;
//import org.assertj.swing.core.matcher.JButtonMatcher;
//import org.assertj.swing.edt.GuiActionRunner;
//import org.assertj.swing.fixture.FrameFixture;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.example.presentation.UVSimGUI;
//
//import javax.swing.*;
//
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
///**
// * Tests for the UVSimGUI class.
// * @author Damon Morgan
// */
//class UVSimGUITest {
//
//    private FrameFixture window;
//
//    @BeforeEach
//    public void setUp() {
//        UVSimGUI frame = GuiActionRunner.execute(() -> new UVSimGUI());
//        window = new FrameFixture(frame);
//        window.show(); // Shows the frame to test
//    }
//
//    @AfterEach
//    public void tearDown() {
//        window.cleanUp();
//    }
//
//    @Test
//    @GUITest
//    public void testLoadProgramButton() {
//        window.button(JButtonMatcher.withText("Load Program")).click();
//    }
//
//    @Test
//    @GUITest
//    public void testFileChooserWindowApprove() {
//        window.button(JButtonMatcher.withText("Load Program")).click();
//        window.fileChooser().approve();
//        assertThat(window.textBox("outputArea").text()).contains("Loading Program...");
//    }
//
//    @Test
//    @GUITest
//    public void testRunProgramButton() {
//        window.button(JButtonMatcher.withText("Run Program")).click();
//        assertThat(window.textBox("outputArea").text()).contains("Program executed");
//    }
//
//    @Test
//    @GUITest
//    public void testResetProgramButton() {
//        window.button(JButtonMatcher.withText("Reset Program")).click();
//        assertThat(window.textBox("outputArea").text()).contains("Program reset");
//    }
//
//    @Test
//    public void testGetInputField() {
//        String input = JOptionPane.showInputDialog("Please enter a four-digit instruction:");
//        assertNotNull(input);
//        assertTrue(input.matches("^[-]?\\d{4}$"));
//    }
//}