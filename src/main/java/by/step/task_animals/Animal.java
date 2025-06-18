package by.step.task_animals;

// Абстрактный класс Животное
abstract class Animal {
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Абстрактный метод - должен быть реализован в дочерних классах
    public abstract void eat();

    // Обычный метод с реализацией
    public void sleep() {
        System.out.println(name + " спит");
    }
}
