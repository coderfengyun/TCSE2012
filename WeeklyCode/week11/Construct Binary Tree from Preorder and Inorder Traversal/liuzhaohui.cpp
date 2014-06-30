/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    TreeNode *build(const vector<int> &preorder, const vector<int> &inorder, int iPL, int iIL, int len){
        if(len <= 0) return nullptr;
        TreeNode* root = new TreeNode(preorder[iPL]);
        if(len == 1) return root;
        
        int iMid = 0;
        for(iMid = iIL; iMid < iIL+len; iMid++){
            if(inorder[iMid] == preorder[iPL]) break;
        }
        //assert(iMid < iIL+len);
        
        int len1 = iMid - iIL;
        int len2 = iIL + len - iMid - 1;
        root->left = build(preorder,inorder,iPL+1,iIL,len1);
        root->right = build(preorder,inorder,iPL+len1+1, iMid+1, len2);
        return root;
    }

    TreeNode *buildTree(vector<int> &preorder, vector<int> &inorder) {
        if(preorder.empty()) return nullptr;
        return build(preorder,inorder,0,0,preorder.size());
    }
};
