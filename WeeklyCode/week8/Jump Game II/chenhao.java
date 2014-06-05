public class Solution {
    public int jump(int[] A) {
        if(A==null || A.length<=1){
            return 0;
        }
        int cur=0,next=0;
        int jumps=0;
        for(int i=0;i<A.length;){
            if(i>cur){
                cur=next;
                jumps++;
            }
            else{
                next=Math.max(next,i+A[i]);
                if(next>=A.length-1){
                    return jumps+1;
                }
                i++;
            }
        }
        return -1;
    }
}