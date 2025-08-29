// 853. Car Fleet
// Problem: https://leetcode.com/problems/car-fleet/
// Medium difficulty
// 
// Approach:
// 1. Each car is represented by its position and the time it will take to reach the target.
// 2. We sort the cars by their starting position in descending order (closer to target first).
// 3. Use a stack to simulate fleets:
//    - If a car catches up with the fleet in front before reaching the target, it merges into that fleet.
//    - Otherwise, it forms a new fleet.
// 4. The size of the stack at the end gives the number of fleets.

import java.util.*;

class Solution {
    // Inner class to represent each car with its position and time to reach target
    class Car {
        int pos;       // position of the car
        double time;   // time needed to reach the target

        public Car(int pos, double time) {
            this.pos = pos;
            this.time = time;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        List<Car> cars = new ArrayList<>();

        // Step 1: Calculate time for each car to reach the target
        for (int i = 0; i < position.length; i++) {
            double time = (double) (target - position[i]) / speed[i];
            cars.add(new Car(position[i], time));
        }

        // Step 2: Sort cars by position in descending order (closer to target first)
        cars.sort((a, b) -> Integer.compare(b.pos, a.pos));

        // Step 3: Use stack to keep track of fleets
        Stack<Double> fleets = new Stack<>();

        for (Car c : cars) {
            // If stack is empty, this car definitely forms a fleet
            if (fleets.isEmpty()) {
                fleets.push(c.time);
            } 
            // If this car takes more time than the fleet ahead, it forms a new fleet
            else if (fleets.peek() < c.time) {
                fleets.push(c.time);
            }
            // Else: this car merges into the fleet ahead, so we ignore it
        }

        // Step 4: The number of fleets is the stack size
        return fleets.size();
    }
}
