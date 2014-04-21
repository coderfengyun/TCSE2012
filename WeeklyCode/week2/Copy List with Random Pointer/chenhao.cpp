#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

 struct RandomListNode {
     int label;
     RandomListNode *next, *random;
     RandomListNode(int x) : label(x), next(NULL), random(NULL) {}
 };

class Solution {
public:
    RandomListNode *copyRandomList(RandomListNode *head) {
        
        RandomListNode *cur=head;
        while(cur!=NULL){
            RandomListNode* next=cur->next;
            cur->next=new RandomListNode(cur->label);
            cur->next->next=next;
            cur=next;
        }

        cur=head;
        while(cur!=NULL){
            if(cur->random!=NULL){
                cur->next->random=cur->random->next;
            }
            cur=cur->next->next;
        }

        RandomListNode newHead(0);
        RandomListNode *newCur=&newHead;
        cur=head;
        while(cur!=NULL){
            RandomListNode *next=cur->next->next;
            newCur->next=cur->next;
            newCur=newCur->next;
            cur->next=next;
            cur=next;
        }

        return newHead.next;
    }
};