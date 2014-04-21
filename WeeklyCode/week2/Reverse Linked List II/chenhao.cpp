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
    ListNode *reverseBetween(ListNode *head, int m, int n) {
        ListNode vHead=ListNode(0);
        vHead.next=head;

        ListNode *cur=head, *pre=&vHead;
        ListNode *preBegin, *begin;

        for(int i=1;cur;i++){
            ListNode* next=cur->next;
            if(i==m){
                preBegin=pre;
                begin=cur;
            }
            if(i>m){
                cur->next=pre;    
            }
            if(i==n){
                preBegin->next=cur;
                begin->next=next;
                break;
            }
            pre=cur;
            cur=next;
        }
        return vHead.next;
    }
};