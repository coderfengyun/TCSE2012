class Solution {
public:
int divide(int dividend, int divisor) {
    if(dividend == 0 || divisor == 0){
        return 0;
    }

    bool isPos = (dividend < 0) ? (divisor < 0) : (divisor > 0);
    unsigned int curDividend = 0;
    unsigned int curDivisor = 0;
    curDividend = dividend < 0 ? -dividend : dividend;
    curDivisor = divisor < 0 ? -divisor : divisor;
    curDividend = (dividend == INT_MIN) ? INT_MIN : curDividend;
    curDivisor = (divisor == INT_MIN) ? INT_MIN : curDivisor;

    int result = 0;

    int curBase = 1;
    unsigned int oriDivisor = curDivisor;
    while(curDivisor < curDividend && curBase <= INT_MAX/2){
        curDivisor <<= 1;
        curBase <<= 1;
    }

    while(curDividend >= oriDivisor){
        if(curDividend >= curDivisor){
            curDividend -= curDivisor;
            result += curBase;
        }else{
            curDivisor >>= 1;
            curBase >>= 1;
        }
    }

    return isPos ? result: -result;
}
};
