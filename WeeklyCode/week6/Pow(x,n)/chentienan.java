public class Solution {
    public double pow(double x, int n) {
        if(n == 1){
            return x;
        }
        if(n == 0){
            return 1;
        }
        double halfValue = pow(x, n/2);
        double result = halfValue * halfValue;
        if(Math.abs(n) % 2 != 0){
            if(n < 0){
                result *= 1 / x;
            }else{
                result *= x;
            }
        }
        return result;
    }
}