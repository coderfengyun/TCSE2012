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
    ListNode *deleteDuplicates(ListNode *head) {
        ListNode vHead(0);
        vHead.next=head;
        if(head!=NULL && head->val==0){
            vHead.val=1;
        }

        ListNode *pre=&vHead, *cur=head;
        while(cur!=NULL){
            ListNode* next=cur->next;
            if(cur->val == pre->val){
                pre->next=next;
                delete cur;
            }
            else{
                pre=cur;
            }
            cur=next;
        }
        return vHead.next;
    }
};

int main(){
    ListNode head(1);
    Solution s;
    cout<<s.deleteDuplicates(&head)<<endl;
}