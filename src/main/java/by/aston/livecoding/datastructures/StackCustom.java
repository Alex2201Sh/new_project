package by.aston.livecoding.datastructures;

import java.util.Stack;

public class StackCustom<T extends Comparable> {
    //создать кастомную реализацию стека с получением
    //минимального элемента за константное время

    public static void main(String[] args) {
//        StackCustom<Integer> integerStackCustom = new StackCustom<>();
//        integerStackCustom.push(3);
//        integerStackCustom.push(5);
//        integerStackCustom.push(10);
//        integerStackCustom.push(3);
//        integerStackCustom.push(1);
//        integerStackCustom.push(2);
//        integerStackCustom.push(7);
//        integerStackCustom.pop();
//        System.out.println(integerStackCustom.getMin());
//        integerStackCustom.pop();
        StackCustom<Person> personStackCustom = new StackCustom<>();
        personStackCustom.push(new Person(10,"Petr"));
        personStackCustom.push(new Person(30,"Ivan"));
        personStackCustom.push(new Person(3,"Ivan"));
        personStackCustom.push(new Person(25,"Dima"));
        personStackCustom.push(new Person(9,"Viva"));
        personStackCustom.push(new Person(1,"Vova"));
        for (int i = 0; i < 6; i++) {
            System.out.println(personStackCustom.getMin());
            personStackCustom.pop();
        }
    }

    public T getMin(){
//        return null; //TODO
        return stackMin.peek();
    }

//---------------------------Решение
    private Stack<T> stack = new Stack<>();
    private Stack<T> stackMin = new Stack<>();

    public T push(T x){
        if (stackMin.isEmpty()|| stackMin.peek().compareTo(x)>=0) {
            stackMin.push(x);
        }
        return stack.push(x);
    }

    public T pop(){
        if (stack.peek().equals(stackMin.peek())) {
            stackMin.pop();
        }
        return stack.pop();
    }
//---------------------------Конец решения

}

class Person implements Comparable {
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        return this.age - ((Person)o).getAge();
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
