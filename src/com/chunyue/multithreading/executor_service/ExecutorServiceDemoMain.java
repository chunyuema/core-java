package com.chunyue.multithreading.executor_service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceWithRunnableDemoMain {

    private static void executorServiceWithExecuteRunnable() {
        ExecutorService excutorService = Executors.newFixedThreadPool(10);

        excutorService.execute(new MyRunnable("Task 1"));
        excutorService.execute(new MyRunnable("Task 2"));
        excutorService.execute(new MyRunnable("Task 3"));
        excutorService.execute(new MyRunnable("Task 4"));
        excutorService.execute(new MyRunnable("Task 5"));
        excutorService.execute(new MyRunnable("Task 6"));

        excutorService.shutdown();
    }

    private static void executorServiceWithSubmitRunnable() {
        ExecutorService excutorService = Executors.newFixedThreadPool(2);
        Future future = excutorService.submit(new MyRunnable("Task 1"));
        System.out.println(future.isDone());
        try {
            // This will block until the task is done
            future.get();
        } catch (InterruptedException e) {
            // Left unhandled
        } catch (ExecutionException e) {
            // Left unhandled
        }
        System.out.println(future.isDone());
        excutorService.shutdown();
    }

    private static void executorServiceWithSubmitCallable() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future future = executorService.submit(new MyCallable("Task 1", 1000));

        System.out.println(future.isDone());
        try {
            String successToken = (String) future.get();
            System.out.println(successToken);
        } catch (InterruptedException e) {
            // Left unhandled
        } catch (ExecutionException e) {
            // Left unhandled
        }
        System.out.println(future.isDone());
        executorService.shutdown();
    }

    private static void excutorServiceInvokeAnyCallable() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<Callable<String>> myCallables = new ArrayList<>();
        myCallables.add(new MyCallable("Task 1", 1000));
        myCallables.add(new MyCallable("Task 2", 2000));
        myCallables.add(new MyCallable("Task 3", 3000));
        try {
            String successToken = (String) executorService.invokeAny(myCallables);
            System.out.println(successToken);
        } catch (InterruptedException e) {

        } catch (ExecutionException e) {

        }
        executorService.shutdown();
    }

    private static void excutorServiceInvokeAllCallable() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<Callable<String>> myCallables = new ArrayList<>();
        myCallables.add(new MyCallable("Task 1", 1000));
        myCallables.add(new MyCallable("Task 2", 2000));
        myCallables.add(new MyCallable("Task 3", 3000));
        try {
            List<Future<String>> futureSuccessTokens = executorService.invokeAll(myCallables);
            for (Future<String> future : futureSuccessTokens) {
                System.out.println(future.get());
            }
        } catch (InterruptedException e) {

        } catch (ExecutionException e) {

        }
        executorService.shutdown();
    }

    public static void main(String[] args) {
        // executorServiceWithExecuteRunnable();
        // executorServiceWithSubmitRunnable();
        // executorServiceWithSubmitCallable();
        // excutorServiceInvokeAnyCallable();
        // excutorServiceInvokeAllCallable();
    }
}
