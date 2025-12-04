class Solution {
    public int countCollisions(String directions) {
        int collisions = 0;
        int left = 0;
        int right = directions.length() - 1;
        int len = directions.length();

        // Skip all left-moving cars at the beginning → they never collide
        while (left < len && directions.charAt(left) == 'L') {
            left++;
        }

        // Skip all right-moving cars at the end → they never collide
        while (right >= 0 && directions.charAt(right) == 'R') {
            right--;
        }

        // All remaining non-'S' cars in the middle section will collide
        for (int i = left; i <= right; i++) {
            if (directions.charAt(i) != 'S') {
                collisions++;
            }
        }

        return collisions;
    }
}
