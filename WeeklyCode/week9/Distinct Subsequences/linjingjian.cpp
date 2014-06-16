class Solution {
public:
	//f(i,j) means how many distinct subsequences are in S[0...i] and T[0...j] 
    //f(i,j) = S[i]==T[j] ? f(i-1,j-1)+f(i-1,j) : f(i-1,j)
    int numDistinct(string S, string T) {
        int lens = S.size();
        int lent = T.size();
        if(lent > lens || lens==0) return 0;
        vector<vector<int> > dp(lens+1, vector<int>(lent+1) );
        for(int i=0; i<=lens; i++)
            dp[i][0] = 1;
        for(int i=0; i<lens; i++)
        {
            for(int j=0; j<lent; j++)
            {
                dp[i+1][j+1] = dp[i][j+1];
                if(S[i] == T[j])
                    dp[i+1][j+1] += dp[i][j];
            }
        }
        return dp[lens][lent];
    }
	//solution 2
	int numDistinct2(string S, string T) {
        int lens = S.size();
        int lent = T.size();
        if(lent > lens || lens==0) return 0;
        vector<int> dp(lent+1);
        dp[0] = 1;
        for(int i=0; i<lens; i++)
            for(int j=lent-1; j>=0; j--)
                if(S[i] == T[j])
                    dp[j+1] += dp[j];
        return dp[lent];
    }
};
