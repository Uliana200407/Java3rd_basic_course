package org.example;

import java.util.ArrayList;
import java.util.List;

public class Text {
    private List<Sentence> sentences = new ArrayList<>();

    public Text(String text) {
        String cleanedText = text.replaceAll("[\\t\\s]+", " ");
        String[] sentencesArray = cleanedText.split("(?<=[.!?])\\s*");

        for (String sentence : sentencesArray) {
            sentences.add(new Sentence(sentence));
        }
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    @Override
    public String toString() {
        StringBuilder textString = new StringBuilder();
        for (Sentence sentence : sentences) {
            textString.append(sentence.toString()).append(" ");
        }
        return textString.toString().trim();
    }
}
