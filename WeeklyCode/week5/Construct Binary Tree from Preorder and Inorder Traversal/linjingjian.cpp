class Solution {
public:
    TreeNode *buildTree(vector<int> &preorder, vector<int> &inorder)
    {
        return buildTree(preorder, 0, preorder.size(), inorder, 0, inorder.size());
    }

    TreeNode *buildTree(vector<int> &preorder, int prebeg, int preend, vector<int> &inorder, int inbeg, int inend)
    {
        if(prebeg >= preend) return nullptr;
        int i = inbeg;
        while(i !=inend)
        {
            if(preorder[prebeg] == inorder[i]) break;
            else i++;
        }
        TreeNode *root = new TreeNode(preorder[prebeg]);
        root->left = buildTree(preorder, prebeg+1, prebeg+i-inbeg+1, inorder, inbeg, i);
        root->right = buildTree(preorder, prebeg+i-inbeg+1, preend, inorder, i+1, inend);
        return root;
    }
};