#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

class Solution {
public:
    bool isPalindrome(string s) {
        int low=0,high=s.length()-1;
        while(low<high){
            while(low<high && !isalnum(s[low])){
                low++;
            }
            while(high>low && !isalnum(s[high])){
                high--;
            }
            if(low>=high){
                break;
            }
            if(tolower(s[low])!=tolower(s[high])){
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
};