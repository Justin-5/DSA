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
    private int maxSum = Integer.MIN_VALUE; // Track global max path sum

    // Recursive DFS to compute maximum contribution of each node
    private int findMaxSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // Compute max contribution from left and right subtrees
        int leftPathSum = Math.max(0, findMaxSum(root.left));
        int rightPathSum = Math.max(0, findMaxSum(root.right));

        // Update global max with path passing through current node
        int currentNodePathSum = root.val + leftPathSum + rightPathSum;
        maxSum = Math.max(maxSum, currentNodePathSum);

        // Return max path sum for parent usage (can only take one side)
        return root.val + Math.max(leftPathSum, rightPathSum);
    }

    public int maxPathSum(TreeNode root) {
        findMaxSum(root);
        return maxSum;
    }
}
