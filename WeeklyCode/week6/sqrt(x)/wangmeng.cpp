class Solution {
public:
    int sqrt(int x) {
        long long lt = 0, rht = x+1LL; // 1LL is must
        while(rht - lt > 1) {
            LL mid = (lt + rht) >> 1, t = mid * mid;
            if (t == x) return mid;
            else if (t > x) rht = mid;
            else lt = mid;
        }
        return lt;
    }
};
