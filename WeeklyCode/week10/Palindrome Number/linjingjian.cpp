class Solution {
public:
    bool isPalindrome(int x) {
        if(x < 0) return false;
        int tmp = x;
        int pow = 1;
        while(tmp >= 10)
        {
            tmp /= 10;
            pow *= 10;
        }
        while(x > 0) 
        {
            if( x/pow != x%10) return false;
            x = x%pow/10;
            pow /= 100;
        }
        return true;
    }
};