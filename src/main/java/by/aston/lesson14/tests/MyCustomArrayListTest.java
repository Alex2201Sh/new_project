package by.aston.lesson14.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class MyCustomArrayListTest {

    private MyCustomArrayList myCustomArrayList;

    @BeforeEach
    void init() {
        myCustomArrayList = new MyCustomArrayList();
    }


    @Test
    void testAddingObject() {
        int initSize = myCustomArrayList.size();
        myCustomArrayList.add(new Object());
        Assertions.assertEquals(initSize + 1,
                myCustomArrayList.size());
    }

    @Test
    @Disabled
    void testDeletingObject() {
        int initSize = myCustomArrayList.size();
        myCustomArrayList.deleteByIndex(0);
        Assertions.assertEquals(initSize -1,
                myCustomArrayList.size());
    }

}