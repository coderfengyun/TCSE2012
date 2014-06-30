public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null ||matrix.length==0||matrix[0].length==0){
            return false;
        }
        int m=matrix.length, n=matrix[0].length;
        int targetRow = -1;
        for(int i=0;i<m;i++){
            if(matrix[i][0]==target){
                return true;
            }
            if(matrix[i][0]>target){
                targetRow = i-1;
                break;
            }
            if(i==m-1){
                targetRow = i;
            }
        }
        if(targetRow<0){
            return false;
        }
        for(int i=0;i<n;i++){
            if(matrix[targetRow][i]==target){
                return true;
            }
        }
        return false;
    }
}