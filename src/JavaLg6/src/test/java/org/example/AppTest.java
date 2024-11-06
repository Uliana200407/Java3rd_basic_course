package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class MyGenericCollectionTest {

    private MyGenericCollection<String> emptyCollection;
    private MyGenericCollection<String> singleElementCollection;
    private MyGenericCollection < Object > collectionFromList;

    @BeforeEach
    void setUp() {
        emptyCollection = new MyGenericCollection<>();
        singleElementCollection = new MyGenericCollection<>("Hello");
        LinkedList<String> initialList = new LinkedList<>(Arrays.asList("Apple", "Banana"));
        collectionFromList = new MyGenericCollection< Object> (initialList);
    }

    @Test
    void testEmptyCollection() {
        assertTrue(emptyCollection.isEmpty());
        assertEquals(0, emptyCollection.size());
    }

    @Test
    void testSingleElementCollection() {
        assertEquals(1, singleElementCollection.size());
        assertTrue(singleElementCollection.contains("Hello"));
    }

    @Test
    void testCollectionFromList() {
        assertEquals(2, collectionFromList.size());
        assertTrue(collectionFromList.contains("Apple"));
        assertTrue(collectionFromList.contains("Banana"));
    }

    @Test
    void testAddElement() {
        assertTrue(singleElementCollection.add("World"));
        assertTrue(singleElementCollection.contains("World"));
        assertEquals(2, singleElementCollection.size());

        assertFalse(singleElementCollection.add("World"));
        assertEquals(2, singleElementCollection.size());
    }

    @Test
    void testRemoveElement() {
        assertTrue(collectionFromList.remove("Apple"));
        assertFalse(collectionFromList.contains("Apple"));
        assertEquals(1, collectionFromList.size());

        assertFalse(collectionFromList.remove("NonExistent"));
    }

    @Test
    void testAddAll() {
        LinkedList<String> anotherList = new LinkedList<>(Arrays.asList("Cherry", "Date"));
        assertTrue(collectionFromList.addAll(anotherList));
        assertTrue(collectionFromList.contains("Cherry"));
        assertTrue(collectionFromList.contains("Date"));
        assertEquals(4, collectionFromList.size());

        assertFalse(collectionFromList.addAll(new LinkedList<>()));
        assertEquals(4, collectionFromList.size());
    }

    @Test
    void testRetainAll() {
        LinkedList<String> retainList = new LinkedList<>(Arrays.asList("Banana", "Cherry"));
        assertTrue(collectionFromList.add("Cherry")); // Add an extra element to retain
        assertTrue(collectionFromList.retainAll(retainList));
        assertTrue(collectionFromList.contains("Banana"));
        assertTrue(collectionFromList.contains("Cherry"));
        assertEquals(2, collectionFromList.size());
    }

    @Test
    void testRemoveAll() {
        LinkedList<String> removeList = new LinkedList<>(Arrays.asList("Apple", "Banana"));
        assertTrue(collectionFromList.removeAll(removeList));
        assertTrue(collectionFromList.isEmpty());

        assertFalse(collectionFromList.removeAll(Arrays.asList("NonExistent")));
    }

    @Test
    void testClear() {
        collectionFromList.clear();
        assertTrue(collectionFromList.isEmpty());
        assertEquals(0, collectionFromList.size());
    }

    @Test
    void testContainsAll() {
        LinkedList<String> testList = new LinkedList<>(Arrays.asList("Apple", "Banana"));
        assertTrue(collectionFromList.containsAll(testList));

        testList.add("NonExistent");
        assertFalse(collectionFromList.containsAll(testList));
    }

    @Test
    void testToArray() {
        Object[] array = collectionFromList.toArray();
        assertEquals(2, array.length);
        assertArrayEquals(new Object[]{"Apple", "Banana"}, array);

        String[] stringArray = collectionFromList.toArray(new String[0]);
        assertEquals(2, stringArray.length);
        assertArrayEquals(new String[]{"Apple", "Banana"}, stringArray);
    }
}
