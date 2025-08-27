import java.util.Stack;

class Solution {
    /**
     * Daily Temperatures
     *
     * Given an array of daily temperatures, return an array where each index i
     * contains the number of days you must wait until a warmer temperature.
     * If no warmer temperature exists, the value remains 0.
     *
     * Approach:
     * - Use a monotonic decreasing stack to keep indices of unresolved temperatures.
     * - For each new day, resolve all previous colder days.
     * - Push current day's index into the stack.
     */
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> nextWarm = new Stack<>(); // stack stores indices
        int len = temperatures.length;
        int[] answer = new int[len]; // default initialized with 0s

        for (int i = 0; i < len; i++) {
            // While current temp is warmer than the top of stack's temp
            while (!nextWarm.isEmpty() && temperatures[nextWarm.peek()] < temperatures[i]) {
                int top = nextWarm.pop();
                answer[top] = i - top;  // number of days waited
            }
            // Add current day's index to stack
            nextWarm.push(i);
        }
        return answer;
    }
}
