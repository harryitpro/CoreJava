package basic.inheritance;

/**
 * Constructor Basics:
 * Constructors are not inherited by subclasses, but the subclass can invoke the superclass constructor explicitly or implicitly.
 * <p>
 * Key Rules to Remember
 * The call to super() or this() (if calling another constructor in the same class) must be the first statement in a constructor.
 * You cannot call both super() and this() in the same constructor.
 * If a superclass constructor throws an exception, the subclass constructor must handle it or declare it with throws.
 */
public class ConstructorConcept {
    //Parent class
    static class Parent {
        private String firstName;

        public Parent() {
        }

        public Parent(String name) {
            this.firstName = name;
        }

        public String getFirstName() {
            return firstName;
        }

        void show() throws Exception {
            System.out.println("Parent method, parent's first name is " + getFirstName());
        }
    }

    //child class
    static class Child extends Parent {
        private String lastName;

        public Child(String firstName, String lastName) {
            //call another constructor in the same class.
            this(firstName);
            //process other initialization
            this.lastName = lastName;
        }

        public Child(String firstName) {
            super(firstName);
        }

        /**
         * this method is still a VALID override, although it has no @Override, and not throw exception.
         * the rule is they should have the same method name, parameter and return data type.
         */
        void show() {
            System.out.println("Child method, child 'first name is " + getFirstName());
        }
    }

    public static void main(String[] args) throws Exception {
        Parent p = new Child("child", "parent");
        p.show();  //Child method.
    }
}
