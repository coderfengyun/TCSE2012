class Solution {
public:
    bool search(int A[], int n, int target) {
        int offset=0;
        for(int i=1;i<n;i++){
        	if(A[i]<A[i-1]){
        		offset=i;
        		break;
        	}
        }

        int lt=0,rt=n-1;
        while(lt<=rt){
        	int mid=(lt+rt)>>1;
        	int value=A[(mid+offset)%n];
        	if(value==target){
        		return true;
        	}
        	else if(value<target){
        		lt=mid+1;
        	}
        	else{
        		rt=mid-1;
        	}
        }
        return false;
    }
};