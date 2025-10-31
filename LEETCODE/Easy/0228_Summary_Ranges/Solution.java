import java.util.*;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();
        int a = 0;  // start of range
        int b = 0;  // end of range
        int n = nums.length;

        while (b < n) {
            // Expand the range while consecutive numbers continue
            while (b + 1 < n && nums[b] + 1 == nums[b + 1]) {
                b++;
            }

            // If range has multiple elements
            if (a != b) {
                ranges.add(nums[a] + "->" + nums[b]);
            } 
            // Single number range
            else {
                ranges.add(String.valueOf(nums[a]));
            }

            // Move to next range
            b++;
            a = b;
        }

        return ranges;
    }
}
