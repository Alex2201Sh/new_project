package by.aston.livecoding.stream;

import java.util.List;

public class StreamWorkers {
    public static class Worker {

        String name;
        String position;
        Integer salary;

        public Worker(String name, String position, Integer salary) {
            this.name = name;
            this.position = position;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public String getPosition() {
            return position;
        }

        public Integer getSalary() {
            return salary;
        }
    }


    public static void main(String[] args) {
        List<Worker> workers = List.of(
                new Worker("Dan", "Developer", 100),
                new Worker("Maxim", "QA Tester", 50),
                new Worker("Sergey", "Manager", 100),
                new Worker("Vadim", "Developer", 130),
                new Worker("Denis", "QA Tester", 70),
                new Worker("Pavel", "Product Owner", 120)
        );

        // сумма которую платим всем
//        Integer sum =

        // сгруппировать людей по позициям
//        Map<String, List<Worker>> workersByPostion =


        // какую сумму мы платим каждому отделу
//        Map<String, Integer> salarySumByPostition =

        // Сколько людей занимают конкретную позицию
//        Map<String, Integer> countByPosition =

        // разделить сотрудников на тех кто получает больше 100 и меньше 100
//        Map<Boolean, List<Worker>> workersBySalaryCondition =

    }
}
