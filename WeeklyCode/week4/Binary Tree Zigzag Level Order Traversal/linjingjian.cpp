class Solution {
public:
    vector<vector<int> > zigzagLevelOrder(TreeNode *root) {
        if (root == nullptr) return vector<vector<int> >();
        vector<vector<int> > ans;
        vector<vector<TreeNode *> > level(2);
        bool flag = true;
        level[flag].push_back(root);
        while(!level[flag].empty())
        {
            vector<int> tmp;
            for(auto i=level[flag].begin(); i != level[flag].end(); i++) tmp.push_back((*i)->val);
            if(!flag) reverse(tmp.begin(), tmp.end());
            ans.push_back(tmp);
            for(auto i=level[flag].begin(); i != level[flag].end(); i++)
            {
                if((*i)->left != nullptr)
                    level[1-flag].push_back((*i)->left);
                if((*i)->right != nullptr)
                    level[1-flag].push_back((*i)->right);
            }
            level[flag].clear();
            flag = 1-flag;
        }
        return ans;
    }
};