package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


class LabWork2ExecutorTest {

    private LabWork2Executor labWork2Executor;

    @BeforeEach
    public void setUp() {
        String text = "Hello world! How are you? This is a test sentence. " +
                "Another sentence with duplicate duplicate words. " +
                "Unique words are fun.";
        labWork2Executor = new LabWork2Executor(5, text);
    }

    @Test
    public void testFindMaxSentencesWithDuplicateWords() {
        int duplicateCount = labWork2Executor.findMaxSentencesWithDuplicateWords();
        assertEquals(1, duplicateCount, "Expected 1 sentence with duplicate words");
    }

    @Test
    public void testFindUniqueWordInFirstSentence() {
        String uniqueWord = labWork2Executor.findUniqueWordInFirstSentence();
        assertEquals("Hello", uniqueWord, "Expected unique word 'Hello' in the first sentence");
    }
}
