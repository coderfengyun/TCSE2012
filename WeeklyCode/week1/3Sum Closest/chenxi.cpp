class Solution {
public:
    int MAX=100000;
    int threeSumClosest(vector<int> &num, int target) {
        int n=num.size();
        int sum=0,closest=MAX;
        if(n<3){
            for(int i=0;i<n;i++){
                sum+=num[i];
            }
            return sum;
        }
        sort(num.begin(),num.end());
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                int k=n-1;
                while(k>j){
                    sum=num[i]+num[j]+num[k];
                    
                    if(sum==target){
                        closest=sum;
                        return closest;
                    }
                    //每次计算完 都要比较并且保存结果
                    if(abs(sum-target)<abs(closest-target)){
                            closest=sum;
                    }
                    if(sum<target){
                        
                        break;
                    }else{
                        k=k-1;
                    }
                }
            }
        }
        return closest;
        
    }
};
