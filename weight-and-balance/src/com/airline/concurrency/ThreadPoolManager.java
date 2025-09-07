package com.airline.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Manages a thread pool for executing tasks like load calculations.
 */
public class ThreadPoolManager {

    private final ExecutorService executor;

    public ThreadPoolManager(int poolSize) {
        this.executor = Executors.newFixedThreadPool(poolSize);
    }

    public <T> Future<T> submitTask(java.util.concurrent.Callable<T> task) {
        return executor.submit(task);
    }

    public void shutdown() {
        executor.shutdown();
    }
}