package basic.executorframework;

import java.util.concurrent.*; // Import necessary concurrency classes
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class demonstrates the usage of Runnable, Callable, Executor, and ExecutorService
 * for managing concurrent tasks in Java.
 */
public class ConcurrencyDemo {

    // --- 1. Define a Runnable task ---
    // Runnable represents a task that can be executed by a thread.
    // It does not return any result and cannot throw checked exceptions.
    static class SimpleRunnableTask implements Runnable {
        private String taskName;

        public SimpleRunnableTask(String taskName) {
            this.taskName = taskName;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + ": Starting Runnable Task - " + taskName);
                // Simulate some work
                Thread.sleep(new Random().nextInt(500) + 100); // Sleep for 100-600 ms
                System.out.println(Thread.currentThread().getName() + ": Finished Runnable Task - " + taskName);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore the interrupted status
                System.err.println(Thread.currentThread().getName() + ": Runnable Task " + taskName + " interrupted.");
            }
        }
    }

    // --- 2. Define a Callable task ---
    // Callable represents a task that can be executed by a thread.
    // It returns a result of type V and can throw checked exceptions.
    static class SummingCallableTask implements Callable<Integer> {
        private String taskName;
        private int limit;

        public SummingCallableTask(String taskName, int limit) {
            this.taskName = taskName;
            this.limit = limit;
        }

        @Override
        public Integer call() throws Exception {
            System.out.println(Thread.currentThread().getName() + ": Starting Callable Task - " + taskName);
            int sum = 0;
            for (int i = 1; i <= limit; i++) {
                sum += i;
                // Simulate some work
                Thread.sleep(10); // Small delay
            }
            System.out.println(Thread.currentThread().getName() + ": Finished Callable Task - " + taskName + ", Sum = " + sum);
            return sum;
        }
    }

    public static void main(String[] args) {

        System.out.println("--- Demonstrating Executor (basic task execution) ---");
        // An Executor is a simple interface for executing Runnable tasks.
        // Executors.newSingleThreadExecutor() creates an ExecutorService that
        // uses a single worker thread operating off an unbounded queue.
        Executor singleThreadExecutor = Executors.newSingleThreadExecutor();

        // Submit a Runnable task to the single-thread executor
        singleThreadExecutor.execute(new SimpleRunnableTask("Executor-Task-1"));

        // Note: For a singleThreadExecutor obtained this way, you usually need
        // to cast it to ExecutorService to call shutdown().
        // For simple demos, if not managing a pool explicitly, this might be
        // sufficient, but for proper resource management, ExecutorService is preferred.
        // We will demonstrate proper shutdown with ExecutorService below.

        System.out.println("\n--- Demonstrating ExecutorService (thread pool management) ---");
        // An ExecutorService is a more comprehensive framework for asynchronous task execution.
        // It manages a pool of threads and queues for tasks.
        // Executors.newFixedThreadPool(int nThreads) creates a thread pool that reuses
        // a fixed number of threads for executing tasks.
        int corePoolSize = 3; // Number of threads in the pool
        ExecutorService executorService = Executors.newFixedThreadPool(corePoolSize);

        System.out.println("\n--- Submitting Runnable tasks to ExecutorService ---");
        // Use execute() for Runnable tasks. No return value.
        executorService.execute(new SimpleRunnableTask("Runnable-A"));
        executorService.execute(new SimpleRunnableTask("Runnable-B"));
        executorService.execute(new SimpleRunnableTask("Runnable-C"));
        executorService.execute(new SimpleRunnableTask("Runnable-D")); // This will be queued if all threads are busy

        System.out.println("\n--- Submitting Callable tasks to ExecutorService ---");
        List<Future<Integer>> futureResults = new ArrayList<>();

        // Use submit() for Callable tasks. It returns a Future object.
        futureResults.add(executorService.submit(new SummingCallableTask("Callable-X", 10)));
        futureResults.add(executorService.submit(new SummingCallableTask("Callable-Y", 20)));
        futureResults.add(executorService.submit(new SummingCallableTask("Callable-Z", 5)));

        System.out.println("\n--- Retrieving results from Callable tasks using Future ---");
        // Future allows you to check if the computation is complete,
        // wait for its completion, and retrieve the result.
        for (Future<Integer> future : futureResults) {
            try {
                // future.get() blocks until the computation is complete and retrieves the result.
                // It can throw InterruptedException or ExecutionException.
                Integer result = future.get();
                System.out.println("Retrieved result: " + result);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restore the interrupted status
                System.err.println("Main thread interrupted while waiting for task result.");
            } catch (ExecutionException e) {
                System.err.println("Task threw an exception: " + e.getCause());
            }
        }

        System.out.println("\n--- Shutting down ExecutorService ---");
        // It's crucial to shut down the ExecutorService when it's no longer needed
        // to prevent resource leaks and allow the program to exit.

        // Initiates an orderly shutdown in which previously submitted tasks are executed,
        // but no new tasks will be accepted.
        executorService.shutdown();

        // Shuts down the ExecutorService that was created for the basic Executor demo.
        // We cast it to ExecutorService to access the shutdown method.
        ((ExecutorService) singleThreadExecutor).shutdown();


        try {
            // Await termination for a certain period.
            // This waits for all submitted tasks to complete or for the timeout to occur.
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                System.err.println("Pool did not terminate in time. Forcing shutdown...");
                // Optionally, force shutdown if tasks don't complete
                executorService.shutdownNow();
            }
            if (!((ExecutorService) singleThreadExecutor).awaitTermination(60, TimeUnit.SECONDS)) {
                System.err.println("Single thread executor did not terminate in time. Forcing shutdown...");
                ((ExecutorService) singleThreadExecutor).shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Main thread interrupted during shutdown await.");
            executorService.shutdownNow(); // Cancel currently executing tasks
            ((ExecutorService) singleThreadExecutor).shutdownNow();
        }

        System.out.println("\nAll tasks submitted and ExecutorServices shut down.");
    }
}
