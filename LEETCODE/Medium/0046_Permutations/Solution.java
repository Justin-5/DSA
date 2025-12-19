import java.util.ArrayList;
import java.util.List;

class Solution {

    // Stores all generated permutations
    @SuppressWarnings("FieldMayBeFinal")
    private List<List<Integer>> res = new ArrayList<>();

    // Backtracking helper function
    public void backTrack(List<Integer> p, int[] n) {

        // If the permutation is complete, add a copy to result
        if (p.size() == n.length) {
            res.add(new ArrayList<>(p));
            return;
        }

        // Try adding each number that is not already used
        for (int i = 0; i < n.length; i++) {

            // Skip numbers already in the current permutation
            if (!p.contains(n[i])) {

                // Choose
                p.add(n[i]);

                // Explore
                backTrack(p, n);

                // Un-choose (backtrack)
                p.remove(p.size() - 1);
            }
        }
    }

    // Main function to generate permutations
    public List<List<Integer>> permute(int[] nums) {

        // Temporary list to store current permutation
        List<Integer> permutation = new ArrayList<>();

        // Start backtracking
        backTrack(permutation, nums);

        return res;
    }
}
