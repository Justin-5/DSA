import java.util.LinkedList;
import java.util.Queue;

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

    // Helper function to check if two trees are identical
    public boolean isIdentical(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true; // both empty -> same
        }
        if (s == null || t == null) {
            return false; // one empty, other not -> different
        }
        if (s.val != t.val) {
            return false; // value mismatch
        }
        // recursively check left and right subtrees
        return isIdentical(s.left, t.left) && isIdentical(s.right, t.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false; // empty root -> cannot contain subRoot
        }

        // BFS traversal over root
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.offer(root);

        while (!bfs.isEmpty()) {
            TreeNode curNode = bfs.poll();

            // Check if current node matches subRoot
            if (isIdentical(curNode, subRoot)) {
                return true;
            }

            // Add children to queue for traversal
            if (curNode.left != null) {
                bfs.offer(curNode.left);
            }
            if (curNode.right != null) {
                bfs.offer(curNode.right);
            }
        }

        return false; // no match found
    }
}
