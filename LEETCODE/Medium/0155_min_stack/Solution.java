import java.util.Stack;

class MinStack {
    // Main stack to store values
    Stack<Integer> stk;
    // Auxiliary stack to track minimums
    Stack<Integer> minStk;

    // Constructor initializes two stacks
    public MinStack() {
        stk = new Stack<>();
        minStk = new Stack<>();
    }

    // Push a value onto the stack
    public void push(int val) {
        stk.push(val);
        // If minStk is empty OR current value is <= min of stack, push it to minStk
        if (minStk.isEmpty()) {
            minStk.push(val);
        } else {
            int minTop = minStk.peek();
            if (val <= minTop) {
                minStk.push(val);
            }
        }
    }

    // Pop the top value from stack
    public void pop() {
        int stkTop = stk.peek();
        stk.pop();
        // If the popped value is the current minimum, pop from minStk too
        if (stkTop == minStk.peek()) {
            minStk.pop();
        }
    }

    // Get the top element
    public int top() {
        return stk.peek();
    }

    // Get the current minimum element in O(1) time
    public int getMin() {
        return minStk.peek();
    }
}

/**
 * Example usage:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * System.out.println(minStack.getMin()); // Output: -3
 * minStack.pop();
 * System.out.println(minStack.top());    // Output: 0
 * System.out.println(minStack.getMin()); // Output: -2
 */
