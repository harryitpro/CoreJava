package basic.concurrency.thread.lifecycle;

import basic.concurrency.thread.Counter;

/**
 * instance methods.
 * ensure that a thread finishes its task before the main program (or another thread) continues.
 * Purpose: It blocks the calling thread until the thread on which join() is called terminates.
 */
public class ThreadJoin {

    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread counterIncrementT1 = new Thread(() -> counter.increment());
        Thread counterIncrementT2 = new Thread(() -> counter.increment());
        counterIncrementT1.start();
        counterIncrementT2.start();
        try {
            counterIncrementT1.join();
            counterIncrementT2.join();
            System.out.println("all tasks have been completed");
        } catch (InterruptedException ex) {
            System.out.println("main thread interrupted");
        }
    }
}
