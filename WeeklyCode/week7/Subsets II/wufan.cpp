class Solution {
public:
    vector<vector<int> > subsetsWithDup(vector<int> &S) {
         vector<vector<int> > results;
         vector<int> r;
         if (S.size() == 0){
             results.push_back(r);
             return results;
         }
         sort(S.begin(), S.end());
         dfs(results, r, 0, S);
         return results;
    }

     void dfs(vector<vector<int> > &results, vector<int>&cur, int start, vector<int> &S){
         results.push_back(cur);
         for (int i = start; i < S.size(); i++){
             if (i != start && S[i] == S[i-1]) continue; 
             cur.push_back(S[i]);
             dfs(results, cur, i+1, S);
             cur.pop_back();
         }


     }
};
