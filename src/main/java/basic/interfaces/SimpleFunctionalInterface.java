package basic.interfaces;

@FunctionalInterface
public interface SimpleFunctionalInterface {
    void doSomething(String message);

    /**
     * only ONE abstract method is allowed in FunctionalInterface.
     * uncomment the Multiple  non-overriding abstract methods found
     */
//    void doSomething2(String message);

    int MAX_VALUE = 3;

    static void display(String message) {
        System.out.println(message);
    }

    static void display2(String message) {
        System.out.println(message);
    }

}
