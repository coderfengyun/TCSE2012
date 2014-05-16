class Solution {
public:
  ListNode *deleteDuplicates(ListNode *head) {
    for(ListNode *t=head; t&&t->next; t=t->next) {
      while (t->next && t->val == t->next->val) t->next = t->next->next;
    }
    return head;
  }
};
