class Solution {
public:
    void connect(TreeLinkNode *root) {
        if(root == nullptr) return;
        vector<vector<TreeLinkNode *> > level(2);
        bool flag = true;
        level[flag].push_back(root);

        while(!level[flag].empty())
        {
            for(int i=0; i<level[flag].size(); i++)
            {
                if(i != level[flag].size() -1)
                    level[flag][i]->next = level[flag][i+1];
                if( level[flag][i]->left != nullptr)
                    level[1-flag].push_back(level[flag][i]->left);
                if( level[flag][i]->right != nullptr)
                    level[1-flag].push_back(level[flag][i]->right);
            }
            level[flag].clear();
            flag = 1-flag;
        }
    }
};