public class Solution {
    public int jump(int[] A) {
        if(A == null || A.length == 0){
            return 0;
        }
        int result = 0, target = A.length - 1, temp = -1;
        while(target > 0){
            temp = findMinReachable(target, A);
            if(temp == -1){
                return -1;
            }
            target = temp;
            result++;
        }
        return result;
    }
    
    private int findMinReachable(int target, int[] A){
        int reuslt = 0;
        for(int i = 0; i < target && i < A.length; i++){
            if(A[i] >= target - i){
                return i;
            }
        }
        return -1;
    }
}