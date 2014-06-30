public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        int n=0,m=0;
        if( (n=matrix.length)==0 || (m=matrix[0].length)==0 ){
            return false;
        }
        int lo=0, hi=n*m-1;
        while(lo<=hi){
            int mid=(lo+hi)/2;
            int val=matrix[mid/m][mid%m];
            if(val==target){
                return true;
            }
            else if(val>target){
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return false;
    }
}