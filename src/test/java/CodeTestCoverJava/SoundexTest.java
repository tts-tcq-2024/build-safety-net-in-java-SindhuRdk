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
        assertEquals("A000", Soundex.generateSoundex("AEIOU"));
    }

    @Test
    public void testConsonants() {
        assertEquals("S530", Soundex.generateSoundex("Smith")); // S530
        assertEquals("R163", Soundex.generateSoundex("Robert")); // R163
    }

    @Test
    public void testRepeatedConsonants() {
        assertEquals("T315", Soundex.generateSoundex("Ttfn")); // T315
    }

    @Test
    public void testPadding() {
        assertEquals("W623", Soundex.generateSoundex("Wright")); // W623
        assertEquals("P620", Soundex.generateSoundex("Park"));   // Updated to P620
    }

    @Test
    public void testMixedCase() {
        assertEquals("R163", Soundex.generateSoundex("RoBeRt")); // R163
    }

    @Test
    public void testHAndWHandling() {
        assertEquals("R000", Soundex.generateSoundex("RWH")); // R000
    }
}
