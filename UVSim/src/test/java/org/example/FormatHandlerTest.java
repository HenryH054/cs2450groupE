package org.example;
import org.example.file.FormatHandler;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class FormatHandlerTest {
    @Test
    public void testConvertInstructionsToNewFormat_AllFunctionalCodes() {
        List<Integer> instructions = Arrays.asList(1001, 1102, 2003, 2104, 3005, 3106, 3207, 3308, 4009, 4100, 4201, 4302);
        List<Integer> expected = Arrays.asList(10001, 11002, 20003, 21004, 30005, 31006, 32007, 33008, 40009, 41000, 42001, 43002);

        List<Integer> result = FormatHandler.convertInstructionsToNewFormat(instructions);

        assertEquals(expected, result);
    }

    @Test
    public void testConvertInstructionsToNewFormat_MixedCodes() {
        List<Integer> instructions = Arrays.asList(1001, 50, 1102, 75, 2003);
        List<Integer> expected = Arrays.asList(10001, 50, 11002, 75, 20003);

        List<Integer> result = FormatHandler.convertInstructionsToNewFormat(instructions);

        assertEquals(expected, result);
    }

    @Test
    public void testConvertInstructionsToNewFormat_NoFunctionalCodes() {
        List<Integer> instructions = Arrays.asList(50, 75, 99);
        List<Integer> expected = Arrays.asList(50, 75, 99);

        List<Integer> result = FormatHandler.convertInstructionsToNewFormat(instructions);

        assertEquals(expected, result);
    }

    @Test
    public void testConvertInstructionsToNewFormat_EmptyList() {
        List<Integer> instructions = Arrays.asList();
        List<Integer> expected = Arrays.asList();

        List<Integer> result = FormatHandler.convertInstructionsToNewFormat(instructions);

        assertEquals(expected, result);
    }

    @Test
    public void testIsFunctionalCode() {
        // Functional codes
        assertEquals(true, FormatHandler.isFunctionalCode(1001));
        assertEquals(true, FormatHandler.isFunctionalCode(1102));
        assertEquals(true, FormatHandler.isFunctionalCode(2003));

        // Non-functional codes
        assertEquals(false, FormatHandler.isFunctionalCode(50));
        assertEquals(false, FormatHandler.isFunctionalCode(75));
        assertEquals(false, FormatHandler.isFunctionalCode(99));
    }

}