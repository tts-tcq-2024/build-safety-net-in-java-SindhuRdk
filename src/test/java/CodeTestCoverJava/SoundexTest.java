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
    public void testNoConsonants() {
        assertEquals("A000", Soundex.generateSoundex("AEIOU"));
    }

    @Test
    public void testConsonantsOnly() {
        assertEquals("S532", Soundex.generateSoundex("Smith")); // Expected S532
        assertEquals("R163", Soundex.generateSoundex("Robert")); // Expected R163
    }

    @Test
    public void testRepeatedConsonants() {
        assertEquals("T520", Soundex.generateSoundex("Ttfn")); // Expected T520
    }

    @Test
    public void testPadding() {
        assertEquals("W252", Soundex.generateSoundex("Wright")); // Expected W252
        assertEquals("P200", Soundex.generateSoundex("Park")); // Expected P200
    }

    @Test
    public void testMixedCase() {
        assertEquals("R163", Soundex.generateSoundex("RoBeRt")); // Expected R163
    }

    @Test
    public void testHAndWHandling() {
        assertEquals("R300", Soundex.generateSoundex("RWH")); // Expected R300
    }
}
