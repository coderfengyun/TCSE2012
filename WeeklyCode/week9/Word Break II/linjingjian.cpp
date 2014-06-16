class Solution {
public:
    //it comes out TLE when dfs was used, and it is hard to prunch the search tree
    // dp was considered, f(i,j) means that is s[i...j] can be cutted by the dict
    // f(i,j) = s[i...j] is in dict or f[i,k] and f(k,j) 0<=k<j
    vector<string> wordBreak(string s, unordered_set<string> &dict) {
        int len = s.size();
        vector<vector<bool> > dp(len+1, vector<bool>(len));
        for(int i=0; i<len; i++)
            dp[len][i] = true;
        for(int i=len-1; i>=0; i--)
        {
            for(int j=i; j<len; j++)
            {
                string str = s.substr(i, j-i+1);
                if(dict.find(str) != dict.end())
                    dp[i][j] = true;
                else
                {
                    for(int k=i; k<j; k++)
                    {
                        dp[i][j] = dp[i][k] && dp[k+1][j];
                        if(dp[i][j])
                            break;
                    }
                }
            }
        }
        vector<string> ans;
        vector<string> path;
        dfs(s, 0, path, dict, ans, dp);
        return ans;
    }
    void dfs(string &s, int cur, vector<string> &path, unordered_set<string> &dict, vector<string> &ans, vector<vector<bool> > &dp)
    {
        if(cur >= s.size())
        {
            string str;
            for(int i=0; i<path.size(); i++)
                str += path[i]+' ';
            str.erase(str.size()-1);
            ans.push_back(str);
            return;
        }
        for(int i=cur; i<s.size(); i++)
        {
            string str = s.substr(cur, i-cur+1);
            if(dp[i+1][s.size()-1] && dict.find(str) != dict.end())
            {
                path.push_back(str);
                dfs(s, i+1, path, dict, ans, dp);
                path.pop_back();
            }
        }
    }
};