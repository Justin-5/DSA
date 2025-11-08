import java.util.*;

class Solution {

    // Helper function to perform arithmetic based on the operator
    public int compute(int num1, int num2, String op) {
        if (op.equals("+")) return num1 + num2;
        if (op.equals("-")) return num1 - num2;
        if (op.equals("*")) return num1 * num2;
        if (op.equals("/")) return num1 / num2; // integer division truncates toward zero
        return 0;
    }

    @SuppressWarnings("UnnecessaryTemporaryOnConversionFromString")
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();

        for (String s : tokens) {
            // If it's a number, push it
            if (!s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/")) {
                stk.push(Integer.parseInt(s));
            } 
            // If it's an operator, pop two elements and compute
            else {
                int a = stk.pop(); // right operand
                int b = stk.pop(); // left operand
                int ans = compute(b, a, s);
                stk.push(ans);
            }
        }

        // The final result is the only remaining element
        return stk.pop();
    }
}
