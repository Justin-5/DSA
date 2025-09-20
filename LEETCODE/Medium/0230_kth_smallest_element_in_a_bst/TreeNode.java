/**
 * Definition for a binary tree node.
 *  */
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
    private int count; // Tracks how many nodes left to visit before kth smallest
    private int res;   // Stores the result when found

    // Inorder traversal (Left -> Root -> Right)
    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }

        // Traverse left subtree
        inorder(node.left);

        // Visit current node
        count--; 
        if (count == 0) { 
            res = node.val; 
            return; 
        }

        // Traverse right subtree
        inorder(node.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inorder(root);
        return res;
    }
}
