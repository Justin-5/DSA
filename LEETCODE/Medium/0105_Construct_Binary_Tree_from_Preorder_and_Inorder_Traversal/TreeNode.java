import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.
 */
public class TreeNode {
    @SuppressWarnings("unused")
    int val;
    @SuppressWarnings("unused")
    TreeNode left;
    @SuppressWarnings("unused")
    TreeNode right;
    @SuppressWarnings("unused")
    TreeNode() {}
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
    // Global index to track current root in preorder
    private int preIndex = 0;
    private int[] preorder;
    @SuppressWarnings({"unused", "FieldMayBeFinal"})
    private Map<Integer, Integer> inorderMap = new HashMap<>();

    /**
     * Recursive helper to build subtree from inorder range.
     */
    private TreeNode buildSubTree(int inorderLeft, int inorderRight) {
        // Base case: invalid range → no subtree
        if (inorderLeft > inorderRight) {
            return null;
        }

        // Step 1: Get root value from preorder
        TreeNode root = new TreeNode(preorder[preIndex]);

        // Step 2: Find root position in inorder
        int inIndex = inorderMap.get(preorder[preIndex]);

        // Step 3: Move preorder index forward
        preIndex++;

        // Step 4: Recursively build left and right subtrees
        root.left = buildSubTree(inorderLeft, inIndex - 1);
        root.right = buildSubTree(inIndex + 1, inorderRight);

        return root;
    }

    /**
     * Main function to build the tree from preorder & inorder.
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;

        // Build a hashmap for quick index lookup in inorder
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        // Build the whole tree
        return buildSubTree(0, inorder.length - 1);
    }
}
