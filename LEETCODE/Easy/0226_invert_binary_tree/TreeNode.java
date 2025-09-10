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
    public TreeNode invertTree(TreeNode root) {
        // Base case: empty tree
        if (root == null) {
            return null;
        }

        // Recursively invert left and right subtrees
        invertTree(root.left);
        invertTree(root.right);

        // Swap left and right children
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Return the root of the inverted tree
        return root;
    }
}
