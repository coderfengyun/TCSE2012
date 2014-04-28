#include<iostream>
#include<cstdlib>
#include<cstring>
#include<climits>
#include<algorithm>
#include<vector>
using namespace std;

class Solution {

    int saturatedConvertNegtive(int negtiveValue,int sign){
        if(negtiveValue==INT_MIN && sign==1){
            return INT_MAX;
        }
        return -negtiveValue*sign;
    }

public:
    int atoi(const char *str) {
        int res=0;
        int sign=1;

        const char* p=str;
        while(*p==' '){
            p++;
        }

        
        if(*p=='+'){
            p++;
        }
        else if(*p=='-'){
            p++;
            sign=-1;
        }

        //accumulate negtively to avoid exceeding INT_MAX
        while(p){
            if(!isdigit(*p)){
                break;
            }
            else{
                int digit=*p-'0';
                if(res<(INT_MIN+digit)/10){ // overflow: res*10-digit<INT_MIN 
                    return sign>0?INT_MAX:INT_MIN;
                }
                res=res*10-digit;
            }
            p++;
        }
        return saturatedConvertNegtive(res,sign);
    }
};