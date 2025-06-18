package basic.exceptionhandling.uncheckedexception;

/**
 * ArrayIndexOutOfBoundsException is an unchecked Exception. it's a sub exception of RuntimeException
 * <p>
 * RuntimeException - IndexOutOfBoundsException - ArrayIndexOutOfBoundsException
 */
public class ArrayIndexOutOfBounds {
    static void demoArrayIndexOutOfBoundsException() {
        try {
            int[] arr = new int[5];
            arr[10] = 3;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index out of bounds : " + e.getMessage()); //Index out of bounds : Index 10 out of bounds for length 5
        } catch (Exception e) {
            System.out.println("Exception " + e.getMessage()); //not run
        }
    }

    public static void main(String[] args) {
        demoArrayIndexOutOfBoundsException();
    }
}
