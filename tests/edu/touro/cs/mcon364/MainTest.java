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
    }
}