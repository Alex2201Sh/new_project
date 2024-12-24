package by.aston.livecoding;

import java.util.Arrays;
import java.util.List;

public class Stream2 {
    /*
    Что будет результатом? (выбрать один)
a) 4, 0.0
b) 4, 190.0
c) 17, 0.0
d) 17, 190.0
     */
    public static void main(String[] args) {
        List<Order2> orders = Arrays.asList(
                new Order2(1, 50),
                new Order2(5, 70),
                new Order2(7, 70));
        Order2 order = orders.stream()
                .reduce(new Order2(4, 0), (p1, p2) -> new Order2(p1.orderId, p1.amount += p2.amount));
        System.out.print(order);
    }
}

class Order2 {
    long orderId;
    double amount;
    public Order2(long orderId, double amount) {
        this.orderId = orderId;
        this.amount = amount;
    }
    public String toString() {
        return orderId + ", " + amount ;
    }
}

