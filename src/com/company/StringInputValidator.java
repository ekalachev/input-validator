package com.company;

import java.util.HashSet;

public class StringInputValidator {
    /**
     * Checks if:
     * - all characters are unique.
     * - at least 1 digit.
     * - at least 8 symbols.
     * @param input a validating string
     * @return is valid string
     */
    public static boolean validate(String input) {
        if (input == null || input.length() < 8) {
            return false;
        }

        HashSet<Character> uniqueCharacters = new HashSet<>();
        boolean hasDigits = false;

        for(Character c: input.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigits = true;
            }

            uniqueCharacters.add(c);
        }

        return hasDigits && uniqueCharacters.size() == input.length();
    }
}
