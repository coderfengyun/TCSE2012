class Solution {
public:
    bool searchMatrix(vector<vector<int> > &matrix, int target) {
        if(matrix.empty() || matrix.front().empty()) return false;
        int m = matrix.size();
        int n = matrix.front().size();
        if(target < matrix[0][0] || target > matrix[m-1][n-1]) return false;
        
        int row = 0;
        int col = n-1;
        while(row < m && col >= 0){
            if(target == matrix[row][col]){
                return true;
            }else if (target < matrix[row][col]){
                col--;
            }else{
                row++;
            }
        }
        
        return false;
    }
};
