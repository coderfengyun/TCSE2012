class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_map<char, int> cmap;
        int first=-1, last=0, n=s.size(), ans=0;
        while(last != n)
        {
            if(cmap.find(s.at(last)) != cmap.end())
            {
                if(first < cmap[s.at(last)])
                    first = cmap[s.at(last)];
            }
            cmap[s.at(last)] = last;
            if(last-first > ans) ans = last-first;
            last++;
        }
        return ans;
    }
};