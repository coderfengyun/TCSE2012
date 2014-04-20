class WeekOne{
public:
   int trap(int A[], int n){
        int i = 0;
        int j = n-1;
        int water = 0;
        int max_left = A[i];
        int max_right = A[j];
        while (i < j){
            if (A[i] < A[j]){
                i++;
                if (A[i] < max_left)
                    water += max_left - A[i];
                else
                    max_left = A[i];
            }
            else{
                j--;
                if (A[j] < max_right)
                    water += max_right - A[j];
                else
                    max_right = A[j];
            }
        }
        return water;
    }
};
