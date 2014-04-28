class Solution {
public:
    ListNode *reverseBetween(ListNode *head, int m, int n) {
        if(n == m) return head;
        ListNode node(0);
        node.next = head;
        int i;
        ListNode *p=&node,*mth_pre, *nth_post, *q;
        for(i=1;i<m;i++)
            p=p->next;
        mth_pre = p;
        for(;i<=n+1; i++)
            p=p->next;
        nth_post = p;
        q = mth_pre->next;
        p = q->next;
        q->next = nth_post;
        while(p != nth_post)
        {
            ListNode *r = p->next;
            p->next = mth_pre->next;
            mth_pre->next = p;
            p = r;
        }
        return node.next;
    }
};