class Solution {
public:
    vector<int> searchRange(int A[], int n, int target) {
        int beg=0, end=n-1,index=-1;
        while(beg <= end)
        {
            int mid = (beg+end)/2;
            if(target == A[mid])
            {
                index = mid;
                break;
            }
            else if(target > A[mid])
                beg = mid+1;
            else end = mid-1;
        }
        if(index == -1)
            return vector<int>(2,-1);
        int first, last;
        beg=0,end=index;
        while(beg <= end)
        {
            int mid = (beg+end)/2;
            if(target == A[mid])
            {
                first = mid;
                end = mid-1;
            }
            else if(target > A[mid])
                beg = mid+1;
            else end = mid-1;
        }
        beg=index,end=n-1;
        while(beg <= end)
        {
            int mid = (beg+end)/2;
            if(target == A[mid])
            {
                last = mid;
                beg = mid+1;
            }
            else if(target > A[mid])
                beg = mid+1;
            else end = mid-1;
        }
        vector<int> v(2);
        v[0]=first, v[1]=last;
        return v;
    }
};