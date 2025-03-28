package by.aston.livecoding.datastructures;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        queue.poll();
        queue.offer(40);
        System.out.println(queue);
    }
}
