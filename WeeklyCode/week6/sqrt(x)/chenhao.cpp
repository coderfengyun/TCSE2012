class Solution {
public:
    int sqrt(int x) {
        int ans=x;
        int lt=1,rt=x;
        while(lt<=rt){
            int mid=(lt+rt)>>1;
            if(x/mid>=mid){
                ans=mid;
                lt=mid+1;
            }
            else{
                rt=mid-1;
            }
        }
        return ans;
    }
};