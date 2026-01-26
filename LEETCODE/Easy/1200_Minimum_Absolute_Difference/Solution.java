import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        List<List<Integer>> res = new ArrayList<>();

        // Sort the array to bring close numbers together
        Arrays.sort(arr);

        int n = arr.length;
        int min = Integer.MAX_VALUE;

        // First pass: find the minimum absolute difference
        for (int i = 0; i < n - 1; i++) {
            min = Math.min(min, arr[i + 1] - arr[i]);
        }

        // Second pass: collect all pairs with that difference
        for (int i = 0; i < n - 1; i++) {
            if (arr[i + 1] - arr[i] == min) {
                List<Integer> pair = new ArrayList<>();
                pair.add(arr[i]);
                pair.add(arr[i + 1]);
                res.add(pair);
            }
        }

        return res;
    }
}
