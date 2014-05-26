class Solution {
public:
    ListNode *sortList(ListNode *head) {
        if(head==nullptr || head->next==nullptr) return head;
        ListNode *p=head, *q=head->next;
        while(q != nullptr)
        {
            q = q->next;
            if(q != nullptr) q = q->next;
            if(q != nullptr) p = p->next;
        }
        q = p->next;
        p->next = nullptr;
        ListNode *h1 = sortList(head);
        ListNode *h2 = sortList(q);
        
        ListNode node(0);
        ListNode *pre = &node;
        while(h1!=nullptr && h2!=nullptr)
        {
            if(h1->val < h2->val)
            {
                pre->next = h1;
                h1 = h1->next;
                pre = pre->next;
            }
            else
            {
                pre->next = h2;
                h2 = h2->next;
                pre = pre->next;
            }
        }
        if(h2 != nullptr) h1 = h2;
        pre->next = h1;
        return node.next;
    }
};