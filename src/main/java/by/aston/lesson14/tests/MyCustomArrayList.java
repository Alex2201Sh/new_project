package by.aston.lesson14.tests;

import java.util.ArrayList;
import java.util.List;

public class MyCustomArrayList {
    private List arrayList = new ArrayList();

    public boolean add(Object o) {
        return arrayList.add(o);
    }

    public int size(){
        return arrayList.size();
    }

    public void deleteByIndex(int i) {

    }
}
