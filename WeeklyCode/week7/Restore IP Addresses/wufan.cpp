class Solution{
 public:
     vector<string> restoreIpAddresses(string s) {
         vector<string> result, path;
         dfs(0, s, path, result);
         return result;
     }


     void dfs(int start, string &s, vector<string> &path, vector<string> &result){
         if (start >= s.length()){
             if (path.size() != 4)
                 return;
             string s = path[0];
             for (int i = 1; i < path.size(); i++){
                 s += "." + path[i];
             }
             result.push_back(s);
             return;
         }
         if (path.size() == 4)
             return;
         for (int i = 1; i <= 3 && start + i <= s.length(); i++){
             string sstr = s.substr(start, i);
             if (sstr[0] == '0' && i > 1)
                 break;
             if (atoi(sstr.c_str()) <= 255){
                 path.push_back(sstr);
                 dfs(start+i, s, path, result);
                 path.pop_back();
             }

         }
     }
};
