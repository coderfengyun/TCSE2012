class Solution {
public:
    bool isBalanced(TreeNode *root)
    {
        int depth;
        return isBalanced(root, depth);
    }

    bool isBalanced(TreeNode *root, int &depth)
    {
        if(root == nullptr)
        {
            depth = 0;
            return true;
        }

        if( !isBalanced(root->left, depth) ) return false;
        int ldepth = depth;
        if( !isBalanced(root->right, depth) ) return false;
        if( abs(ldepth-depth) > 1 ) return false;
        depth = ldepth>depth? ldepth+1 : depth+1;
        return true;
    }
};