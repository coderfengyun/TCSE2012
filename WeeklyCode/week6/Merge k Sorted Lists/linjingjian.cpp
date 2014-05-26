struct mycmp{
    bool operator() (const ListNode* l1, const ListNode *l2)
    {
        if(l1 == NULL) return 1;
        if(l2 == NULL) return 0;
        return l1->val > l2->val;
    }
};
class Solution {
public:
    ListNode *mergeKLists(vector<ListNode *> &lists) {
        int len = lists.size();
        if(len == 0) return NULL;
        priority_queue<ListNode*, vector<ListNode*>, mycmp> pq;
        for(int i=0; i<len; i++)
            pq.push(lists[i]);
        ListNode l(0);
        ListNode *rear = &l;
        while(pq.top() != NULL)
        {
            ListNode *q = pq.top();
            ListNode *nxt = q->next;
            rear->next = q;
            q->next = NULL;
            rear = q;
            pq.pop();
            pq.push(nxt);
        }
        return l.next;
    }
};