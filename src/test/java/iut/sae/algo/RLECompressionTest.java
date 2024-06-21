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

        // Test string with no repeons
        assertEquals("1a1b1c1d", Efficacite.RLE("abcd"));

        // Test string with multiple repeons
        assertEquals("4a3b2c", Efficacite.RLE("aaaabbbcc"));

        // Test string with single and multiple repeons
        assertEquals("1a3b2c1d", Efficacite.RLE("abbbccd"));

        // Test string with all characters same
        assertEquals("9z1z", Efficacite.RLE("zzzzzzzzzz"));
    }

    @Test
    public void testSpecialCases() {
        // Test string with numbers
        assertEquals("1a1b3c", Efficacite.RLE("abccc"));

        // Test string with special characters
        assertEquals("3!2@1#", Efficacite.RLE("!!!@@#"));

        // Test string with mixed case characters
        assertEquals("1a1A2b2B", Efficacite.RLE("aAbbBB"));

        String longStringInput = "a".repeat(1000); // Crée une chaîne de 1000 'a'
        String expectedOutput = "9a".repeat(111) + "1a"; // Attendu: "9a" + 109 fois "9a"

        assertEquals(expectedOutput, Efficacite.RLE(longStringInput));
    }

    @Test
    public void testRLE() {
        assertEquals("4a3b2c", Efficacite.RLE("aaaabbbcc"));
        assertEquals("1a1b1c1d1e", Efficacite.RLE("abcde"));
        assertEquals("1a", Efficacite.RLE("a"));
        assertEquals("", Efficacite.RLE(""));
        assertEquals("9a1a", Efficacite.RLE("aaaaaaaaaa")); // Test with a run length > 9
    }

    @Test
    public void testUnRLE() {
        try {
            assertEquals("aaaabbbcc", Efficacite.unRLE("4a3b2c"));
            assertEquals("abcde", Efficacite.unRLE("1a1b1c1d1e"));
            assertEquals("a", Efficacite.unRLE("1a"));
            assertEquals("", Efficacite.unRLE(""));
            assertEquals("aaaaaaaaaa", Efficacite.unRLE("9a1a")); // Test with a run length > 9
        }catch (AlgoException e){
            e.printStackTrace();
        }
    }

    @Test
    public void testRLEWithIteration() {
        try {
            assertEquals("4a3b2c", Efficacite.RLE("aaaabbbcc", 1));
            assertEquals("141a131b121c", Efficacite.RLE("aaaabbbcc", 2)); // Second iteration of RLE
            assertEquals("1114111a1113111b1112111c", Efficacite.RLE("aaaabbbcc", 3)); // Third iteration of RLE
            assertEquals("", Efficacite.RLE("", 3));
        }catch(AlgoException e){
            e.printStackTrace();
        }
    }
}
