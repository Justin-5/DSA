import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // Queue to perform BFS traversal
        Queue<TreeNode> bfs = new LinkedList<>();
        // Result list of levels
        List<List<Integer>> res = new ArrayList<>();

        // Edge case: empty tree
        if (root == null) {
            return res;
        }

        // Start with the root node
        bfs.offer(root);

        // Process nodes level by level
        while (!bfs.isEmpty()) {
            List<Integer> level = new ArrayList<>(); // stores values of current level
            int queueSize = bfs.size(); // number of nodes at this level

            // Process all nodes of the current level
            for (int i = 0; i < queueSize; i++) {
                TreeNode curNode = bfs.poll(); // dequeue node
                level.add(curNode.val); // add its value to current level list

                // Add children to queue for next level
                if (curNode.left != null) {
                    bfs.offer(curNode.left);
                }
                if (curNode.right != null) {
                    bfs.offer(curNode.right);
                }
            }

            // Add current level to result
            res.add(level);
        }

        return res;
    }
}
