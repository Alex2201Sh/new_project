package by.aston.lesson11;

//import org.example.model.Animal;
//import org.example.model.House;
//import org.example.model.Person;
//import org.example.util.Util;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExamples {
    public static void main(String[] args) throws IOException {
//        example1generateAndIterate();
//        example2builder();
//        example3filter();
//        example4mapVersusFlatMap();
//        example5sortedWithComparator();
//        example6forEachOrdered();
//        example7factorial();
//        example8animalsToMap();

    }

    private static void example1generateAndIterate() throws IOException {
        Stream.generate(() -> {
                    System.out.println("123");
                    return "hello";
                })
                .limit(5)
                .count();
        Stream.iterate(2, x -> x + 6).count();
        long count = Stream.iterate(2, x -> x < 25, x -> x + 6).count();
        System.out.println(count);
    }

    private static void example2builder() throws IOException {
        Stream.Builder<Integer> streamBuilder = Stream.<Integer>builder()
                .add(0)
                .add(1)
                .add(123);
        for (int i = 2; i <= 8; i += 2) {
            streamBuilder.accept(i);
        }
        streamBuilder.add(9).build().forEach(integer -> System.out.print(integer + " ")); // 0, 1, 2, 4, 6, 8, 9
    }

    private static void example3filter() throws IOException {
        Stream.of(1, 2, 3)
                .filter(x -> x == 10)
                .forEach(System.out::print);
        // Вывода нет, так как после фильтрации стрим станет пустым
        Predicate<Integer> integerPredicate = x -> x >= 50;
        Stream.of(120, 410, 85, 32, 314, 12)
                .filter(integerPredicate)
                .forEach(System.out::println);
//         120, 410, 314

//        Util.getAnimals()
//                .stream()
////                .filter(animal -> animal.getAge() >= 50)
//                .map(Animal::getAge)
//                .filter(integerPredicate)
//                .limit(2)
//                .forEach(System.out::println);

    }

    private static void example4mapVersusFlatMap() throws IOException {
//        List<House> houses = Util.getHouses();
//        Stream<Stream<Person>> streamStream = houses.stream().map(house -> house.getPersonList().stream());
////        [house1[person1,person2]][house2[person3,person4]]..
//        Stream<Person> personStream = houses.stream().flatMap(house -> house.getPersonList().stream());
////        [person1,person2,person3,person4]
    }

    private static void example5sortedWithComparator() throws IOException {
//        List<Animal> animals = Util.getAnimals();
//        Comparator<Animal> animalGenderComparator = (o1, o2) -> o1.getGender().compareTo(o2.getGender());
//        Comparator<Animal> animalTripleComparator = Comparator.comparingInt(Animal::getAge)
//                .thenComparing(Comparator.comparing(Animal::getOrigin)
//                        .thenComparing(Comparator.comparing(Animal::getBreed)));
//        animals.stream()
//                .sorted(animalTripleComparator)
////                .sorted(Comparator.comparingInt(Animal::getAge))
////                .sorted(Comparator.comparing(Animal::getOrigin))
////                .sorted(Comparator.comparing(Animal::getBreed))
////                .sorted(animalGenderComparator)
////                .sorted()
//                .limit(10)
//                .forEach(System.out::println);

    }

    private static void example6forEachOrdered() throws IOException {
        Date start = new Date();
        IntStream.range(0, 1000_000)
//                .parallel()
                .filter(x -> x % 10000 == 0)
                .map(x -> x / 10000)
                .forEachOrdered(System.out::println); // 5, 6, 7, 3, 4, 8, 0, 9, 1, 2
        Date end = new Date();
        System.out.println("time spent: " + (end.getTime() - start.getTime()));
    }

    private static void example7factorial() throws IOException {
        Date start = new Date();
        IntStream.rangeClosed(1000, 1010)
                .parallel()
                .mapToObj(x -> {
                    BigInteger result = BigInteger.valueOf(1);
                    for (int i = 1; i <= x; i++) {
                        result = result.multiply(BigInteger.valueOf(i));
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return result;
                })
                .forEach(System.out::println);
        Date end = new Date();
        System.out.println("time spent: " + (end.getTime() - start.getTime()));
    }

    private static void example8animalsToMap() throws IOException {
//        List<Animal> animals = Util.getAnimals();
//        Map<String, List<Animal>> collect = animals.stream().collect(Collectors.groupingBy(Animal::getGender));
//        System.out.println(collect);

    }


}