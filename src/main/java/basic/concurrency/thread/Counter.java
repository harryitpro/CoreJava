package basic.concurrency.thread;

public class Counter {
    private int count;
    private final int sleepInSeconds = 5;

    public int getCount() {
        return count;
    }

    public void increment() {
        try {
            Thread.sleep(sleepInSeconds * 1000);
            count++;
        } catch (InterruptedException e) {
            System.out.println("interrupted, skip operation");
        }
    }
}
