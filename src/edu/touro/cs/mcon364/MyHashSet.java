package edu.touro.cs.mcon364;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

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

    public MyHashSet(Collection<String> c){
        hashTable = new ArrayList[c.size()*2];
        for (String s: c){
            add(s);
        }
    }

    //too access which list it is in u use o.hashCode() % hashTAble.length

    public MyHashSet(int initialCapacity){
        this.initialCapacity = initialCapacity;
        hashTable = new ArrayList[initialCapacity];
    }


//    public Iterator<E> iterator(){
//
//    }


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
    public Iterator<String> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        int index = 0;
        Object[] newHashSet = new String[hashTable.length];
        for(int i = 0; i < size(); i++)
            if(hashTable[i] != null)
                for(int j = 0; j < hashTable[i].size(); j++) {
                    newHashSet[index] = hashTable[i].get(j);
                    index++;
                }
        return newHashSet;
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
        if((double)size()/(double)hashTable.length >= loadFactor){
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
        int doubleSize = hashTable.length * 2;
        ArrayList[] newHashTable = new ArrayList[doubleSize];
        Object o;
        int index;
        for(int i = 0; i < size(); i++) {
            if (hashTable[i] != null) {
                for (int j = 0; j < hashTable[i].size(); j++) {
                    o = hashTable[i].get(j);
                    index = o.hashCode() % newHashTable.length;
                    if(newHashTable[index] == null) {
                        ArrayList<Object> bucket = new ArrayList<>(1);
                        bucket.add(o);
                        newHashTable[index] = bucket;
                    }
                    else {
                        newHashTable[index].add(o);
                    }
                }
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
        hashTable[index].remove(o);
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

