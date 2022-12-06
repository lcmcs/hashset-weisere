package edu.touro.cs.mcon364;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class MyHashSet implements Set<String> {
    private int initialCapacity = 16;
    private ArrayList<ArrayList<String>> hashTable;
    private float loadFactor = 0.75F;
    private int size = 0;

    public MyHashSet(){
        hashTable = new ArrayList<>(initialCapacity);
    }


    public MyHashSet(int initialCapacity, float loadFactor){
        this.loadFactor = loadFactor;
        this.initialCapacity = initialCapacity;
        hashTable = new ArrayList<>(initialCapacity);
    }

//    public MyHashSet(Collection<? extends E> c){
//
//    }

    //too access which list it is in u use o.hashCode() % hashTAble.length

    public MyHashSet(int initialCapacity){
        this.initialCapacity = initialCapacity;
        hashTable = new ArrayList<ArrayList<String>>(initialCapacity);
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
        int index = o.hashCode() % initialCapacity;
        return hashTable.get(index).contains(o);
    }

    @Override
    public Iterator<String> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(String s) {
        if(hashTable.size()/initialCapacity >= loadFactor){
            growHashTable();
        }
        if (contains(s)){
            return false;
        }
        int index = s.hashCode() % initialCapacity;
        hashTable.get(index).add(s);
        size++;
        return true;
    }

    private void growHashTable(){
        initialCapacity *= 2;
        ArrayList<ArrayList<String>> newHashTable = new ArrayList<ArrayList<String>>(initialCapacity);
        for(int i = 0; i < hashTable.size(); i++)
            for(int j = 0; j < hashTable.get(i).size(); j++)
                newHashTable.get(hashTable.get(i).get(j).hashCode() % initialCapacity).add(hashTable.get(i).get(j));

        hashTable = newHashTable;


    }

    @Override
    public boolean remove(Object o) {
        if (!contains(o)){
            return false;
        }
        int index = o.hashCode() % initialCapacity;
        hashTable.get(index).remove(o);
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
        hashTable = new ArrayList<>(initialCapacity);
    }
}
//    private int initialCapacity = 16;
//    ArrayList<ArrayList> hashTable = new ArrayList<>(initialCapacity);
//    private float loadFactor = 0.75F;
//
//
//    public MyHashSet(int initialCapacity, float loadFactor){
//        this.loadFactor = loadFactor;
//        ArrayList<ArrayList> hashTable = new ArrayList<>(initialCapacity);
//    }
//
//    public MyHashSet(Collection<? extends E> c){
//
//    }
//
//    //too access which list it is in u use o.hashCode() % hashTAble.length
//
//    public MyHashSet(int initialCapacity){
//        ArrayList<ArrayList> hashTable = new ArrayList<>(initialCapacity);
//    }
//
//    private void growHashTable(){
//        //if(hashTable.size()/initialCapacity > loadFactor)
//            ArrayList<ArrayList> hashTable = new ArrayList<>(initialCapacity*2);
//        hashTable.ensureCapacity(initialCapacity*2);
//    }
//
//    public Iterator<E> iterator(){
//
//    }
//
//    //just callimg the methods from hashTable (arrayList) might not work because it contains lists so not sure
//    //if will just check the content of the list itself
//    public int size(){
//        return hashTable.size();
//    }
//
//    public boolean isEmpty(){
//        return hashTable.isEmpty();
//    }
//
//    public boolean contains(Object o){
//        return hashTable.contains(o);
//    }
//
//    public boolean add(Object o){
//        return false;
//    }
//
//    public boolean remove(Object o){
//        return false;
//    }
//
//    public void clear(){
//        hashTable = new ArrayList<List>();
//    }
//
//    public Object clone(){
//        return null;
//    }
//
//
//
////    @Override
////    public String toString(){
////        return "First name: " + firstName + "\n" +
////                "Last name: " + lastName + "\n" +
////                "Is male: " + isMale + "\n" +
////                "Birth year: " + yearOfBirth + "\n";
////    }
////
////    @Override
////    public boolean equals(Object o) {
////        if (this == o) return true;
////        if (!(o instanceof Person)) return false;
////        Person person = (Person) o;
////        return isMale == person.isMale && yearOfBirth == person.yearOfBirth && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName);
////    }
////
////
////    @Override
////    public int hashCode(){
////        int result = 1;
////        result = result * 31 + firstName.hashCode();
////        result = result * 31 + lastName.hashCode();
////        if (isMale){result = result * 1231+31;}
////        else {result = result * 1237+31;}
////        result = result * 31 + yearOfBirth;
////        return result;
////
////    }
//
//}
