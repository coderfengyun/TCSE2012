class Solution {
public:
    // the easily solution is dfs, but it comes out TLE, so we need to prunch the search tree
    // dp is also available, it need three dimension to reprensent the states
    bool isScramble(string s1, string s2) {
        if(s1.size() != s2.size()) return false;
        isScramble(s1, s2, 0, 0, s1.size());
    }
    bool isScramble(string &s1, string &s2, int beg1, int beg2, int length)
    {
        if(length == 1) return s1[beg1] == s2[beg2];
        int cnt[26];
        memset(cnt, 0, sizeof(cnt));
        for(int i=0; i<length; i++) cnt[s1[beg1+i] - 'a'] ++;
        for(int i=0; i<length; i++) cnt[s2[beg2+i] - 'a'] --;
        for(int i=0; i<26; i++) if(cnt[i] != 0) return false;

        for(int i=1; i<length; i++)
        {
            if(isScramble(s1, s2, beg1, beg2, i) && isScramble(s1, s2, beg1+i, beg2+i, length-i))
                return true;
            if(isScramble(s1, s2, beg1, beg2+length-i,i) && isScramble(s1, s2, beg1+i, beg2, length-i))
                return true;
        }
        return false;
    }
};