class Solution {
public:
  int totalNQueens(int n) {
       vector<int> path;
	   int num = 0;
	   dfs2(path, num, 0, n);
	   return num;
    }

	void dfs2(vector<int>& path, int& num, int row, int n){
		if (row == n){
			num++;
			return;
		}
		for (int i = 0; i < n; i++){
			if (isValid(path, row, i)){
				path.push_back(i);
				dfs2(path, num, row+1, n);
				path.pop_back();
			}
		}
	}
	
	bool isValid(vector<int> &path, int x, int y){
		for (int i = 0; i < x; i++){
			if (abs(y - path[i]) == abs(x - i) || y == path[i])
				return false;
		}
		return true;
	}
};
