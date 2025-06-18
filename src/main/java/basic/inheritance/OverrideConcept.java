package basic.inheritance;

/**
 * in Java, to override a method from a parent class, the method in the child class must have exactly the same method signature as the method in the parent class. This is a fundamental rule of method overriding in Java. Here's what "exactly the same signature" means:
 * <p>
 * Components of a Method Signature
 * Method Name: The name of the method in the child class must be identical to the method name in the parent class.
 * Parameter List: The method must have the same number, types, and order of parameters as the method in the parent class. This includes:
 * The same parameter types (no substitutions, even with subclasses or superclasses).
 * The same number of parameters.
 * Return Type: The return type must be the same as the return type in the parent class, or it can be a subtype (covariant return type) of the return type in the parent class (introduced in Java 5).
 * Additional Requirements for Overriding
 * Access Modifier: The access level of the overriding method in the child class must be the same or less restrictive than the access level of the method in the parent class. For example:
 * If the parent method is public, the child method must also be public.
 * If the parent method is protected, the child method can be protected or public.
 * Exceptions: The overriding method cannot throw checked exceptions that are broader (more general) than the exceptions declared in the parent class method. It can throw fewer or narrower exceptions, or none at all.
 * Annotations: The @Override annotation is not strictly required, but it is highly recommended to use it. This annotation ensures that the method is actually overriding a parent class method, and it helps catch errors at compile time if the signature does not match.
 */
public class OverrideConcept {



}

