class Solution {
public:
    TreeNode *sortedListToBST(ListNode *head)
    {
        return sortedListToBST(head, nullptr);
    }

    TreeNode *sortedListToBST(ListNode *head, ListNode *rear)
    {
        if(head == rear) return nullptr;
        if(head->next == rear) return new TreeNode(head->val);
        ListNode *p = head, *q = head->next;
        while( q != rear)
        {
            p = p->next;
            q = q->next;
            if(q != rear) q = q->next;
        }
        TreeNode *root = new TreeNode(p->val);
        root->left = sortedListToBST(head, p);
        root->right = sortedListToBST(p->next, rear);
        return root;
    }
};