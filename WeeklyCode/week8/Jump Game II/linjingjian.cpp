class Solution {
public:
    int jump(int A[], int n) {
        int cur_max=0,cur_min=0,step=0;
        while(cur_max < n-1)
        {
            ++step;
            int tmp = cur_max;
            for(int i=cur_min; i<=cur_max; i++)
                if(i+A[i] > tmp)
                    tmp = i+A[i];
            cur_min = cur_max+1;
            cur_max = tmp;
        }
        return step;
    }
};