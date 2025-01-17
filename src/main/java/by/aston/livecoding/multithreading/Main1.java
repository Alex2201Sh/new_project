package by.aston.livecoding.multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(() -> "some string");
        CompletableFuture<Integer> completableFuture2 = completableFuture1.thenApply(s -> s.length());

        Integer i = completableFuture2.get();
        System.out.println(i);

        Integer i1 = completableFuture2.thenApply(integer -> integer + 10).get();
        System.out.println(i1);
    }
}
