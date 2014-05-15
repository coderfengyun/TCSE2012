class Solution {
public:
    vector<TreeNode *> generateTrees(int n)
    {
        return generateTrees(1, n+1);
    }
    vector<TreeNode *> generateTrees(int begin, int end)
    {
        vector<TreeNode *> ans;
        if(begin >= end)
        {
            ans.push_back(nullptr);
            return ans;
        }
        for(int i=begin; i != end; i++)
        {
            vector<TreeNode *> lroots = generateTrees(begin, i);
            vector<TreeNode *> rroots = generateTrees(i+1, end);
            for(int j=0; j<lroots.size(); j++)
            {
                for(int k=0; k<rroots.size(); k++)
                {
                    TreeNode *root = new TreeNode(i);
                    root->left = lroots[j];
                    root->right = rroots[k];
                    ans.push_back(root);
                }
            }
        }
        return ans;
    }
};