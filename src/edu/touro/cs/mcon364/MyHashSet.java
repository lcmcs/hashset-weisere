package edu.touro.cs.mcon364;

import java.awt.*;
import java.util.ArrayList;

public class MyHashSet {
    private int initialCapacity = 16;
    ArrayList<List> hashTable = new ArrayList<>(initialCapacity);
    private float loadFactor = 0.75F;


    public MyHashSet(int initialCapacity, float loadFactor){
        this.loadFactor = loadFactor;
        ArrayList<List> hashTable = new ArrayList<>(initialCapacity);
    }

    public MyHashSet(Collection<? extends E> c){

    }

    public MyHashSet(int initialCapacity){
        ArrayList<List> hashTable = new ArrayList<>(initialCapacity);
    }

    private void growHashTable(){
        //if(hashTable.size()/initialCapacity > loadFactor)
            ArrayList<List> hashTable = new ArrayList<>(initialCapacity*2);
        hashTable.ensureCapacity(initialCapacity*2);
    }

    public Iterator<E> iterator(){

    }

    public int size(){
        return hashTable.size();
    }

    public boolean isEmpty(){
        return hashTable.isEmpty();
    }

    public boolean contains(Object o){
        return hashTable.contains(o);
    }

    public boolean add(Object o){
        return false;
    }

    public boolean remove(Object o){
        return false;
    }

    public void clear(){
        hashTable = new ArrayList<List>();
    }

    public Object clone(){
        return null;
    }



//    @Override
//    public String toString(){
//        return "First name: " + firstName + "\n" +
//                "Last name: " + lastName + "\n" +
//                "Is male: " + isMale + "\n" +
//                "Birth year: " + yearOfBirth + "\n";
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Person)) return false;
//        Person person = (Person) o;
//        return isMale == person.isMale && yearOfBirth == person.yearOfBirth && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName);
//    }
//
//
//    @Override
//    public int hashCode(){
//        int result = 1;
//        result = result * 31 + firstName.hashCode();
//        result = result * 31 + lastName.hashCode();
//        if (isMale){result = result * 1231+31;}
//        else {result = result * 1237+31;}
//        result = result * 31 + yearOfBirth;
//        return result;
//
//    }

}
