class Solution {
public:
    const int DEGREE = 10;
    bool isPalindrome(int x) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if(x < 0){
            return false;
        }
        bool bPali = true;
        int curNum = x;
    
        int hBase = 1;
        while(curNum > 9){
            curNum /= DEGREE;
            hBase *= DEGREE;
        }
        curNum = x;
    
        int lDigit = 0;
        int rDigit = 0;
        while(curNum > 0){
            lDigit = curNum/hBase;
            rDigit = curNum%DEGREE;
            if(lDigit != rDigit){
                bPali = false;
                break;
            }
            curNum -= (lDigit * hBase + rDigit);
            curNum /= DEGREE;
    
            hBase /= (DEGREE * DEGREE);
        }
    
        return bPali;
    }
};
