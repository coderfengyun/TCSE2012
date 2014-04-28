class Solution {
public:
    ListNode *addTwoNumbers(ListNode *l1, ListNode *l2) {
        ListNode res(0);
        ListNode *rear = &res;
        ListNode *p = l1;
        ListNode *q = l2;
        int ac = 0;
        while(p!=NULL || q!=NULL)
        {
            int num=ac;
            if(p!= NULL)
                num += p->val;
            if(q!=NULL)
                num += q->val;
            if(num >= 10)
            {
                num -= 10;
                ac = 1;
            }
            else ac = 0;

            rear->next = new ListNode(num);
            rear = rear->next;
            if(p!=NULL)
                p=p->next;
            if(q!=NULL)
                q=q->next;
        }
        if(ac != 0)
            rear->next = new ListNode(ac);
        return res.next;
    }
};
