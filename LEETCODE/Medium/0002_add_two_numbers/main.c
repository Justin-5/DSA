#include <stdio.h>
#include <stdlib.h>

// Definition for singly-linked list.
struct ListNode {
    int val;
    struct ListNode *next;
};

// Function to add two numbers represented by linked lists
struct ListNode* addTwoNumbers(struct ListNode* l1, struct ListNode* l2) {
    int carry = 0;
    struct ListNode* head = NULL;
    struct ListNode* tail = NULL;
    int x, y;

    while (l1 != NULL || l2 != NULL || carry != 0) {
        if (l1 != NULL)
            x = l1->val;
        else
            x = 0;

        if (l2 != NULL)
            y = l2->val;
        else
            y = 0;

        int sum = x + y + carry;
        carry = sum / 10;

        struct ListNode* newnode = (struct ListNode*)malloc(sizeof(struct ListNode));
        newnode->val = sum % 10;
        newnode->next = NULL;

        if (head == NULL)
            head = newnode;
        else
            tail->next = newnode;

        tail = newnode;

        if (l1 != NULL) l1 = l1->next;
        if (l2 != NULL) l2 = l2->next;
    }

    return head;
}

// Utility function to create a linked list from an array
struct ListNode* createList(int* arr, int size) {
    if (size == 0) return NULL;
    struct ListNode* head = NULL, *tail = NULL;
    for (int i = 0; i < size; i++) {
        struct ListNode* node = (struct ListNode*)malloc(sizeof(struct ListNode));
        node->val = arr[i];
        node->next = NULL;
        if (head == NULL) head = node;
        else tail->next = node;
        tail = node;
    }
    return head;
}

// Utility function to print a linked list
void printList(struct ListNode* head) {
    while (head != NULL) {
        printf("%d", head->val);
        if (head->next != NULL) printf(" -> ");
        head = head->next;
    }
    printf("\n");
}

// Example usage
int main() {
    int arr1[] = {2, 4, 3};
    int arr2[] = {5, 6, 4};
    struct ListNode* l1 = createList(arr1, 3);
    struct ListNode* l2 = createList(arr2, 3);

    struct ListNode* result = addTwoNumbers(l1, l2);
    printf("Sum: ");
    printList(result);

    return 0;
}
