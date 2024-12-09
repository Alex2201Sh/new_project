package by.aston.lesson7.linkedlist;

import java.util.Date;
import java.util.Objects;

public class Person {
    private String name;
    private Date lastDate;

    public Person(String name) {
        this.name = name;
        this.lastDate = new Date();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Person person = (Person) object;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
