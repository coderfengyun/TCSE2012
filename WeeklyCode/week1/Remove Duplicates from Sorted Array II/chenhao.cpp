#include<iostream>
using namespace std;

class Solution {
public:
    int removeDuplicates(int A[], int n) {
        if(n<2){
        	return n;
        }
        int p=1;
        int cnt=1;
        for(int i=1;i<n;i++){
        	if(A[i]==A[i-1])
        		cnt++;
        	else
        		cnt=1;
        	if(cnt<=2){
        		A[p++]=A[i];
        	}
        }
        return p;
    }

};
