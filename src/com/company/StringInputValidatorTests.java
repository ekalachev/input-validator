package com.company;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringInputValidatorTests {

    static Stream<String> blankStrings() {
        return Stream.of("", null);
    }

    @ParameterizedTest
    @MethodSource("blankStrings")
    @DisplayName("Returns false when input is null or empty")
    public void inputIsNullOrEmpty(String input) {
        // Arrange // Act // Assert
        assertFalse(StringInputValidator.validate(input));
    }

    @Test
    @DisplayName("Returns false when input length is les then 8 characters")
    public void inputIsLesThen8Characters() {
        // Arrange
        String input = "1abc";

        // Act // Assert
        assertFalse(StringInputValidator.validate(input));
    }

    @Test
    @DisplayName("Returns false if input has not any digits")
    public void inputHasNotAnyDigit() {
        // Arrange
        String input = "abcdifgh";

        // Act // Assert
        assertFalse(StringInputValidator.validate(input));
    }

    @Test
    @DisplayName("Returns false if all characters are not unique")
    public void inputHasNotAllUniqueCharacters() {
        // Arrange
        String input = "aabcdifgh123";

        // Act // Assert
        assertFalse(StringInputValidator.validate(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcdifg98%&@$*", "12345678", "!@#$%^7&*()"})
    @DisplayName("Returns true if input length more or equal 8, has 1 or more digits, all characters are unique")
    public void inputIsValid(String input) {
        // Arrange // Act // Assert
        assertTrue(StringInputValidator.validate(input));
    }
}
