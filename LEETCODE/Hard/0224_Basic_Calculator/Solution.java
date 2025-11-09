import java.util.Stack;

class Solution {
    public int calculate(String s) {
        Stack<Integer> stk = new Stack<>();
        int curSign = 1;   // Current sign (+1 or -1)
        int curResult = 0; // Current accumulated result

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                // Parse full number (can be multi-digit)
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = (num * 10) + (s.charAt(i) - '0');
                    i++;
                }
                curResult += num * curSign;
                i--; // Step back since loop will increment i
            } 
            else if (ch == '+') {
                curSign = 1;
            } 
            else if (ch == '-') {
                curSign = -1;
            } 
            else if (ch == '(') {
                // Push current result and sign before starting new sub-expression
                stk.push(curResult);
                stk.push(curSign);
                curResult = 0;
                curSign = 1;
            } 
            else if (ch == ')') {
                // Pop sign and previous result; combine with current sub-expression result
                int prevSign = stk.pop();
                int prevResult = stk.pop();
                curResult = prevResult + (prevSign * curResult);
            }
        }
        return curResult;
    }
}
