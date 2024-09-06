package CodeTestCoverJava;

import java.util.HashMap;
import java.util.Map;

public class Soundex {

    private static final Map<Character, Character> soundexMap = new HashMap<>();

    static {
        // Initialize the Soundex map
        soundexMap.put('B', '1');
        soundexMap.put('F', '1');
        soundexMap.put('P', '1');
        soundexMap.put('V', '1');
        soundexMap.put('C', '2');
        soundexMap.put('G', '2');
        soundexMap.put('J', '2');
        soundexMap.put('K', '2');
        soundexMap.put('Q', '2');
        soundexMap.put('S', '2');
        soundexMap.put('X', '2');
        soundexMap.put('Z', '2');
        soundexMap.put('D', '3');
        soundexMap.put('T', '3');
        soundexMap.put('L', '4');
        soundexMap.put('M', '5');
        soundexMap.put('N', '5');
        soundexMap.put('R', '6');
    }

    public static String generateSoundex(String name) {
        if (isInvalidInput(name)) {
            return "";
        }

        StringBuilder soundex = new StringBuilder();
        soundex.append(Character.toUpperCase(name.charAt(0)));
        processCharsForSoundex(name, soundex);

        return padSoundex(soundex);
    }

    private static boolean isInvalidInput(String name) {
        return name == null || name.isEmpty();
    }

    private static void processCharsForSoundex(String name, StringBuilder soundex) {
        char prevCode = '0'; 
        char prevChar = Character.toUpperCase(name.charAt(0)); 

        for (int i = 1; i < name.length() && soundex.length() < 4; i++) {
            char currentChar = Character.toUpperCase(name.charAt(i));
            char code = getSoundexCode(currentChar);

            // Skip H and W but allow them to affect adjacent consonants
            if (shouldSkipCharacter(currentChar, prevChar)) {
                continue;
            }

            // Only append the code if it's valid and different from the previous code
            appendCodeIfValid(soundex, code, prevCode);
            prevCode = code;
            prevChar = currentChar;
        }
    }

    private static boolean shouldSkipCharacter(char currentChar, char prevChar) {
        // Skip H and W but allow them to affect consonants if adjacent to a consonant
        return isIgnoredCharacter(currentChar) && !isVowel(prevChar);
    }

    private static boolean isIgnoredCharacter(char currentChar) {
        return currentChar == 'H' || currentChar == 'W';
    }

    private static boolean isVowel(char c) {
        return "AEIOUY".indexOf(c) >= 0;
    }

    private static void appendCodeIfValid(StringBuilder soundex, char code, char prevCode) {
        if (isValidCode(code, prevCode) && soundex.length() < 4) {
            soundex.append(code);
        }
    }

    private static boolean isValidCode(char code, char prevCode) {
        return code != '0' && code != prevCode;
    }

    private static char getSoundexCode(char c) {
        return soundexMap.getOrDefault(c, '0');
    }

    private static String padSoundex(StringBuilder soundex) {
        while (soundex.length() < 4) {
            soundex.append('0');
        }
        return soundex.toString();
    }
}
