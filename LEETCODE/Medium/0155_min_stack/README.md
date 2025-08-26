# 155. Min Stack

## 📝 Problem Statement

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the **MinStack** class:

- `MinStack()` initializes the stack object.
- `void push(int val)` pushes the element `val` onto the stack.
- `void pop()` removes the element on the top of the stack.
- `int top()` gets the top element of the stack.
- `int getMin()` retrieves the minimum element in the stack.

You must implement a solution with **O(1)** time complexity for each function.

---

## ✅ Example

**Input**
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

**Output**
[null,null,null,null,-3,null,0,-2]

**Explanation**
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top(); // return 0
minStack.getMin(); // return -2

---

## 🔒 Constraints

- `-2^31 <= val <= 2^31 - 1`
- Methods `pop`, `top` and `getMin` will always be called on non-empty stacks.
- At most `3 * 10^4` calls will be made to push, pop, top, and getMin.

---

## 💡 Approach

We use **two stacks**:

1. **Main stack (`stk`)** → stores all elements.
2. **Min stack (`minStk`)** → stores the minimum value at each stage.

### Logic:

- On `push(val)`:
  - Always push to `stk`.
  - Push to `minStk` if it’s empty OR `val <= currentMin`.
- On `pop()`:
  - Pop from `stk`.
  - If popped value equals `minStk.top()`, also pop from `minStk`.
- On `top()`: Return `stk.top()`.
- On `getMin()`: Return `minStk.top()`.

This ensures **O(1)** for all operations.

---

## 🧩 Code (Java)

```java
import java.util.Stack;

class MinStack {
    Stack<Integer> stk;
    Stack<Integer> minStk;

    public MinStack() {
        stk = new Stack<>();
        minStk = new Stack<>();
    }

    public void push(int val) {
        stk.push(val);
        if (minStk.isEmpty() || val <= minStk.peek()) {
            minStk.push(val);
        }
    }

    public void pop() {
        int stkTop = stk.peek();
        stk.pop();
        if (stkTop == minStk.peek()) {
            minStk.pop();
        }
    }

    public int top() {
        return stk.peek();
    }

    public int getMin() {
        return minStk.peek();
    }
}
🚀 Complexity Analysis
Time Complexity:

push → O(1)

pop → O(1)

top → O(1)

getMin → O(1)

Space Complexity: O(n), where n = number of elements in the stack (extra space for minStk).

```
