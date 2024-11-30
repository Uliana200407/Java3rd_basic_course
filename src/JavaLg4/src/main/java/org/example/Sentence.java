package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a sentence consisting of words and punctuation elements.
 */
public class Sentence {

    // List to store elements of the sentence (words and punctuation)
    private List<Object> elements = new ArrayList<>();

    /**
     * Constructor to create a Sentence object by parsing the input string.
     *
     * @param sentence the sentence to be parsed into words and punctuation.
     */
    public Sentence(String sentence) {
        // Split the sentence by word boundaries using regular expression
        String[] parts = sentence.split("\\b");

        // Iterate through each part and categorize as either Word or Punctuation
        for (String part : parts) {
            if (part.matches("\\p{Punct}")) {
                // If part is punctuation, add a Punctuation object
                elements.add(new Punctuation(part.charAt(0)));
            } else if (!part.isBlank()) {
                // If part is not blank, add a Word object
                elements.add(new Word(part.trim()));
            }
        }
    }

    /**
     * Returns the list of all elements (words and punctuation) in the sentence.
     *
     * @return the list of elements in the sentence.
     */
    public List<Object> getElements() {
        return elements;
    }

    /**
     * Returns a list of only the words in the sentence.
     *
     * @return the list of words in the sentence.
     */
    public List<Word> getWords() {
        List<Word> words = new ArrayList<>();
        for (Object element : elements) {
            if (element instanceof Word) {
                words.add((Word) element);
            }
        }
        return words;
    }

    /**
     * Returns the string representation of the sentence by concatenating its elements.
     *
     * @return the string representation of the sentence.
     */
    @Override
    public String toString() {
        StringBuilder sentenceString = new StringBuilder();
        for (Object element : elements) {
            sentenceString.append(element.toString()).append(" ");
        }
        return sentenceString.toString().trim();
    }
}
