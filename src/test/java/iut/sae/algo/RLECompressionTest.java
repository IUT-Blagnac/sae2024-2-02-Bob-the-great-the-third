package iut.sae.algo;

import org.junit.Test;
import junit.framework.TestCase;

public class RLECompressionTest extends TestCase {

    @Test
    public void testBasicScenarios() {
        // Test empty string
        assertEquals("", Efficacite.RLE(""));

        // Test single character
        assertEquals("1a", Efficacite.RLE("a"));

        // Test string with no repetitions
        assertEquals("1a1b1c1d", Efficacite.RLE("abcd"));

        // Test string with multiple repetitions
        assertEquals("4a3b2c", Efficacite.RLE("aaaabbbcc"));

        // Test string with single and multiple repetitions
        assertEquals("1a3b2c1d", Efficacite.RLE("abbbccd"));

        // Test string with all characters same
        assertEquals("10z", Efficacite.RLE("zzzzzzzzzz"));
    }

    @Test
    public void testSpecialCases() {
        // Test string with numbers
        assertEquals("1a1b3c", Efficacite.RLE("abccc"));

        // Test string with special characters
        assertEquals("3!2@1#", Efficacite.RLE("!!!@@#"));

        // Test string with mixed case characters
        assertEquals("1a1A2b2B", Efficacite.RLE("aAbbBB"));

        // Test long string
        String longStringInput = "a".repeat(1000);
        assertEquals("1000a", Efficacite.RLE(longStringInput));
    }
}
