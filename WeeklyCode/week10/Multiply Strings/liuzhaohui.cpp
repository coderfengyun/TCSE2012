class Solution {
public:

void reverse(string &s){
    size_t len = s.size();
    for(size_t i = 0 ; i < (len>>1); i++){
        s[i] ^= s[len-1-i];
        s[len-1-i] ^= s[i];
        s[i] ^= s[len-1-i];
    }
}

string simpMul(const string &strNum, char cDigit, int nBase){
    string strRes(strNum);
    if(strNum.empty() || cDigit < '0' || cDigit > '9'){return strRes;}

    int carry = 0;
    int curNum = 0;
    int curDigit = 0;
    int digit = cDigit-'0';

    for(size_t i = 0 ; i!= strRes.size(); i++){
        curNum = (strRes[i]-'0') * digit + carry;
        carry = curNum / nBase;
        curDigit = curNum - carry*nBase;
        strRes[i] = curDigit+'0';
    }
    if(carry > 0){
        strRes.push_back(carry+'0');
    }
    return strRes;
}

void simpAdd(string &strNum, const string &strAdd, size_t shift, int nBase){
    if(strAdd.empty()){return ;}

    while(shift > strNum.size()){
        strNum.push_back('0');
    }

    int carry = 0;
    int curNum = 0;
    int curDigit = 0;
    size_t i = 0;
    for(i = 0; i < strAdd.size(); i++){
        if(i+shift >= strNum.size()){
            curNum = carry + (strAdd[i]-'0');
            carry = curNum / nBase;
            curDigit = curNum - carry*nBase;
            strNum.push_back(curDigit+'0');
        }else{
            curNum = carry + (strNum[i+shift]-'0') + (strAdd[i]-'0');
            carry = curNum / nBase;
            curDigit = curNum - carry*nBase;
            strNum[i+shift] = curDigit+'0';
        }
    }

    while(carry != 0){
        if(i+shift >= strNum.size()){
            curNum = carry;
            carry = curNum / nBase;
            curDigit = curNum - carry*nBase;
            strNum.push_back(curDigit+'0');
        }else{
            curNum = carry + (strNum[i+shift]-'0');
            carry = curNum / nBase;
            curDigit = curNum - carry*nBase;
            strNum[i+shift] = curDigit+'0';
        }
        i++;
    }

}

string multiply(string num1, string num2) {
    string strMul;
    if(num1.empty() || num2.empty()){return strMul;}
    if(num1 == "0" || num2 == "0"){return string("0");}

    reverse(num1);
    reverse(num2);

    int pointNum = 0;
    int pos = num1.find('.',0);
    if( pos != string::npos){
        pointNum += pos;
        num1.erase(pos,1);
    }
    pos = num2.find('.',0);
    if( pos != string::npos){
        pointNum += pos;
        num2.erase(pos,1);
    }


    for(size_t i = 0 ; i!= num2.size(); i++){
        string strTemp(simpMul(num1, num2[i],10));
        simpAdd(strMul,strTemp,i,10);
    }

    if(pointNum > 0){
        strMul.insert(strMul.begin()+pointNum,'.');
    }


    reverse(strMul);
    int j = pointNum > 0 ? strMul.find_last_not_of('0') : string::npos;
    if( strMul[j] == '.') j--;
    int i = strMul.find_first_not_of('0',0);
    if( strMul[i] == '.') i--;

    return strMul.substr(i,j);
}
};
