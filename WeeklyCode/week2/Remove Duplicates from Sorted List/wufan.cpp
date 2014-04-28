class Solution {
public:
    ListNode *deleteDuplicates(ListNode *head) {
		if (head == nullptr)
			return head;
		ListNode *pre = head;
		ListNode *cur = head->next;
		ListNode *tmp = nullptr;
		while (cur){
			if (cur->val == pre->val){
				tmp = cur;
				cur = cur->next;
				delete tmp;
			}
			else{
				pre->next = cur;
				pre = pre->next;
				cur = cur->next;
			}
		}
		pre->next = nullptr;
		return head;
    }
};
