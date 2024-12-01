package org.example;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/**
 * MySetInterface extends the Set interface and is used for defining custom set-like behavior
 * for the MyGenericCollection class.
 */
interface MySetInterface<T> extends Set<T> {
}

/**
 * MyGenericCollection is a custom implementation of a set-like data structure using LinkedList.
 * It implements MySetInterface and provides methods to manipulate the collection of unique elements.
 *
 * @param <T> - The type of elements stored in this collection.
 */
class MyGenericCollection<T> implements MySetInterface<T> {
    private LinkedList<T> list;

    public MyGenericCollection() {
        this.list = new LinkedList<>();
    }
    /**
     * Constructor that initializes the collection with one element.
     *
     * @param element - The element to be added to the collection.
     */
    public MyGenericCollection(T element) {
        this();
        this.add(element);
    }

    /**
     * Constructor that initializes the collection with elements from another collection.
     *
     * @param collection - A collection of elements to be added to this custom collection.
     */
    public MyGenericCollection(Collection<? extends T> collection) {
        this();
        this.addAll(collection);  // Adds all elements from the given collection
    }

    /**
     * Returns the number of elements in the collection.
     *
     * @return The size of the collection.
     */
    @Override
    public int size() {
        return list.size();
    }


    /**
     * Checks whether the collection is empty.
     *
     * @return True if the collection has no elements, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Checks whether the collection contains a specific element.
     *
     * @param o - The element to check for presence in the collection.
     * @return True if the element is present, false otherwise.
     */
    @Override
    public boolean contains(Object o) {
        return list.contains(o);
    }

    /**
     * Returns an iterator to iterate over the collection's elements.
     *
     * @return An iterator for the collection.
     */
    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    /**
     * Returns an array containing all the elements of the collection.
     *
     * @return An array containing the elements.
     */
    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    /**
     * Returns an array containing all elements of the collection, and the array's runtime type is
     * specified by the given argument.
     *
     * @param a - The array into which the elements are to be stored.
     * @param <E> - The type of the array elements.
     * @return An array containing the elements of the collection.
     */
    @Override
    public <E> E[] toArray(E[] a) {
        return list.toArray(a);
    }

    /**
     * Adds an element to the collection if it is not already present.
     *
     * @param element - The element to add.
     * @return True if the element was added, false if it was already present.
     */
    @Override
    public boolean add(T element) {
        if (!list.contains(element)) {  // Avoid duplicates
            list.add(element);
            return true;
        }
        return false;  // Element was already present
    }

    /**
     * Removes an element from the collection.
     *
     * @param o - The element to remove.
     * @return True if the element was removed, false otherwise.
     */
    @Override
    public boolean remove(Object o) {
        return list.remove(o);
    }


    /**
     * Checks if the collection contains all the elements in the given collection.
     *
     * @param c - The collection to check for contained elements.
     * @return True if the collection contains all the elements, false otherwise.
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        return list.containsAll(c);
    }


    /**
     * Adds all elements from the given collection to this collection.
     *
     * @param c - The collection of elements to add.
     * @return True if the collection was modified (i.e., at least one element was added), false otherwise.
     */
    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean changed = false;
        for (T element : c) {
            if (add(element)) {  // Add each element from the collection
                changed = true;
            }
        }
        return changed;
    }

    /**
     * Retains only the elements in the collection that are contained in the specified collection.
     * Removes all elements that are not in the specified collection.
     *
     * @param c - The collection of elements to retain.
     * @return True if the collection was modified (i.e., some elements were removed), false otherwise.
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        return list.retainAll(c);
    }
    /**
     * Removes all elements that are contained in the specified collection.
     *
     * @param c - The collection of elements to remove.
     * @return True if the collection was modified (i.e., at least one element was removed), false otherwise.
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        return list.removeAll(c);
    }

    /**
     * Removes all elements that are not contained in the specified collection.
     *
     */
    @Override
    public void clear() {
        list.clear();  // Clears the entire collection
    }

    @Override
    public String toString() {
        return list.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        MyGenericCollection<String> emptyCollection = new MyGenericCollection<>();

        MyGenericCollection<String> singleElementCollection = new MyGenericCollection<>("Hello");

        LinkedList<String> initialList = new LinkedList<>();
        initialList.add("Apple");
        initialList.add("Banana");
        MyGenericCollection<String> collectionFromList = new MyGenericCollection<>(initialList);

        System.out.println("Empty Collection: " + emptyCollection);
        System.out.println("Single Element Collection: " + singleElementCollection);
        System.out.println("Collection from List: " + collectionFromList);

        singleElementCollection.add("World");
        System.out.println("After adding 'World' to Single Element Collection: " + singleElementCollection);

        collectionFromList.remove("Apple");
        System.out.println("After removing 'Apple' from Collection from List: " + collectionFromList);

        LinkedList<String> anotherList = new LinkedList<>();
        anotherList.add("Cherry");
        anotherList.add("Date");
        collectionFromList.addAll(anotherList);
        System.out.println("After adding another list to Collection from List: " + collectionFromList);

        LinkedList<String> retainList = new LinkedList<>();
        retainList.add("Banana");
        retainList.add("Cherry");
        collectionFromList.retainAll(retainList);
        System.out.println("After retaining only 'Banana' and 'Cherry' in Collection from List: " + collectionFromList);

        System.out.println("Collection from List contains 'Banana': " + collectionFromList.contains("Banana"));

        collectionFromList.clear();
        System.out.println("After clearing, Collection from List: " + collectionFromList);
    }
}
