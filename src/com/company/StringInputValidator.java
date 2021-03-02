package com.company;

import java.util.HashSet;

public class StringInputValidator {
    /**
     * Checks if:
     * - all characters are unique.
     * - at least 1 digit.
     * - at least 8 symbols.
     *
     * @param input a validating string
     * @return is valid string
     */
    public static boolean validate(String input) {
        if (input == null || input.length() < 8) {
            return false;
        }

        int initialCapacity = (int) (input.length() / 0.75 + 1);
        HashSet<Character> uniqueCharacters = new HashSet<>(initialCapacity);
        boolean hasDigits = false;

        for (int i = 0, length = input.length(); i < length; i++) {
            char c = input.charAt(i);

            if (isDigit(c)) {
                hasDigits = true;
            }

            uniqueCharacters.add(c);
        }

        return hasDigits && uniqueCharacters.size() == input.length();
    }

    private static boolean isDigit(char c) {
        return Character.isDigit(c); // or '0' <= c && c <= '9';
    }
}
