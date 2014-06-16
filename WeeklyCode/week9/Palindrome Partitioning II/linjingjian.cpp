class Solution {
public:
    //f(i) means the minimum cut of s[0...j]
    //f(i) = min( f(j)+1 ) if s[j+1...i] is palindrome 0<=k<i
    //we need to solve the following problem: find out all palindromes, so dp was utilized
    //g(i,j) means is s[i...j] is palindrome
    //g(i,j) is ture when i==j or s[i]==s[j] and (i+1==j or g(i+1,j-1) )
    int minCut(string s) {
        int len = s.size();
        if(len == 0) return 0;
        vector<vector<bool> > isPalindrome(len,vector<bool>(len));
        for(int i=len-1; i>=0; i--)
        {
            for(int j=i; j<len; j++)
                isPalindrome[i][j] = i==j || s[i]==s[j] && (i==j-1 || isPalindrome[i+1][j-1]);
        }
        vector<int> dp(len+1, INT_MAX);
        dp[0] = 0;
        for(int i=0; i<len; i++)
            if(isPalindrome[0][i])
                dp[i+1] = 0;
        for(int i=0; i<len; i++)
        {
            for(int j=i; j>=0; j--)
            {
                if(isPalindrome[j][i])
                    dp[i+1] = min(dp[i+1], dp[j]+1);
            }
        }
        return dp[len];
    }
};