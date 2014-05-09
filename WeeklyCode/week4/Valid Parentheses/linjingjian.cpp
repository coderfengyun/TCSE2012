class Solution {
public:
    bool isValid(string s) {
        stack<char> stk;
        unordered_map<char, char> smap;
        smap[')'] = '('; 
		smap[']'] = '['; 
		smap['}'] = '{';
        for(auto i=s.begin(); i != s.end(); i++)
        {
            if(smap.find(*i) != smap.end())
            {
                if(stk.empty() || smap[*i] != stk.top()) return false;
                stk.pop();
            }
            else stk.push(*i);
        }
        return stk.empty();
    }
};