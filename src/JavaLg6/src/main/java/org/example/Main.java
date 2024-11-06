package org.example;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

interface MySetInterface<T> extends Set<T> {
}

class MyGenericCollection<T> implements MySetInterface<T> {
    private LinkedList<T> list;

    public MyGenericCollection() {
        this.list = new LinkedList<>();
    }

    public MyGenericCollection(T element) {
        this();
        this.add(element);
    }

    public MyGenericCollection(Collection<? extends T> collection) {
        this();
        this.addAll(collection);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return list.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    @Override
    public <E> E[] toArray(E[] a) {
        return list.toArray(a);
    }

    @Override
    public boolean add(T element) {
        if (!list.contains(element)) {
            list.add(element);
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return list.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return list.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean changed = false;
        for (T element : c) {
            if (add(element)) {
                changed = true;
            }
        }
        return changed;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return list.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return list.removeAll(c);
    }

    @Override
    public void clear() {
        list.clear();
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
