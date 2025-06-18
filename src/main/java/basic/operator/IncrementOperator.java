package basic.operator;

public class IncrementOperator {
    public static void main(String[] args) {
        int x = 5;
        x += x++ + ++x;
        System.out.println(x); //17
   }

    /**
     * x += x++ + ++x, which is shorthand for x = x + (x++ + ++x).
     * In Java, the + operator is left-associative, so x++ + ++x is evaluated from left to right.
     * x++ is the post-increment operator: it uses the current value of x in the expression and then increments x.
     * ++x is the pre-increment operator: it increments x first and then uses the new value in the expression.
     */
}
