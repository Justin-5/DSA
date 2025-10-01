import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * */
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
@SuppressWarnings("unused")
 class Codec {

    // ------------------ SERIALIZATION ------------------
    // Helper method: performs preorder traversal (root -> left -> right)
    private void serialBuilder(TreeNode node, StringBuilder sb) {
        if (node == null) {
            // Represent null nodes explicitly
            sb.append("null").append(",");
            return;
        }
        // Add current node value
        sb.append(node.val).append(",");
        // Recurse left and right
        serialBuilder(node.left, sb);
        serialBuilder(node.right, sb);
    }

    // Converts tree into a string
    public String serialize(TreeNode root) {
        StringBuilder serializedTree = new StringBuilder();
        serialBuilder(root, serializedTree);
        return serializedTree.toString();
    }


    // ------------------ DESERIALIZATION ------------------
    // Helper method: builds tree from preorder string sequence
    private TreeNode buildTree(Queue<String> queue) {
        String value = queue.poll(); // Read next token

        // Null marker → no node
        if (value.equals("null")) {
            return null;
        }

        // Create current node
        TreeNode root = new TreeNode(Integer.parseInt(value));

        // Build left and right subtrees recursively
        root.left = buildTree(queue);
        root.right = buildTree(queue);

        return root;
    }

    // Converts string back into tree
    public TreeNode deserialize(String data) {
        String[] stringSplit = data.split(",");
        Queue<String> q = new LinkedList<>();

        // Push tokens into queue
        for (String s : stringSplit) {
            if (!s.isEmpty()) { // ignore trailing ""
                q.offer(s);
            }
        }

        return buildTree(q);
    }
}

// Usage Example:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
