#include<iostream>
#include<cstdlib>
#include<cstring>
#include<climits>
#include<algorithm>
#include<vector>
using namespace std;

class Solution {

    bool equal(char s,char p){
        return ( p=='.' && s!=0 ) || s==p;
    }

public:
    bool isMatch(const char *s, const char *p) {
        if(*p==0){
            return *s==0;
        }
        if(*(p+1)!='*'){
            return equal(*s,*p) && isMatch(s+1,p+1);
        }
        else{
            return isMatch(s,p+2) || 
                (equal(*s,*p) && isMatch(s+1,p));
        }
    }
};