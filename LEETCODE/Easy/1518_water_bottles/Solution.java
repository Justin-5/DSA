class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        // Total bottles we can drink
        int drankBottles = numBottles;
        
        // Track how many empty bottles we currently have
        int emptyBottles = numBottles;
        
        // Continue exchanging while enough empty bottles are available
        while (emptyBottles >= numExchange) {
            // Number of new bottles we get after exchange
            int newBottles = emptyBottles / numExchange;
            
            // Drink these new bottles
            drankBottles += newBottles;
            
            // Update empty bottles: leftover + new empty after drinking
            emptyBottles = (emptyBottles % numExchange) + newBottles;
        }
        
        return drankBottles;
    }
}
