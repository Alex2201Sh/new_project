package by.aston.codewars;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TaskMaster {

    static final Random random = new Random();

//    static int taskMaster(Collection<Callable<Integer>> functions) {
//        return functions.stream().parallel()
//                .mapToInt(value -> {
//                    try {
//                        return value.call();
//                    } catch (Exception e) {
//                        throw new RuntimeException(e);
//                    }
//                })
//                .sum();
//    }

    static int taskMaster(Collection<Callable<Integer>> functions)  {
        ExecutorService executorService = Executors.newFixedThreadPool(functions.size());
        try {
            return executorService.invokeAll(functions,15, TimeUnit.SECONDS)
                    .stream()
                    .mapToInt(value -> {
                        try {
                            return value.get();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        } catch (ExecutionException e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .sum();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            executorService.shutdown();
        }
    }

    static Callable<Integer> getFunction(long millis, int result) {
        return () -> {
            Thread.sleep(millis);
            return result;
        };
    }

    public static void main(String[] args) {
        var functions = new ArrayList<Callable<Integer>>();
        var functionA = getFunction(random.nextLong(1000, 2001), 3);
        for(int i=0; i < 10; i++)
            functions.add(functionA);
        var functionB = getFunction(random.nextLong(1000, 2001), 2);
        for(int i=0; i < 10; i++)
            functions.add(functionB);
        int expected = 50;;

        System.out.println(taskMaster(functions));
    }
}
