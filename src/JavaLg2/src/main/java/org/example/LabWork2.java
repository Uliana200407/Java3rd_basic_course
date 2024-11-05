package org.example;

import java.util.*;

public class LabWork2 {

    private Object textVariable;

    public LabWork2(int studentNumber, String text) {
        int c3 = studentNumber % 3;
        int c17 = studentNumber % 17;

        switch (c3) {
            case 0 -> textVariable = new StringBuilder();
            case 1 -> textVariable = "";
            case 2 -> textVariable = new StringBuffer();
        }

        switch (c17) {
            case 0 -> System.out.println("Number of sentences with duplicate words: " + findMaxSentencesWithDuplicateWords(text));
            case 1 -> System.out.println("Sentences sorted by word count: " + sortSentencesByWordCount(text));
            case 2 -> System.out.println("Unique word in the first sentence: " + findUniqueWordInFirstSentence(text));
            case 3 -> System.out.println("Unique words of specified length in question sentences: " + findUniqueWordsInQuestions(text, 5));
            default -> System.out.println("No operation for C17 = " + c17);
        }
    }

    protected int findMaxSentencesWithDuplicateWords(String text) {
        String[] sentences = text.split("[.!?]");
        int maxDuplicates = 0;

        for (String sentence : sentences) {
            Set<String> wordsSet = new HashSet<>();
            boolean hasDuplicates = false;
            for (String word : sentence.trim().split("\\s+")) {
                if (!wordsSet.add(word.toLowerCase())) {
                    hasDuplicates = true;
                    break;
                }
            }
            if (hasDuplicates) {
                maxDuplicates++;
            }
        }
        return maxDuplicates;
    }

    protected List<String> sortSentencesByWordCount(String text) {
        String[] sentences = text.split("[.!?]");
        List<String> sentenceList = new ArrayList<>(Arrays.asList(sentences));

        sentenceList.sort(Comparator.comparingInt(s -> s.trim().split("\\s+").length));
        return sentenceList;
    }

    protected String findUniqueWordInFirstSentence(String text) {
        String[] sentences = text.split("[.!?]");
        if (sentences.length == 0) return null;

        String[] firstSentenceWords = sentences[0].trim().split("\\s+");
        Set<String> otherWords = new HashSet<>();

        for (int i = 1; i < sentences.length; i++) {
            String[] words = sentences[i].trim().split("\\s+");
            for (String word : words) {
                otherWords.add(word.toLowerCase());
            }
        }

        for (String word : firstSentenceWords) {
            if (!otherWords.contains(word.toLowerCase())) {
                return word;
            }
        }
        return null;
    }

    protected Set<String> findUniqueWordsInQuestions(String text, int wordLength) {
        String[] sentences = text.split("[.!?]");
        Set<String> uniqueWords = new HashSet<>();

        for (String sentence : sentences) {
            sentence = sentence.trim();
            System.out.println("Processing sentence: '" + sentence + "'");

            if (sentence.endsWith("?")) {
                System.out.println("Identified question sentence: '" + sentence + "'");
                String[] words = sentence.split("\\s+");
                for (String word : words) {
                    word = word.toLowerCase().replaceAll("[^a-zA-Z]", "");
                    System.out.println("Checking word: '" + word + "'");
                    if (word.length() == wordLength) {
                        uniqueWords.add(word);
                        System.out.println("Added word: '" + word + "'");
                    }
                }
            }
        }

        System.out.println("Unique words of specified length in question sentences: " + uniqueWords);
        return uniqueWords;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int c17;

        while (true) {
            System.out.print("Enter your student number: ");
            int studentNumber = scanner.nextInt();
            scanner.nextLine();

            c17 = studentNumber % 17;
            if (c17 >= 0 && c17 <= 3) {
                System.out.println("Enter the text to process:");
                String text = scanner.nextLine();
                new LabWork2(studentNumber, text);
                break;
            } else {
                System.out.println("Invalid C17 value (" + c17 + "). Please enter a different student number.");
            }
        }
    }
}
