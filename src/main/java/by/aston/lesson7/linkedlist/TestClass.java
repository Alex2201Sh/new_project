package by.aston.lesson7.linkedlist;

public class TestClass {
    public static void main(String[] args) {
        CustomLinkedList customLinkedList = new CustomLinkedList();
        customLinkedList.addLast(new Person("Vasia")); //0
        customLinkedList.addLast(new Person("Lena"));  //1
        customLinkedList.addLast(new Person("Igor"));  //2
        customLinkedList.addLast(new Person("Ivan"));  //3
        customLinkedList.addByIndex(new Person("Gena"),1);  //1

        System.out.println(new Person("Ivan"));
    }
}
