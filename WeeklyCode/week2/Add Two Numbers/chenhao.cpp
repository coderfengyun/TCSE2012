#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode *addTwoNumbers(ListNode *l1, ListNode *l2) {
        ListNode vHead(0);
        ListNode* cur=&vHead;
        int carry=0;
        while(l1!=NULL || l2!=NULL){
            int value=carry;
            if(l1!=NULL){
                value+=l1->val;
                l1=l1->next;
            }
            if(l2!=NULL){
                value+=l2->val;
                l2=l2->next;
            }
            if(value>=10){
                value-=10;
                carry=1;
            }
            else{
                carry=0;
            }
            cur->next=new ListNode(value);
            cur=cur->next;
        }
        if(carry){
            cur->next=new ListNode(1);
        }
        return vHead.next;
    }
};