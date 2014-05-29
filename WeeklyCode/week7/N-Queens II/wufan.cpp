class Solution{
 public:
     int totalNQueens(int n) {
         int result = 0;   
         if (n <= 0)
             return 0;
         vector<int>path;
         dfs(0, n, path, result);
         return result;
     }

     bool isValid(vector<int>& path, int col, int n){
         int row = path.size();
         for (int i = 0; i < path.size(); i++){
             if (col == path[i] || abs(col - path[i]) == abs(row - i))
                 return false;
         }
         return true;
     }

     void dfs(int row, int n, vector<int>& path, int &result){
         if (row == n){
             result += 1;
             return;
         }
         for (int i = 0; i < n; i++){
             if (isValid(path, i, n)){
                 path.push_back(i);
                 dfs(row+1, n, path, result);
                 path.pop_back();
             }
         }
     }
};
