/**
 * Definition for singly-linked list with a random pointer.
 * struct RandomListNode {
 *     int label;
 *     RandomListNode *next, *random;
 *     RandomListNode(int x) : label(x), next(NULL), random(NULL) {}
 * };
 */
class Solution {
public:
    RandomListNode *copyRandomList(RandomListNode *head) {
        if(head == NULL) return head;
        RandomListNode *p=head, *q, *rn;
        while(p!= NULL)
        {
            rn = new RandomListNode(p->label);
            rn->next = p->next;
            p->next = rn;
            p = rn->next;
        }
        p=head;
        while(p!=NULL)
        {
            if(p->random != NULL)
                p->next->random = p->random->next;
            else p->next->random = NULL;
            p = p->next->next;
        }
        p=head, q=head->next;
        RandomListNode *res = q;
        while(q!=NULL)
        {
            p->next = q->next;
            if(p->next != NULL)
                q->next = p->next->next;
            p=p->next;
            q=q->next;
        }
        return res;
    }
};