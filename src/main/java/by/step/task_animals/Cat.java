package by.step.task_animals;

// Класс Кошка наследуется от Animal и реализует Soundable
class Cat extends Animal implements Soundable {
    private boolean isIndoor;

    public Cat(String name, int age, boolean isIndoor) {
        super(name, age);
        this.isIndoor = isIndoor;
    }

    @Override
    public void eat() {
        System.out.println(name + " кушает корм для кошек");
    }

    @Override
    public void makeSound() {
        System.out.println(name + " говорит: Мяу!");
    }

    public void purr() {
        System.out.println(name + " мурлычет: Мрррр...");
    }
}
