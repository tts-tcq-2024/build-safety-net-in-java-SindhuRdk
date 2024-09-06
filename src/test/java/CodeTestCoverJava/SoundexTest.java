package CodeTestCoverJava;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SoundexTest {

    @Test
    public void testEmptyString() {
        assertEquals("", Soundex.generateSoundex(""));
    }

    @Test
    public void testNullString() {
        assertEquals("", Soundex.generateSoundex(null));
    }

    @Test
    public void testSingleCharacter() {
        assertEquals("A000", Soundex.generateSoundex("A"));
    }

    @Test
    public void testVowels() {
        // No consonants, expect padding
        assertEquals("A000", Soundex.generateSoundex("AEIOU"));
    }

    @Test
    public void testConsonants() {
        // Standard consonants with Soundex encoding
        assertEquals("S532", Soundex.generateSoundex("Smith"));
        assertEquals("R163", Soundex.generateSoundex("Robert"));
    }

    @Test
    public void testRepeatedConsonants() {
        // Repeated consonants should not be re-encoded
        assertEquals("T520", Soundex.generateSoundex("Ttfn"));
    }

    @Test
    public void testPadding() {
        // Test padding for fewer than 4 characters
        assertEquals("W252", Soundex.generateSoundex("Wright"));
        assertEquals("P200", Soundex.generateSoundex("Park"));
    }

    @Test
    public void testMixedCase() {
        // Mixed case input should result in the same output
        assertEquals("R163", Soundex.generateSoundex("RoBeRt"));
    }

    @Test
    public void testHAndWHandling() {
        // 'H' and 'W' should be handled as non-encoded characters
        assertEquals("R300", Soundex.generateSoundex("RWH"));
    }
}
