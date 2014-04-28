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
    ListNode *addTwoNumbers(ListNode *l1, ListNode *l2) {
        int com=0;
        ListNode *L1=l1;
        ListNode *L2=l2;
        ListNode *curL1=l1;
        while(l1!=NULL&&l2!=NULL){
            int tmpVal=l1->val+l2->val+com;
            l1->val=tmpVal%10;
            com=tmpVal/10;
            curL1=l1;
            l1=l1->next;
            l2=l2->next;
            
        }
        while(l1!=NULL){
            int tmpVal=l1->val+com;
            l1->val=tmpVal%10;
             com=tmpVal/10;
             curL1=l1;
             l1=l1->next;
        }
         while(l2!=NULL){
            int tmpVal=l2->val+com;
            l1=new ListNode(tmpVal%10);
            curL1->next=l1;
            curL1=l1;
            l1=l1->next;
             com=tmpVal/10;
             l2=l2->next;
        }
        if(l1==NULL&&l2==NULL&&com==1){
           // cout<<curL1->val;
            l1=new ListNode(com);
           // cout<<l1->val;
            curL1->next=l1;
            
        }
        return L1;
    }
    
};
