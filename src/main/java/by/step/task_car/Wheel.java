package by.step.task_car;
// Абстрактный класс для колеса
public abstract class Wheel {
    protected String name;
    protected int diameter; // диаметр в дюймах
    protected Season season;

    public Wheel(String name, int diameter, Season season) {
        this.name = name;
        this.diameter = diameter;
        this.season = season;
    }

    public String getName() {
        return name;
    }

    public int getDiameter() {
        return diameter;
    }

    public Season getSeason() {
        return season;
    }
}
