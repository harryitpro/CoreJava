package basic.exceptionhandling.checkedexception;

public class ThreadInterruptedException {
    //throw InterruptedException
    public void throwInterruptedException() throws InterruptedException {
        Thread.sleep(2000);
    }

    //RuntimeException is UnCheckedException, no need to add to signature or catch.
    public void catchCheckedException() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
