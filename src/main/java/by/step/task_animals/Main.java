package by.step.task_animals;

public class Main {
    public static void main(String[] args) {
        // Создание объектов
        Dog myDog = new Dog("Барсик", 3, "Лабрадор");
        Cat myCat = new Cat("Мурка", 5, true);

        // Вызов методов
        System.out.println("--- Работа с собакой ---");
        myDog.sleep();      // Метод из Animal
        myDog.eat();        // Реализация абстрактного метода
        myDog.makeSound(); // Метод из интерфейса
        myDog.fetch();      // Собственный метод Dog

        System.out.println("\n--- Работа с кошкой ---");
        myCat.sleep();      // Метод из Animal
        myCat.eat();        // Реализация абстрактного метода
        myCat.makeSound();  // Метод из интерфейса
        myCat.purr();      // Собственный метод Cat

        // Полиморфизм: работа через интерфейс
        System.out.println("\n--- Полиморфизм через интерфейс ---");
        Soundable[] pets = {myDog, myCat};
        for (Soundable pet : pets) {
            pet.makeSound();
        }

        // Полиморфизм: работа через абстрактный класс
        System.out.println("\n--- Полиморфизм через абстрактный класс ---");
        Animal[] animals = {myDog, myCat};
        for (Animal animal : animals) {
            animal.eat();
            animal.sleep();
        }
    }
}