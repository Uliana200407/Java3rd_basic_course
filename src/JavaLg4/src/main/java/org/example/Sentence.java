package org.example;

import java.util.ArrayList;
import java.util.List;


public class Sentence {
    private List<Object> elements = new ArrayList<>();

    public Sentence(String sentence) {
        String[] parts = sentence.split("\\b");

        for (String part : parts) {
            if (part.matches("\\p{Punct}")) {
                elements.add(new Punctuation(part.charAt(0)));
            } else if (!part.isBlank()) {
                elements.add(new Word(part.trim()));
            }
        }
    }

    public List<Object> getElements() {
        return elements;
    }

    public List<Word> getWords() {
        List<Word> words = new ArrayList<>();
        for (Object element : elements) {
            if (element instanceof Word) {
                words.add((Word) element);
            }
        }
        return words;
    }

    @Override
    public String toString() {
        StringBuilder sentenceString = new StringBuilder();
        for (Object element : elements) {
            sentenceString.append(element.toString()).append(" ");
        }
        return sentenceString.toString().trim();
    }
}
