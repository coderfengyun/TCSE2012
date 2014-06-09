class Solution {
public:
    vector<vector<int> > permuteUnique(vector<int> &num) {
        int n = num.size();
        vector<vector<int> > ans;
        if(n == 0) return ans;
        vector<bool> visited(n);
        vector<int> cur;
        sort(num.begin(), num.end());
        permuteUnique(num, visited, cur, ans);
        return ans;
    }
    void permuteUnique(vector<int> &num, vector<bool> &visited, vector<int> &cur, vector<vector<int> > &ans){
        int n = num.size();
        if(cur.size() == n)
        {
            ans.push_back(cur);
            return;
        }
        for(int i=0; i<n; i++)
        {
            if(visited[i] || i!=0 && num[i]==num[i-1] && visited[i-1]) continue;
            cur.push_back(num[i]);
            visited[i] = true;
            permuteUnique(num, visited, cur, ans);
            cur.pop_back();
            visited[i] = false;
        }
    }
};