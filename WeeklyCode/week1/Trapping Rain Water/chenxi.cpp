class Solution {
public:
    int trap(int A[], int n) {
        int tmpMax=0,sum=0;
        int *leftMax=new int[n];
        int *rightMax=new int[n];
        for(int i=0;i<n;i++){
            leftMax[i]=tmpMax;
            if(A[i]>tmpMax)
                tmpMax=A[i];
        }
        tmpMax=0;
        for(int i=n-1;i>=0;i--){
            rightMax[i]=tmpMax;
            if(A[i]>tmpMax)
                tmpMax=A[i];
        }
        for(int i=0;i<n;i++){
            int trapDepth=0;
            if(leftMax[i]<rightMax[i]){
                trapDepth=leftMax[i];
            }else{
                trapDepth=rightMax[i];
            }
            if(trapDepth>A[i]){
                sum+=(trapDepth-A[i]);
            }
        }
        return sum;
    }
};
