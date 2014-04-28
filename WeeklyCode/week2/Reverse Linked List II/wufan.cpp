class Solution {
public:
     void reverseList(ListNode *start, ListNode *end, ListNode *before, ListNode *after){

        ListNode *pre = start, *cur = start->next, *next = nullptr;
        while (cur != after){
            next = cur->next;
            cur->next = pre;
            pre = cur;
            cur = next;
        }
      
        start->next = after;
        before->next = pre;
       
    }


    ListNode *reverseBetween(ListNode *head, int m, int n) {
        if (head == nullptr || m == n)
            return head;
        ListNode *first = new ListNode(-1);
        first->next = head;
        ListNode *pre = first;
        ListNode *start = head, *end = nullptr;
        
        //find m'th node
        int cnt = 1;
        while (cnt < m){
            pre = start;   
            start = start->next;
            cnt += 1;
        }
        //find n'th node
        
        end = start;
        while (cnt < n){
            end = end->next;
            cnt += 1;
        }
        ListNode *next = end->next;

        // reverse nodes between m and n
        reverseList(start, end, pre, next);
   
        return first->next;
    }
};
