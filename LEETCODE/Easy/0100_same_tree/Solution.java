/**
 * Definition for a binary tree node.
 * */
   class TreeNode {
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Case 1: Both trees are empty -> same
        if (p == null && q == null) {
            return true;
        }

        // Case 2: One tree is empty, the other is not -> different
        if (p == null || q == null) {
            return false;
        }

        // Case 3: Values don't match -> different
        if (p.val != q.val) {
            return false;
        }

        // Recursive check: both left and right subtrees must match
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
