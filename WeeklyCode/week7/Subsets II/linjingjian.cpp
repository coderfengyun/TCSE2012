vector<vector<int> > subsetsWithDup(vector<int> &S) {
        if(S.size() == 0) return vector<vector<int> >();
        vector<bool> used(S.size());
        sort(S.begin(), S.end());
        vector<vector<int> > ans;
        vector<int> cur;
        dfs(S, 0, S.size(), used, cur, ans);
        return ans;
    }
void dfs(vector<int> &S, int beg, int len, vector<bool> &used, vector<int> &cur, vector<vector<int> > &ans)
{
    if(beg == len)
    {
        ans.push_back(cur);
        return;
    }
    dfs(S, beg+1, len, used, cur, ans);
    if(beg == 0 || S[beg] != S[beg-1] || used[beg-1])
    {
        used[beg] = true;
        cur.push_back(S[beg]);
        dfs(S, beg+1, len, used, cur, ans);
        used[beg] = false;
        cur.pop_back();
    }
}