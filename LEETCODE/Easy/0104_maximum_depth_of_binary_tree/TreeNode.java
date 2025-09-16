/**
 * Definition for a binary tree node.
 * */
  public class TreeNode {
    @SuppressWarnings("unused")
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
    public int maxDepth(TreeNode root) {
        // Base case: if tree is empty, depth is 0
        if (root == null) {
            return 0;
        }

        // Recursively find depth of left and right subtrees
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // Return max depth + 1 for current root node
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
