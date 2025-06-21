// Problem: Merge Two Sorted Lists
// Approach: Use a dummy node to simplify edge cases while merging two sorted linked lists
// Time Complexity: O(n + m), where n and m are lengths of the two lists

#include <stdio.h>
#include <stdlib.h>

// Definition for singly-linked list
struct ListNode {
    int val;
    struct ListNode *next;
};

// Function to create a new ListNode with a given value
struct ListNode* createNode(int value) {
    struct ListNode* newNode = (struct ListNode*)malloc(sizeof(struct ListNode));
    newNode->val = value;
    newNode->next = NULL;
    return newNode;
}

// Function to merge two sorted linked lists into one sorted list
struct ListNode* mergeTwoLists(struct ListNode* list1, struct ListNode* list2) {
    struct ListNode head;     // Dummy node
    head.next = NULL;
    struct ListNode* mergedlist = &head;

    // Merge nodes in sorted order
    while (list1 != NULL && list2 != NULL) {
        if (list1->val <= list2->val) {
            mergedlist->next = list1;
            list1 = list1->next;
        } else {
            mergedlist->next = list2;
            list2 = list2->next;
        }
        mergedlist = mergedlist->next;
    }

    // Attach the remaining nodes, if any
    mergedlist->next = (list1 == NULL) ? list2 : list1;

    return head.next; // Return the merged list (skipping dummy head)
}

// Helper function to print a linked list
void printList(struct ListNode* head) {
    while (head != NULL) {
        printf("%d ", head->val);
        head = head->next;
    }
    printf("\n");
}

// Sample driver code
int main() {
    // Creating first sorted list: 1 -> 2 -> 4
    struct ListNode* list1 = createNode(1);
    list1->next = createNode(2);
    list1->next->next = createNode(4);

    // Creating second sorted list: 1 -> 3 -> 4
    struct ListNode* list2 = createNode(1);
    list2->next = createNode(3);
    list2->next->next = createNode(4);

    // Merging both lists
    struct ListNode* merged = mergeTwoLists(list1, list2);

    // Output the merged list
    printf("Merged Sorted List: ");
    printList(merged);

    return 0;
}
