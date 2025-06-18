package basic.concurrency.thread.lifecycle;

/**
 * Occur when two or more threads are blocked forever, waiting for each other to release resources
 * Solution:
 * Avoid nested locks
 * Use a lock ordering strategy.
 * use tryLock() with ReentrantLock to avoid indefinite waiting
 */
public class Deadlocks {
}
