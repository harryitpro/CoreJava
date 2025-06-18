package basic.inheritance;

public class ConstructorRunningOrder {
    static class A {
        A() {
            System.out.println("Constructor A");
        }
    }

    static class B extends A {
        B() {
            System.out.println("Constructor B");
        }
    }

    public static void main(String[] args) {
        B obj = new B();
        /**
         * output:
         * Constructor A
         * Constructor B
         */
    }
}
