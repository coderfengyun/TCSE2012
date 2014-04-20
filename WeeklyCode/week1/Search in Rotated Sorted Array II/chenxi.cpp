class Solution {
public:
    bool search(int A[], int n, int target) {
        int low=0,high=n-1,mid=0,pos=-1;
        while(low<=high){
            mid=(low+high)/2;
            if(target==A[mid]){
                pos=mid;
                break;
            }
           
            if(A[low]<A[mid]){
                if(target>=A[low]&&target<A[mid]){
                    high=mid-1;
                }
                else{
                    low=mid+1;
                }
            }
            else if(A[mid]<A[low]){
                if(target>A[mid]&&target<=A[high]){
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
            else{
            while(A[low]==A[mid]&&low<=mid){
               low++;
            }
            }
        }
        if(pos!=-1) return true;
        else return false;
    }
};
