package by.aston.livecoding.multithreading;

import java.util.ArrayList;
import java.util.List;

public class Line {
    public static void main(String[] args) {
        String input = "Иван,28,Инженер;Олег,34,HR;Денис,45,Маркетинг;Анна,30,Инженер;Борис,24,HR";
        String[] employees = input.split(";");
        List<Integer> ages = new ArrayList<>();

        for (int i = 0; i < employees.length; i++) {
            String[] emp = employees[i].split(",");
            ages.add(Integer.valueOf(emp[1]));
        }

        ages.stream().mapToInt(value -> value).average();
        ages.stream().min(Integer::compareTo).get();
        ages.stream().mapToInt(value -> value).average();
        ages.stream().min(Integer::compareTo).get();
    }
}
