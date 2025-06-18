package basic.functionalprogramming.LambdaExpression;

import java.util.concurrent.Callable; // Keep if checked exception might be thrown
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier; // Consider using Supplier if no checked exceptions
import java.util.function.UnaryOperator;

/**
 * A lambda expression can be used to implement any functional interface. Common examples include:
 * <p>
 * Runnable (no parameters, no return value)
 * Callable<V> (no parameters, returns a value)
 * Supplier<T> (no parameters, returns a value)
 * Consumer<T> (accepts a parameter, no return value)
 * Function<T, R> (accepts a parameter, returns a value)
 */
public class FunctionalInterfaces {
    //one input, one output -- typical Function definition

    /**
     * input: None
     * output: void
     * represent an action
     */
    public static Runnable task = () -> System.out.println("this is an Runnable implementation");

    /**
     * input: None
     * output: One
     * Using Callable if a checked exception might be thrown.
     * Otherwise, Supplier is often more appropriate for simple value provision.
     */
    public static Callable<String> taskResultCallable = () -> "job completed"; // Renamed to clarify

    /**
     * input: None
     * output: One
     * Use Supplier if no checked exceptions are expected.
     */
    public static Supplier<String> taskResultSupplier = () -> "job completed"; // Added for comparison

    /**
     * Input: One
     * Output: One output
     */
    public static Function<String, Integer> getStringSizeFunction = s -> (s == null) ? 0 : s.length();
    // Simplified lambda body, added null check for robustness

    /**
     * Input: One
     * Output: One, boolean.
     * Predicate seems like a specialization of Function.
     */
    public static Predicate<String> isLongString = s -> s.length() > 5;
    // Made static for consistency with other members

    /**
     * Input: One
     * Output: One, the same type.
     * UnaryOperator<T> can be regarded as a specialization of Function<T, R>
     */
    public static UnaryOperator<String> reverseString = s -> new StringBuilder(s).reverse().toString();
    // Simplified lambda body

    public static void main(String[] args) {
        String s = "this is a string";
        System.out.println(reverseString.apply(s)); // Output: gnirts a si siht

        System.out.println("String size of 'hello': " + getStringSizeFunction.apply("hello")); // Output: 5
        System.out.println("String size of null: " + getStringSizeFunction.apply(null));       // Output: 0 (or whatever null handling chosen)
        System.out.println("Is 'programming' a long string? " + isLongString.test("programming")); // Output: true
        System.out.println("Is 'code' a long string? " + isLongString.test("code"));               // Output: false

        // Executing Runnable
        task.run(); // Output: this is a Runnable implementation

        // Getting value from Callable
        try {
            System.out.println("Callable result: " + taskResultCallable.call()); // Output: job completed
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Getting value from Supplier
        System.out.println("Supplier result: " + taskResultSupplier.get()); // Output: job completed
    }

}