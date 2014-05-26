class Solution {
public:
    double pow(double x, int n) {
        if(n==0) return 1.0;
        if( fabs(x-1.0) < 1e-6) return 1.0;
        if( fabs(x+1.0) < 1e-6)
        {
            if(n & 1) return -1.0;
            return 1.0;
        }
        if(n<0) return 1/pow(x, 0-n);
        double ans = pow(x, n>>1);
        if(n & 1)
            return ans*ans*x;
        return ans*ans;
    }
};