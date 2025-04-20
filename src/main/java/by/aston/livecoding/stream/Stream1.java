package by.aston.livecoding.stream;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

record Order(long orderId,
             double amount) {
}

public class Stream1 {
    /*
Что будет результатом? (выбрать один)
a) 70.0 50.0
b) 50.0 70.0 70.0
c) 1, 50.0 5, 70.0 7, 50.0
d) 5, 70.0 7, 50.0
e) ничего не будет выведено
     */
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        List<Order> orders = List.of(
                new Order(1, 50),
                new Order(5, 70),
                new Order(7, 70));
        Map<Double, List<Order>> collect = orders.stream()
                .collect(Collectors.groupingBy(Order::amount));
        collect.forEach((source, r) -> System.out.print(source + " "));
        System.out.println();
        HashMap<Double, Object> objectObjectHashMap = new HashMap<>(4);
        objectObjectHashMap.put(50.0, new Object());
        objectObjectHashMap.putAll(collect);
        objectObjectHashMap.forEach((source, r) -> System.out.print(source + " "));
        System.out.println();
        getNodes(collect);
        System.out.println();
        getNodes(objectObjectHashMap);
    }

    private static void getNodes(Map collect) throws NoSuchFieldException, IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredField("theUnsafe");
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);

// Получаем смещение поля в памяти
        long fieldOffset = unsafe.objectFieldOffset(
                HashMap.class.getDeclaredField("table")
        );

// Читаем значение
        Object[] object = (Object[]) unsafe.getObject(collect, fieldOffset);
        for (int i = 0; i < object.length; i++) {
            if (object[i] !=null){
                System.out.println(object[i].getClass().getSimpleName() + " " + object[i]);
            } else
                System.out.println("null");
        }
    }
}

