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

    void recoverTree(TreeNode *root) {
        if( !root) return;
        
        TreeNode node(INT_MIN);
        TreeNode* pre = &node;
        TreeNode *pL, *pR;
        bool bFirst = true;
        while(root){
            if( !(root->left) ){
                //
                if(pre->val > root->val){
                    if(bFirst){bFirst=false; pL = pre; pR = root;}
                    else{pR = root;}
                }
                pre = root;
                root = root->right;
            }else{
                TreeNode* p;
                for(p = root->left; p->right && p->right != root; p=p->right);
               
                if( !(p->right)) {
                    p->right = root;
                    root = root->left;
                }else{
                    p->right = nullptr;
                    if(pre->val > root->val){
                        if(bFirst){bFirst=false; pL = pre; pR = root;}
                        else{pR = root;}
                    }
                    //
                    pre = root;
                    root = root->right;
                }
            }
        }
        swap(pL->val, pR->val);
        
        return;
    }
};
