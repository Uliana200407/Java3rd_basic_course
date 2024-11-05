package org.example;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class LabWork2Test {

    @Test
    void testFindMaxSentencesWithDuplicateWords() {
        LabWork2 labWork = new LabWork2(0, "");
        String text = "This is a test sentence. Another test sentence with duplicates duplicates.";
        assertEquals(1, labWork.findMaxSentencesWithDuplicateWords(text));
    }

    @Test
    void testSortSentencesByWordCount() {
        LabWork2 labWork = new LabWork2(1, "");
        String text = "Short sentence. This is a bit longer sentence. The longest sentence is this one.";
        List<String> sortedSentences = labWork.sortSentencesByWordCount(text);
        assertEquals("Short sentence", sortedSentences.get(0).trim());
        assertEquals("This is a bit longer sentence", sortedSentences.get(1).trim());
        assertEquals("The longest sentence is this one", sortedSentences.get(2).trim());
    }

    @Test
    void testFindUniqueWordInFirstSentence() {
        LabWork2 labWork = new LabWork2(2, "");
        String text = "Unique word in first. This is a test sentence with common words.";
        assertEquals("Unique", labWork.findUniqueWordInFirstSentence(text));
    }

}
