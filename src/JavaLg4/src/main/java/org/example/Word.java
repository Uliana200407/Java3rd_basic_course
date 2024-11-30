package org.example;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents a word composed of letters.
 */
public class Word {

    // List of letters that make up the word
    private List<Letter> letters;

    /**
     * Constructor to initialize a Word object from a string.
     * Each character in the string is converted to a Letter object.
     *
     * @param word the string representing the word.
     */
    public Word(String word) {
        // Convert each character in the word to a Letter object and collect them in a list
        letters = word.chars()
                .mapToObj(c -> new Letter((char) c))
                .collect(Collectors.toList());
    }

    /**
     * Returns a string representation of the word.
     * The word is reconstructed by joining the string representations of each letter.
     *
     * @return the string representing the word.
     */
    @Override
    public String toString() {
        return letters.stream()
                .map(Letter::toString)
                .collect(Collectors.joining());
    }
}
