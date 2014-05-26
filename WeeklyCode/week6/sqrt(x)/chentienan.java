public class Solution {
    public int sqrt(int x) {
        int end = 46340;
        return sqrt_0(1, end, x);
    }
    
    private int sqrt_0(int begin, int end, int target){
        if(begin * begin == target){
            return begin;
        }
        if(begin * begin > target){
            return begin - 1;
        }
        if(end * end <= target){
            return end;
        }
        int mid = (begin + end) / 2;
        if(mid*mid > target){
            return sqrt_0(begin, mid - 1, target);
                      
        }else if(mid * mid == target){
            return mid;
        }else{
            return sqrt_0(mid + 1, end, target);  
        }
    }
}