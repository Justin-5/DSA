#include <stdio.h>
#include <stdlib.h>

// Definition for singly-linked list.
struct ListNode {
    int val;
    struct ListNode *next;
};

// Function to remove duplicates from sorted linked list
struct ListNode* deleteDuplicates(struct ListNode* head) {
    struct ListNode* current = head;

    while (current != NULL && current->next != NULL) {
        if (current->val == current->next->val) {
            // Duplicate found, remove it
            struct ListNode* temp = current->next;
            current->next = current->next->next;
            free(temp);
        } else {
            // Move to the next unique element
            current = current->next;
        }
    }

    return head;
}

// Utility function to create a new node
struct ListNode* createNode(int val) {
    struct ListNode* node = (struct ListNode*)malloc(sizeof(struct ListNode));
    node->val = val;
    node->next = NULL;
    return node;
}

// Utility function to print the linked list
void printList(struct ListNode* head) {
    while (head != NULL) {
        printf("%d ", head->val);
        head = head->next;
    }
    printf("\n");
}

// Sample usage
int main() {
    // Create linked list: 1 -> 1 -> 2 -> 3 -> 3
    struct ListNode* head = createNode(1);
    head->next = createNode(1);
    head->next->next = createNode(2);
    head->next->next->next = createNode(3);
    head->next->next->next->next = createNode(3);

    printf("Original list: ");
    printList(head);

    struct ListNode* updatedHead = deleteDuplicates(head);

    printf("After removing duplicates: ");
    printList(updatedHead);

    return 0;
}
