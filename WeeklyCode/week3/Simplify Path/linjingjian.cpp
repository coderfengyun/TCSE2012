class Solution {
public:
    string simplifyPath(string path) {
        vector<string> stk;
        for(auto i=path.begin(); i!=path.end();)
        {
            i++;
            auto j = find(i, path.end(), '/');
            string dir = string(i, j);
            if(!dir.empty() && dir != ".")
            {
                if(dir == "..")
                {
                    if(!stk.empty()) stk.pop_back();
                }
                else stk.push_back(dir);
            }
            i=j;
        }
        if(stk.empty()) return "/";
        string res;
        for( auto dir : stk)
            res = res+'/'+dir;
        return res;
    }
};