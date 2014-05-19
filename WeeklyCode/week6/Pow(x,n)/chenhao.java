public class Solution {
    
    private double pow0(double x, int n){
        if(n==0){
            return 1.0;
        }
        double t=pow0(x,n/2);
        return (n&1)==0 ? t*t : t*t*x;
    }
    
    public double pow(double x, int n) {
        return n>=0? pow0(x,n) : 1/pow0(x,-n);
    }
}