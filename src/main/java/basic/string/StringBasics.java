package basic.string;


/**
 * String object is immutable.
 * string instance method:
 * concat()  --> generate a new String instance. keep existing instance unchanged.
 * equals()  : compare value. different than ==, which compare reference
 */
public class StringBasics {

    /**
     * String is Immutable!
     */
    public static void stringIsImmutable() {
        String str = "Hello";
        String newString = str.concat(" World");
        System.out.println(str); //Hello
        System.out.println(newString); //Hello World

    }

    static void stringObjectEquals() {
        String str1 = "Hello";
        String str2 = new String("Hello");  //new instance, will be difference reference
        System.out.println(str1 == str2);  //false
        System.out.println(str1.equals(str2)); //true/ check value
    }

    //A (String literals with the same value reference the same memory location)
    static void StringLiteralEquals() {
        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1 == s2); //true
    }

    /**
     * StringBuilder is mutable, meaning its contents can be modified without creating a new object.
     * The reverse() method modifies the current StringBuilder instance by reversing the characters.
     * It returns this, allowing method chaining.
     */
    static void stringBuilder() {
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World");
        sb.toString();
        System.out.println(sb); //Hello World
    }

    public static void main(String[] args) {
        stringIsImmutable();
        stringBuilder();
    }
}
