#include <stdio.h>
#include <stdlib.h>

// Definition for a binary tree node.
struct TreeNode {
    int val;
    struct TreeNode* left;
    struct TreeNode* right;
};

// Recursive helper to store inorder traversal
void inorder(struct TreeNode* root, int* result, int* i) {
    if (root == NULL)
        return;
    inorder(root->left, result, i);
    result[*i] = root->val;
    (*i)++;
    inorder(root->right, result, i);
}

// Helper to count number of nodes
void count(struct TreeNode* root, int* returnSize) {
    if (root == NULL)
        return;
    (*returnSize)++;
    count(root->left, returnSize);
    count(root->right, returnSize);
}

// Main inorder traversal function
int* inorderTraversal(struct TreeNode* root, int* returnSize) {
    *returnSize = 0;
    count(root, returnSize);
    int* result = (int*)malloc((*returnSize) * sizeof(int));
    int i = 0;
    inorder(root, result, &i);
    return result;
}

// Sample usage
int main() {
    // Example tree: [1, NULL, 2, 3]
    struct TreeNode n3 = {3, NULL, NULL};
    struct TreeNode n2 = {2, &n3, NULL};
    struct TreeNode n1 = {1, NULL, &n2};

    int returnSize = 0;
    int* result = inorderTraversal(&n1, &returnSize);

    printf("Inorder Traversal: ");
    for (int i = 0; i < returnSize; i++) {
        printf("%d ", result[i]);
    }
    printf("\n");

    free(result);
    return 0;
}
