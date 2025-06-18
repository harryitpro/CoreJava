package basic.concurrency.thread.lifecycle;

import basic.concurrency.thread.Counter;

//demo how to interrupt a running thread while it's in blocked state
public class ThreadInterrupt {

    public static void interruptThread() {
        Thread counterIncrementThread = new Thread(() -> new Counter().increment());
        counterIncrementThread.start();

        pauseMainThread(2000);

        counterIncrementThread.interrupt();
        /**
         * output:
         * Thread-0 is sleeping for 5 seconds.
         * Thread-0 get interrupted
         */
    }

    static void pauseMainThread(int i) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            //
        }
    }

    public static void main(String[] args) {
        interruptThread();
    }
}
