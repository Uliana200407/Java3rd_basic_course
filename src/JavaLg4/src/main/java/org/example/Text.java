package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a collection of sentences that form a text.
 */
public class Text {

    // List to store the sentences of the text
    private List<Sentence> sentences = new ArrayList<>();

    /**
     * Constructor to create a Text object by parsing the input string.
     *
     * @param text the raw text to be parsed into sentences.
     */
    public Text(String text) {
        // Clean the text by removing extra spaces and tabs
        String cleanedText = text.replaceAll("[\\t\\s]+", " ");

        // Split the cleaned text into individual sentences based on punctuation marks
        String[] sentencesArray = cleanedText.split("(?<=[.!?])\\s*");

        // Create Sentence objects from each part of the text
        for (String sentence : sentencesArray) {
            sentences.add(new Sentence(sentence));
        }
    }

    /**
     * Returns the list of sentences in the text.
     *
     * @return the list of Sentence objects.
     */
    public List<Sentence> getSentences() {
        return sentences;
    }

    /**
     * Returns a string representation of the entire text.
     *
     * @return a string representing the text.
     */
    @Override
    public String toString() {
        StringBuilder textString = new StringBuilder();

        // Append each sentence to the StringBuilder
        for (Sentence sentence : sentences) {
            textString.append(sentence.toString()).append(" ");
        }

        return textString.toString().trim();
    }
}
