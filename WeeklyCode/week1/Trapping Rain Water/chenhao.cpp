#include<iostream>
#include<algorithm>
#include<vector>
#include<cstdlib>
#include<cstring>
using namespace std;

class Solution {
public:
    int trap(int A[], int n) {
        int* fence=new int[n]();
        fence[0]=A[i];
        int maxHeight=A[0];
        for(int i=1;i<n;i++){
            if(A[i]<maxHeight){
                fence[i]=maxHeight;
            }
            else{
                fence[i]=A[i];
                maxHeight=A[i];
            }
        }

        fence[n-1]=A[n-1];
        maxHeight=A[n-1];
        for(int i=n-2;i>=0;i--){
            if(A[i]<maxHeight){
                fence[i]=min(fence[i],maxHeight);
            }
            else{
                fence[i]=min(fence[i],A[i]);
                maxHeight=A[i];
            }
        }

        int sum=0;
        for(int i=0;i<n;i++){
            sum+=fence[i]-A[i];
        }

        delete[] fence;

        return sum;
    }
};