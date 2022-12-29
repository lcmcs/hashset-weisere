package edu.touro.cs.mcon364;

import java.util.*;

public class MyHashSet implements Set<String> {
    private int initialCapacity = 16;
    private ArrayList[] hashTable;
    private float loadFactor = 0.75f;
    private int size = 0;

    public MyHashSet(){
        hashTable = new ArrayList[initialCapacity];
    }


    public MyHashSet(int initialCapacity, float loadFactor){
        this.loadFactor = loadFactor;
        this.initialCapacity = initialCapacity;
        hashTable = new ArrayList[initialCapacity];
    }

//    public MyHashSet(Collection<String> c){
//        hashTable = new ArrayList[c.size()*2];
//        for (String s: c){
//            add(s);
//        }
//    }


    public MyHashSet(int initialCapacity){
        this.initialCapacity = initialCapacity;
        hashTable = new ArrayList[initialCapacity];
    }


@Override
public Iterator<String> iterator() {
    return new MyHashSetIterator();
}


    private class MyHashSetIterator implements Iterator<String> { // inner class
        private int preIndex = 0;
       private Iterator bucketIterator;

        @Override
        public boolean hasNext() {
            return this.preIndex < MyHashSet.this.size();
        }

        @Override
        public String next()  {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            while(hashTable[preIndex] == null || !bucketIterator.hasNext()){
                 preIndex++;
                 if(hashTable[preIndex] != null)
                    bucketIterator =  hashTable[preIndex].iterator();
            }
                return (String) bucketIterator.next();
        }

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size < 1;
    }

    @Override
    public boolean contains(Object o) {
        int index = o.hashCode() % hashTable.length;
        if(hashTable[index] == null){
            return false;
        }
        return hashTable[index].contains(o);
    }


    @Override
    public Object[] toArray() {
        int index = 0;
        Object[] copyArray = new String[size()];
        for (String s: this) {
            copyArray[index] = s;
            index++;
        }
        return copyArray;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(String s) {
        if (contains(s)){
            return false;
        }
        if((double)size()/hashTable.length >= loadFactor){
            growHashTable();
        }
        int index = s.hashCode() % hashTable.length;
        if (hashTable[index] == null){
            ArrayList<Object> bucket = new ArrayList<>(1);
            bucket.add(s);
            hashTable[index] = bucket;
        }
        else{
            hashTable[index].add(s);
        }
        size++;
        return true;
    }

    private void growHashTable(){
        ArrayList[] newHashTable = new ArrayList[hashTable.length * 2];
        Object o;
        int index;
//        for(int i = 0; i < hashTable.length; i++) {
//            if (hashTable[i] != null) {
//                for (int j = 0; j < hashTable[i].size(); j++) {
        for (String s: this) {
            index = s.hashCode() % newHashTable.length;
                    if(newHashTable[index] == null) {
                        ArrayList<Object> bucket = new ArrayList<>(1);
                        bucket.add(s);
                        newHashTable[index] = bucket;
                    }
                    else {
                        newHashTable[index].add(s);
                    }
                }
        hashTable = newHashTable;
    }

    @Override
    public boolean remove(Object o) {
        if (!contains(o)){
            return false;
        }
        int index = o.hashCode() % hashTable.length;
        if (hashTable[index].size() <= 1){
            hashTable[index] = null;
        }
        else {
            hashTable[index].remove(o);
        }
        size--;
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends String> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        size = 0;
        hashTable = new ArrayList[hashTable.length];
    }

    //added for testing purposes
    public int length(){
        return hashTable.length;
    }
}

