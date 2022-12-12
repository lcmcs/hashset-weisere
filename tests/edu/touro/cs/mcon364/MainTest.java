package edu.touro.cs.mcon364;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;
class MainTest {
        MyHashSet set;

    public MainTest(){
        set = new MyHashSet();
        set.add("a");
        set.add("b");
        set.add("c");
    }

    @Test
    void iterator(){
        HashSet set2 = new HashSet<>();
        for (String s:set) {
            assertTrue(set2.add(s));
        }
        //asserts that iterated through all element and that no elements were left out
        assertTrue(set2.containsAll(set));
        assertEquals(set.size(),set2.size());
    }

    @Test
    void size(){
        assertEquals(3, set.size());
        set.add("d");
        assertEquals(4, set.size());
        set.remove("a");
        set.remove("b");
        assertEquals(2, set.size());
    }

    @Test
    void contains(){
        assertTrue(set.contains("b"));
        set.remove("b");
        assertFalse(set.contains("b"));
    }

    @Test
    void addAndGrow(){
        MyHashSet set1 = new MyHashSet(4);
        set1.add("q");
        set1.add("w");
        //added length method for testing purposes
        assertEquals(4,set1.length());
        set1.add("e");
        set1.add("r");
        //once fourth element is added it will reach load factor and should double the size
        //of the array and still contain everything that was in it
        assertEquals(8,set1.length());
        assertTrue(set1.contains("q"));
        assertTrue(set1.contains("w"));
        assertTrue(set1.contains("e"));
        assertTrue(set1.contains("r"));

    }

    @Test
    void remove(){
        set.remove("c");
        assertFalse(set.contains("c"));
    }

    @Test
    void isEmptyAndClear(){
        assertFalse(set.isEmpty());
        set.clear();
        assertTrue(set.isEmpty());
    }

    @Test
    void toArray(){
        Object[] example;
        example = set.toArray();
        for (Object o: example){
            assertTrue(set.contains(o));
        }
        assertEquals(example.length, set.size());
    }
}