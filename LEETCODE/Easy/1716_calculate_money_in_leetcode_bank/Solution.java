

class Solution {
    /**
     * Calculates the total money saved after n days in the Leetcode bank.
     * Each Monday starts with 1 dollar more than the previous Monday,
     * and each subsequent day adds 1 more than the previous day.
     */
    public int totalMoney(int n) {
        // Number of complete weeks
        int fullWeeks = n / 7;
        // Remaining days after full weeks
        int remDays = n % 7;

        // Formula for the sum of full weeks (arithmetic progression)
        // Week 1 = 28, Week 2 = 35, Week 3 = 42, ...
        int sumOfFullWeeks = (fullWeeks * (2 * 28 + (fullWeeks - 1) * 7)) / 2;

        // Formula for remaining days (also arithmetic progression)
        // Starts from (1 + fullWeeks)
        int sumOfRemDays = (remDays * (2 * (1 + fullWeeks) + (remDays - 1))) / 2;

        // Total amount in bank
        return sumOfFullWeeks + sumOfRemDays;
    }
}
