class Solution {
public:
    int sqrt(int x) {
        if(x == 0 || x==1) return x;
        int a=1,beg,end;
        while(x/a > a) a<<=1;
        if(x/a == a) return a;
        end=a, beg=a>>1;
        while(beg <= end)
        {
            int mid = (beg+end)>>1;
            if(x/mid == mid)
                return mid;
            else if ( x/mid > mid)
                beg=mid+1;
            else end=mid-1;
        }
        return end;
    }
};