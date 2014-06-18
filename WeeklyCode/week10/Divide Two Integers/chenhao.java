public class Solution {

    public int divide(int dividend, int divisor) {
        if(divisor==0){
            throw new IllegalArgumentException("hehe");
        }
        int sign1=dividend>0?1:-1;
        int sign2=divisor>0?1:-1;
        return sign1*sign2*divideNegtive(toNegtive(dividend),toNegtive(divisor));
    }

    private int toNegtive(int x){
        return x>0? -x:x;
    }

    private int divideNegtive(int dividend, int divisor) {
        int res=0;
        int k=0;
        while(true){
            if((divisor<<k)<dividend){
                break;
            }
            if(k>0 && (divisor<<k)>(divisor<<(k-1))){
                break;
            }
            k++;
        }
        for(int j=k-1;j>=0;j--){
            if(dividend<=(divisor<<j)){
                dividend-=divisor<<j;
                res+=1<<j;
            }
        }
        return res;
    }
}