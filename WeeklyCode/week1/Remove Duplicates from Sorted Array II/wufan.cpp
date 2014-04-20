class WeekOne{
public:
    int removeDuplicates(int A[], int n) {
        if (n < 2) return n;
        int pre = A[0];
        int cnt = 1;
        int index = 0;
        for (int i = 1; i<n; i++){
            if(A[i] != pre){
                pre = A[i];
                cnt = 1;
                A[++index] = A[i];
            }else if(cnt < 2){
                cnt ++;
                A[++index] = A[i];
            }
        }
        return index+1;
    }

};
