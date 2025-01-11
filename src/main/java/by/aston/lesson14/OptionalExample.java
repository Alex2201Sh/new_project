package by.aston.lesson14;

import by.aston.livecoding.clev.model.Animal;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        Optional<Animal> animalOptional = Optional.ofNullable(new Animal());
//        System.out.println(animalOptional.get());
        Optional<Animal> animalOptional2 = Optional.ofNullable(new Animal());
//        System.out.println(animalOptional2.orElseGet(() -> new Animal(1,"new",11,"Belarus","male")));

        Animal animal1 = null;

        if (animal1 != null) {
            System.out.println(animal1);
        } else {
            System.out.println(new Animal(1,"new",11,"Belarus","male"));
        }
//        System.out.println(animal1.getAge());
    }
}
