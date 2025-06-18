package algorithms.experienced;

/**
 * * For expression evaluation; such as 3*(4+5)
 */

import java.util.Stack;

public class Stack_ExpressionEvaluator {

    // Method to evaluate infix expressions using stacks
    public static int evaluateExpression(String expression) {
        Stack<Integer> values = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            // Skip spaces
            if (c == ' ') continue;

            // If the character is a digit, read the full number
            if (Character.isDigit(c)) {
                int num = 0;
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    num = num * 10 + (expression.charAt(i) - '0');
                    i++;
                }
                i--; // Move back to process correctly
                values.push(num);
            }
            // If it's an opening bracket, push to operators stack
            else if (c == '(') {
                operators.push(c);
            }
            // If it's a closing bracket, solve the entire bracket
            else if (c == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    values.push(applyOperation(operators.pop(), values.pop(), values.pop()));
                }
                operators.pop(); // Remove '('
            }
            // If it's an operator, process based on precedence
            else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(c)) {
                    values.push(applyOperation(operators.pop(), values.pop(), values.pop()));
                }
                operators.push(c);
            }
        }

        // Apply remaining operations
        while (!operators.isEmpty()) {
            values.push(applyOperation(operators.pop(), values.pop(), values.pop()));
        }

        return values.pop(); // Final result
    }

    // Method to define operator precedence
    private static int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }

    // Method to apply an operator to two values
    private static int applyOperation(char op, int b, int a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) throw new ArithmeticException("Division by zero");
                return a / b;
        }
        return 0;
    }

    public static void main(String[] args) {
        String expression = "3 * (4 + 5)";  // Example expression
        int result = evaluateExpression(expression);
        System.out.println("Result: " + result); // Output: 27
    }
}

