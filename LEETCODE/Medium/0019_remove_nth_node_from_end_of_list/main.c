#include <stdio.h>
#include <stdlib.h>

// Definition for singly-linked list.
struct ListNode {
    int val;
    struct ListNode *next;
};

// Function to remove the nth node from the end of the list
struct ListNode* removeNthFromEnd(struct ListNode* head, int n) {
    struct ListNode* first = head;
    struct ListNode* last = head;

    for(int i = 0; i < n; i++)
        first = first->next;

    if(first == NULL) {
        head = head->next;
        return head;
    }

    while(first->next != NULL) {
        first = first->next;
        last = last->next;
    }

    last->next = last->next->next;
    return head;
}

// Helper function to create a new ListNode
struct ListNode* newNode(int val) {
    struct ListNode* node = (struct ListNode*) malloc(sizeof(struct ListNode));
    node->val = val;
    node->next = NULL;
    return node;
}

// Helper function to print the list
void printList(struct ListNode* head) {
    while (head != NULL) {
        printf("%d ", head->val);
        head = head->next;
    }
    printf("\n");
}

// Driver code
int main() {
    // Example: head = [1,2,3,4,5], n = 2
    struct ListNode* head = newNode(1);
    head->next = newNode(2);
    head->next->next = newNode(3);
    head->next->next->next = newNode(4);
    head->next->next->next->next = newNode(5);

    int n = 2;

    printf("Original list:\n");
    printList(head);

    head = removeNthFromEnd(head, n);

    printf("List after removing %d-th node from the end:\n", n);
    printList(head);

    return 0;
}
