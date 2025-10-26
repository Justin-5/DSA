
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;

        // Check if overall fuel is enough
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if (totalGas < totalCost) {
            return -1;
        }

        int curTank = 0;
        int startIndex = 0;

        // Find the valid start station
        for (int i = 0; i < gas.length; i++) {
            curTank += gas[i] - cost[i];
            if (curTank < 0) {
                startIndex = i + 1;
                curTank = 0;
            }
        }
        return startIndex;
    }
}
