package by.aston.livecoding.datastructures;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MapNullCapability<T> {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put(null, "value1"); // Допустимо
        map.put("key1", null);   // Допустимо

        Map<String, String> map2 = new LinkedHashMap<>();
        map2.put(null, "value1"); // Допустимо
        map2.put("key1", null);   // Допустимо

        Map<String, String> map3 = new TreeMap<>();
        map3.put("key1", null);   // Допустимо
        map3.put(null, "value1"); // NullPointerException

        Map<String, String> map4 = new Hashtable<>();
        map4.put("key1", null);   // NullPointerException
        map4.put(null, "value1"); // NullPointerException

        Map<String, String> map5 = new ConcurrentHashMap<>();
        map5.put("key1", null);   // NullPointerException
        map5.put(null, "value1"); // NullPointerException

        enum MyEnum { KEY1, KEY2 }
        Map<MyEnum, String> map6 = new EnumMap<>(MyEnum.class);
        map6.put(MyEnum.KEY1, null); // Допустимо
        map6.put(null, "value1");    // NullPointerException

        Map<String, String> map7 = new IdentityHashMap<>();
        map7.put(null, "value1"); // Допустимо
        map7.put("key1", null);   // Допустимо

        Map<String, String> map8 = new WeakHashMap<>();
        map8.put(null, "value1"); // Допустимо
        map8.put("key1", null);   // Допустимо
        /*
        Итоговая таблица
        Реализация	        Ключ null	Значение null
        HashMap	            Да	        Да
        LinkedHashMap	    Да	        Да
        TreeMap	            Нет	        Да
        Hashtable	        Нет	        Нет
        ConcurrentHashMap	Нет	        Нет
        EnumMap	            Нет	        Да
        IdentityHashMap	    Да	        Да
        WeakHashMap	        Да	        Да

         */
    }
}
