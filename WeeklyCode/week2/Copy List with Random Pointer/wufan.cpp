class Solution {
public:
     RandomListNode *copyRandomList(RandomListNode *head) {
      if (head == nullptr)
          return head;
      RandomListNode *cur = head,  *node = nullptr;
      // copy node 
      while (cur != nullptr){
          node = new RandomListNode(cur->label);
          node->next = cur->next;
          cur->next = node;
          cur = node->next;
      }

      // edit random pointer
      cur = head;
      while(cur != nullptr){
          node = cur->next;
          node->random = cur->random != nullptr? cur->random->next : nullptr;
          cur = node->next;
      }

      //detach the list
      RandomListNode *newhead = head->next;
      cur = head;
      while (cur != nullptr){
        node = cur->next;
        cur->next = node->next;
        cur = node->next;
        if (node->next == nullptr){
            return newhead;
        }
        node->next = node->next->next;
        node = node->next;
      }
    }
};
