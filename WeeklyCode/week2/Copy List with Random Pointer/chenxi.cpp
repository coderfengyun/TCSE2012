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
        if(head==NULL) return NULL;
        RandomListNode *cur=head;
        RandomListNode *copyHead=NULL;
        RandomListNode *copyCur=copyHead;
        while(cur!=NULL){
            if(copyHead==NULL){
                copyHead=new RandomListNode(cur->label);
                copyHead->next=cur->next;
                cur->next=copyHead;
                cur=copyHead->next;
                copyCur=copyHead;
            }
            else{
                copyCur=new RandomListNode(cur->label);
                copyCur->next=cur->next;
                cur->next=copyCur;
                cur=copyCur->next;
            }
        }
       // cout<<"yes";
        cur=head;
        while(cur!=NULL){
            copyCur=cur->next;
			if(cur->random!=NULL){
            copyCur->random=cur->random->next;
			}
			else{
				copyCur->random=NULL;
			}
			
			cur=copyCur->next;
			/* cur->next=copyCur->next;
			cur=copyCur->next;
			if(cur!=NULL)
			copyCur=cur->next;*/
			
        }
		cur=head;
		while(cur!=NULL){
			copyCur=cur->next;
			cur->next=copyCur->next;
			cur=cur->next;
			if(cur!=NULL)
				copyCur->next=cur->next;
		}
        return copyHead;
    }
};
