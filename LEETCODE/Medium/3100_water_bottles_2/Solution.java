class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        // Initially drink all the full bottles
        int drunkBottles = numBottles;
        int emptyBottles = numBottles;

        // Keep exchanging as long as possible
        while (emptyBottles >= numExchange) {
            // Spend "numExchange" empty bottles to get 1 full bottle
            emptyBottles -= numExchange;

            // Each time we exchange, the required number increases
            numExchange++;

            // Drink the new bottle
            drunkBottles++;

            // The new bottle becomes empty again
            emptyBottles++;
        }

        return drunkBottles;
    }
}
