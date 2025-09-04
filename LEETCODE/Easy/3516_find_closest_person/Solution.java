// 3516. Find Closest Person
// Problem: https://leetcode.com/problems/find-closest-person/
//
// Approach:
// ----------------------------------
// 1. We are given positions of Person1 (x), Person2 (y), and Person3 (z).
// 2. Both Person1 and Person2 move toward Person3 at the same speed.
// 3. Whoever has the smaller distance to Person3 will reach first.
// 4. If both distances are equal, return 0.
//
// Time Complexity: O(1)  (just a few arithmetic operations)
// Space Complexity: O(1)
//
// Example:
// x = 2, y = 7, z = 4
// Distance P1 = |4-2| = 2
// Distance P2 = |4-7| = 3
// → Answer = 1 (Person1 is closer)

class Solution {
    public int findClosest(int x, int y, int z) {
        // Calculate absolute distances from Person3
        int p1Distance = Math.abs(z - x);
        int p2Distance = Math.abs(z - y);

        // If Person1 is closer
        if (p1Distance < p2Distance) {
            return 1;
        }
        // If Person2 is closer
        if (p1Distance > p2Distance) {
            return 2;
        }
        // If both are equally close
        return 0;
    }
}
