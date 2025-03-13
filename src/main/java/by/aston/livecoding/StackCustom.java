package by.aston.livecoding;

import java.util.Stack;

public class StackCustom<T extends Comparable> {
    //создать кастомную реализацию стека с сохранением
    //минимального элемента

    public static void main(String[] args) {
        StackCustom<Integer> integerStackCustom = new StackCustom<>();
        integerStackCustom.push(3);
        integerStackCustom.push(5);
        integerStackCustom.push(10);
        integerStackCustom.push(3);
        integerStackCustom.push(1);
        integerStackCustom.push(2);
        integerStackCustom.push(7);
        integerStackCustom.pop();
        System.out.println(integerStackCustom.getMin());
        integerStackCustom.pop();
        System.out.println(integerStackCustom.getMin());
        integerStackCustom.pop();
        System.out.println(integerStackCustom.getMin());
        integerStackCustom.pop();
        System.out.println(integerStackCustom.getMin());
        integerStackCustom.pop();
        System.out.println(integerStackCustom.getMin());
        integerStackCustom.pop();
        System.out.println(integerStackCustom.getMin());
        integerStackCustom.pop();
        System.out.println(integerStackCustom.getMin());
        integerStackCustom.pop();
        System.out.println(integerStackCustom.getMin());
    }

    public T getMin(){
        return null; //TODO
    }

//---------------------------Решение
    private Stack<T> stack;
    private Stack<T> stackMin;

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
