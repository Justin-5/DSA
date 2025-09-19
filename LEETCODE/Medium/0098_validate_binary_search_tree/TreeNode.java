/**
 * Definition for a binary tree node.
 * */
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      @SuppressWarnings("unused")
      TreeNode() {}
      @SuppressWarnings("unused")
      TreeNode(int val) { this.val = val; }
      @SuppressWarnings("unused")
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 
@SuppressWarnings("unused")
class Solution {

    // Helper function to check validity of subtree with bounds
    public boolean isValidSubTree(TreeNode t, long min, long max) {
        // Base case: null nodes are valid
        if (t == null) {
            return true;
        }

        // Node must lie strictly between min and max
        if (t.val <= min || t.val >= max) {
            return false;
        }

        // Left subtree: values < t.val
        // Right subtree: values > t.val
        return isValidSubTree(t.left, min, t.val) &&
               isValidSubTree(t.right, t.val, max);
    }

    // Main function
    public boolean isValidBST(TreeNode root) {
        long min = Long.MIN_VALUE; // minimum possible value
        long max = Long.MAX_VALUE; // maximum possible value

        return isValidSubTree(root, min, max);
    }
}
