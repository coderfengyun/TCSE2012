class Solution {
public:
    bool isPalindrome(string s) {
        int i = 0,j = s.size()-1;
        while(i<=j)
        {
            while(i<=j && !isalnum(s[i])) i++;
            while(i<=j && !isalnum(s[j])) j--;
            if(i>j)
                break;
            if(isdigit(s[i]) && s[i]!=s[j])
                return false;
            if( tolower(s[i])!=tolower(s[j]))
                return false;
            i++;j--;
        }
        return true;
    }
};