class Solution {
public:
    ListNode *deleteDuplicates(ListNode *head) {
        if(head==NULL || head->next==NULL) return head;
        ListNode *p = head, *q=head->next;
        while(q != NULL)
        {
            if(p->val == q->val)
            {
                ListNode *old = q;
                q = q->next;
                delete old;
            }
            else
            {
                p->next = q;
                p = p->next;
                q=q->next;
            }
        }
        p->next = NULL;
        return head;
    }
};