package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class Word {
    private List<Letter> letters;

    public Word(String word) {
        letters = word.chars()
                .mapToObj(c -> new Letter((char) c))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return letters.stream()
                .map(Letter::toString)
                .collect(Collectors.joining());
    }
}
