
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int findFinalValue(int[] nums, int original) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        int val = original;
        while (set.contains(val)) {
            val *= 2;
        }

        return val;
    }
}
