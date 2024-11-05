package org.example;

import java.util.*;

/**
 * Executes the lab work tasks with the new classes.
 */
public class LabWork2Executor {

    private Text text;

    public LabWork2Executor(int studentNumber, String inputText) {
        this.text = new Text(inputText);

        int c3 = studentNumber % 3;
        int c17 = studentNumber % 17;

        switch (c3) {
            case 0 -> System.out.println("Task 1 result: " + findMaxSentencesWithDuplicateWords());
            case 1 -> System.out.println("Task 2 result: " + sortSentencesByWordCount());
            case 2 -> System.out.println("Task 3 result: " + findUniqueWordInFirstSentence());
        }

        switch (c17) {
            case 0 -> System.out.println("Number of sentences with duplicate words: " + findMaxSentencesWithDuplicateWords());
            case 1 -> System.out.println("Sentences sorted by word count: " + sortSentencesByWordCount());
            case 2 -> System.out.println("Unique word in the first sentence: " + findUniqueWordInFirstSentence());
            case 3 -> System.out.println("Unique words of specified length in question sentences: " + findUniqueWordsInQuestions(5));
            default -> System.out.println("No operation for C17 = " + c17);
        }
    }

    protected int findMaxSentencesWithDuplicateWords() {
        int count = 0;

        for (Sentence sentence : text.getSentences()) {
            Set<String> words = new HashSet<>();
            boolean hasDuplicate = false;

            for (Object element : sentence.getElements()) {
                if (element instanceof Word) {
                    String word = element.toString().toLowerCase();
                    if (!words.add(word)) {
                        hasDuplicate = true;
                        break;
                    }
                }
            }

            if (hasDuplicate) {
                count++;
            }
        }
        return count;
    }

    protected String sortSentencesByWordCount() {
        List<Sentence> sentences = new ArrayList<>(text.getSentences());
        sentences.sort(Comparator.comparingInt(s -> s.getWords().size()));

        StringBuilder sortedSentences = new StringBuilder();
        for (Sentence sentence : sentences) {
            sortedSentences.append(sentence.toString()).append(". ");
        }
        return sortedSentences.toString().trim();
    }

    protected String findUniqueWordInFirstSentence() {
        if (text.getSentences().isEmpty()) return null;

        Sentence firstSentence = text.getSentences().get(0);
        Set<String> otherWords = new HashSet<>();

        for (int i = 1; i < text.getSentences().size(); i++) {
            for (Word word : text.getSentences().get(i).getWords()) {
                otherWords.add(word.toString().toLowerCase());
            }
        }

        for (Word word : firstSentence.getWords()) {
            String wordStr = word.toString();
            if (!otherWords.contains(wordStr.toLowerCase())) {
                return wordStr;  // Return the word in its original form
            }
        }
        return null;
    }

    protected Set<String> findUniqueWordsInQuestions(int length) {
        Set<String> uniqueWords = new HashSet<>();

        for (Sentence sentence : text.getSentences()) {
            String sentenceStr = sentence.toString().trim();
            if (sentenceStr.endsWith("?")) {
                for (Word word : sentence.getWords()) {
                    String wordStr = word.toString().toLowerCase().replaceAll("[^a-zA-Z]", "");
                    if (wordStr.length() == length) {
                        uniqueWords.add(wordStr);
                    }
                }
            }
        }
        return uniqueWords;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your student number: ");
        int studentNumber = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the text to process: ");
        String text = scanner.nextLine();

        new LabWork2Executor(studentNumber, text);
    }
}
