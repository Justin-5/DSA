class Solution {
    public long maxRunTime(int n, int[] batteries) {

        // Compute the total battery power available
        long sum = 0;
        for (int b : batteries) {
            sum += b;
        }

        // Binary search on possible running time per computer
        long low = 1;
        long high = sum / n; // Theoretical maximum runtime if power is perfectly balanced
        long ans = 0;

        while (low <= high) {
            long mid = low + (high - low) / 2; // Candidate runtime
            long totalPower = 0;

            // Compute usable power: battery contributes at most 'mid'
            for (int b : batteries) {
                totalPower += Math.min((long) b, mid);
            }

            // Feasibility check: enough power to run all n computers for 'mid' minutes
            if (totalPower >= (long) n * mid) {
                ans = mid;      // mid is possible → try for more
                low = mid + 1;
            } else {
                high = mid - 1; // mid is not possible → lower time
            }
        }
        return ans; // Maximum feasible runtime
    }
}
