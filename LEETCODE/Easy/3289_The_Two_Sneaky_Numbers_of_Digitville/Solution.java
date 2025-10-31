
class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int i = 0;
        int[] res = new int[2];
        int index = 0;

        // Cyclic sort approach
        while (i < nums.length) {
            int num = nums[i];

            // If number is already at its correct index, move ahead
            if (num == i) {
                i++;
            }
            // If number is not at its correct index and not duplicate, swap
            else if (num != nums[num]) {
                int temp = nums[i];
                nums[i] = nums[num];
                nums[num] = temp;
            }
            // If duplicate found, skip this index
            else {
                i++;
            }
        }

        // After sorting, collect the two numbers that are out of place
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j) {
                res[index++] = nums[j];
                if (index == 2)
                    break;
            }
        }

        return res;

        /*
        // Alternate HashSet method:
        int[] res = new int[2];
        Set<Integer> seen = new HashSet<>();
        int idx = 0;
        for (int num : nums) {
            if (seen.contains(num)) {
                res[idx++] = num;
                if (idx == 2) break;
            }
            seen.add(num);
        }
        return res;
        */
    }
}
