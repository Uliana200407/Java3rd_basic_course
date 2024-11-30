package org.example;

import java.util.*;

public class LabWork2 {

    private Object textVariable;

    /**
     * Constructor to initialize textVariable based on student number and perform operations on the text.
     *
     * @param studentNumber The student's number.
     * @param text          The input text to be processed.
     */
    public LabWork2(int studentNumber, String text) {
        int c3 = studentNumber % 3;
        int c17 = studentNumber % 17;

        // Initialize textVariable based on the value of c3
        switch (c3) {
            case 0:
                textVariable = new StringBuilder();
                break;
            case 1:
                textVariable = "";
                break;
            case 2:
                textVariable = new StringBuffer();
                break;
            default:
                throw new IllegalArgumentException("Invalid value for c3: " + c3);
        }

        // Perform operations based on the value of c17
        switch (c17) {
            case 0:
                System.out.println("Number of sentences with duplicate words: " + findMaxSentencesWithDuplicateWords(text));
                break;
            case 1:
                System.out.println("Sentences sorted by word count: " + sortSentencesByWordCount(text));
                break;
            case 2:
                System.out.println("Unique word in the first sentence: " + findUniqueWordInFirstSentence(text));
                break;
            case 3:
                System.out.println("Unique words of specified length in question sentences: " + findUniqueWordsInQuestions(text, 5));
                break;
            default:
                System.out.println("No operation for C17 = " + c17);
                break;
        }
    }

    /**
     * Finds the number of sentences with duplicate words in the provided text.
     *
     * @param text The input text to be analyzed.
     * @return The number of sentences with duplicate words.
     */
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

    /**
     * Sorts sentences in the text based on their word count.
     *
     * @param text The input text to be sorted.
     * @return A list of sentences sorted by word count.
     */
    protected List<String> sortSentencesByWordCount(String text) {
        String[] sentences = text.split("[.!?]");
        List<String> sentenceList = new ArrayList<>(Arrays.asList(sentences));

        // Sort sentences based on word count
        sentenceList.sort(Comparator.comparingInt(sentence -> sentence.trim().split("\\s+").length));

        return sentenceList;
    }

    /**
     * Finds the unique word in the first sentence of the provided text.
     *
     * @param text The input text to be analyzed.
     * @return The unique word in the first sentence, or null if there is no unique word.
     */
    protected String findUniqueWordInFirstSentence(String text) {
        String[] sentences = text.split("[.!?]");
        if (sentences.length > 0) {
            String firstSentence = sentences[0].trim();
            Set<String> wordsSet = new HashSet<>();
            String[] words = firstSentence.split("\\s+");

            for (String word : words) {
                if (!wordsSet.add(word.toLowerCase())) {
                    wordsSet.remove(word.toLowerCase());
                }
            }

            return wordsSet.isEmpty() ? null : wordsSet.iterator().next();
        }
        return null;
    }

    /**
     * Finds unique words of a specified length in question sentences (those ending with '?' mark).
     *
     * @param text     The input text to be analyzed.
     * @param wordLength The length of the words to be considered unique.
     * @return A list of unique words matching the specified length.
     */
    protected List<String> findUniqueWordsInQuestions(String text, int wordLength) {
        String[] sentences = text.split("[.!?]");
        List<String> uniqueWords = new ArrayList<>();

        for (String sentence : sentences) {
            if (sentence.trim().endsWith("?")) {
                Set<String> wordsSet = new HashSet<>();
                String[] words = sentence.trim().split("\\s+");

                for (String word : words) {
                    if (word.length() == wordLength && !wordsSet.contains(word)) {
                        uniqueWords.add(word);
                        wordsSet.add(word);
                    }
                }
            }
        }

        return uniqueWords;
    }
}
