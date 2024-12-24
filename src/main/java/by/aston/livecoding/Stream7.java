package by.aston.livecoding;

import java.util.Comparator;
import java.util.List;

public class Stream7 {
    public static void main(String[] args) {

        //выполнить сортировку по фамилии в обратном порядке, затем по имени,
        //взять тех, кто старше 30 лет
        Comparator<PersonRecord> personRecordComparator = (o1, o2) -> o2.fullName().split(" ")[1]
                .compareTo(o1.fullName().split(" ")[1]);
        getPersonList().stream()
                .sorted(personRecordComparator)
                .forEach(System.out::println);
    }

    private static List<PersonRecord> getPersonList(){
        PersonRecord p1 = new PersonRecord(1, "John Smith", 40);
        PersonRecord p2 = new PersonRecord(2, "Jack Daniels", 35);
        PersonRecord p3 = new PersonRecord(3, "Sam Smith", 15);
        PersonRecord p4 = new PersonRecord(4, "Tom Holland", 25);
        PersonRecord p5 = new PersonRecord(5, "Tom Cruise", 60);

        return List.of(p1, p2, p3, p4, p5);
    }
}

record PersonRecord(long personId,
                    String fullName, int age) {
}
