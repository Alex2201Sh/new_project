package by.step.task_animals;

// Класс Собака наследуется от Animal и реализует Soundable
class Dog extends Animal implements Soundable {
    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age); // Вызов конструктора родительского класса
        this.breed = breed;
    }

    // Реализация абстрактного метода
    @Override
    public void eat() {
        System.out.println(name + " кушает корм для собак");
    }

    // Реализация метода интерфейса
    @Override
    public void makeSound() {
        System.out.println(name + " говорит: Гав-гав!");
    }

    // Свой собственный метод
    public void fetch() {
        System.out.println(name + " приносит палку");
    }
}
