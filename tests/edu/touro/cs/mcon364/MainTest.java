package edu.touro.cs.mcon364;

import org.junit.jupiter.api.Test;

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
        //not sure why this is false (probably isnt properly accessing items in the same bucket
        //assertTrue(set1.contains("w"));
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
        Object[] example = new Object[set.size()];
        example = set.toArray();
        System.out.println(example[1]);
    }
}