class Solution {
public:
    vector<string> restoreIpAddresses(string s) {
        vector<string> ans;
        dfs(s, 0, 0, "", ans);
        return ans;
    }
    void dfs(const string &s, int beg, int sections, string cur, vector<string> &ans)
    {
        int len = s.size();
        if(beg >= len)
        {
            if(sections == 4)
                ans.push_back(cur.substr(0, cur.size()-1));
            return;
        }
        if(sections>=4) return;
        dfs(s, beg+1, sections+1, cur+s[beg]+'.', ans);
        if(s[beg] !='0' && beg+2 <= len)
            dfs(s, beg+2, sections+1, cur+s.substr(beg,2)+'.', ans);
        if(beg+3 <= len)
        {
            if(s[beg] == '1' || s[beg] == '2' && (s[beg+1]<'5' || s[beg+1]=='5' && s[beg+2]<='5'))
                dfs(s, beg+3, sections+1, cur+s.substr(beg,3)+'.', ans);       
        }
    }
};