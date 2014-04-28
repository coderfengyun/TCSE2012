/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *deleteDuplicates(ListNode *head) {
        if(head==NULL||head->next==NULL)
        return head;
        ListNode *cur=head->next;
        ListNode *res=head;
        res->next=NULL;
        while(cur!=NULL){
            if(cur->val!=res->val){
                ListNode *tmp=cur;
                cur=cur->next;
                tmp->next=NULL;
                res->next=tmp;
                res=res->next;
            }else{
                cur=cur->next;
            }
        }
        return head;
    }
};
