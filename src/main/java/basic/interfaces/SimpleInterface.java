package basic.interfaces;

/**
 * public is redundant
 */
public interface SimpleInterface {
    /**
     * constants
     * implicit public. no other Modifiers allowed.
     */
    //declare constant: implicit public ; final is redundant;
    int MAX_VALUE = 200;

    //define static method
    static void sayHello(String name) {
        System.out.println("Hello " + name);
    }

    //define static method
    static void sayHello2(String name) {
        System.out.println("Hello " + name);
    }

    //define default methods
    default void display(String message) {
        System.out.println(message);
    }

    //define default method
    default void display2(String message) {
        System.out.println(message);
    }

    //declare abstract method
    void doSomething(String taskName);
}
