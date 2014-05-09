#include<iostream>
#include<cstdlib>
#include<cstring>
#include<climits>
#include<algorithm>
#include<vector>
#include<stack>
using namespace std;

class Solution {

public:
    bool isValid(string s) {
        const string LEFT_PARENTHESES="({[";
        const string RIGHT_PARENTHESES=")}]";

        stack<int> indexStack;
        for(int i=0;i<s.length();i++){
            if(LEFT_PARENTHESES.find(s[i])!=string::npos){
                indexStack.push(LEFT_PARENTHESES.find(s[i]));
            }
            else if(RIGHT_PARENTHESES.find(s[i])!=string::npos){
                if(!indexStack.empty() && indexStack.top()==RIGHT_PARENTHESES.find(s[i])){
                    indexStack.pop();
                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }
        }
        return indexStack.empty();
    }
};

int main(int argc, char const *argv[])
{
    Solution s;
    cout<<s.isValid("()")<<endl;
    return 0;
}