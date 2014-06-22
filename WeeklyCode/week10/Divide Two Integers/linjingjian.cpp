class Solution {
public:
    int divide(int dividend, int divisor) {
        bool negative = false;
        if(dividend>0 && divisor<0 || dividend<0 && divisor>0) negative = true;
        long long dvd = dividend;
        long long dvs = divisor;
        long long ans = absDivide( abs(dvd), abs(dvs));
        if(negative) return 0-ans;
        return ans;
    }
    
    long long absDivide(long long dividend, long long divisor)
    {
        if(dividend < divisor) return 0;
        long long ans = 1;
        long long a = divisor;
        while(a <= dividend)
        {
            ans <<= 1;
            a <<= 1;
        }
        ans >>= 1;
        a >>= 1;
        return ans+absDivide(dividend-a, divisor);
    }
};