package basic.concurrency.thread.lifecycle;

/**
 * Thread Static method. to pause thread to stop for a certain amount of time
 * the InterruptedException is a Checked Exception, must be handled with try/catch block or declared in the signature. otherwise will cause compilation error if not
 * <p>
 * When Thread.sleep(long millis) or Thread.sleep(long millis, int nanos) is called:
 * <p>
 * The thread moves from the RUNNABLE state to the TIMED_WAITING state.
 * It remains in TIMED_WAITING for the duration specified in the sleep() call (in milliseconds or milliseconds + nanoseconds).
 * While in this state, the thread is not consuming CPU resources—it’s effectively paused, allowing other threads to run.
 * Once the sleep duration expires (or if the thread is interrupted), the thread returns to the RUNNABLE state, where it becomes eligible to resume execution.
 * <p>
 * Key Characteristics of TIMED_WAITING with sleep():
 * The thread does not release any locks/monitors it holds (unlike wait(), which releases the monitor).
 * If the thread is interrupted (via interrupt()), it exits the TIMED_WAITING state early, throws an
 */
public class ThreadSleep {
    public void sleep() {
        try {
            //thread moves from the RUNNABLE state to the TIMED_WAITING state
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted: " + e.getMessage());
        }
    }
}
