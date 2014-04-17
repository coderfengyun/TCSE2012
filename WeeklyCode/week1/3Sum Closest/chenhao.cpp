#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

class Solution {
public:
    int threeSumClosest(vector<int> &num, int target) {
        sort(num.begin(),num.end());
        int n=num.size();

        int minDiff=1e10;
        int res=0;
        for(int i=0;i<n;i++){
        	int p=i+1,q=n-1;
        	while(p<q){
        		int sum=num[i]+num[p]+num[q];
        		int diff=abs(sum-target);
        		if(diff<minDiff){
        			minDiff=diff;
        			res=sum;
        		}
        		if(sum<target){
        			p++;
        		}
        		else{
        			q--;
        		}
        	}
        }
        return res;
    }
};