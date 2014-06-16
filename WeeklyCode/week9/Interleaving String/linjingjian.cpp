class Solution {
public:
    //f(i,j) means can s3[0...i+j+1] be shown as s1[0...i] and s2[0...j]
    //f(i,j) = f(i-1,j) if s1[i]==s3[i+j] 
    //f(i,j) = f(i, j-1) if s2[j]==s3[i+j]
    //we need to solve the problem that s1 or s2 is empty
	bool isInterleave(string s1, string s2, string s3) {
		int len1 = s1.size();
        int len2 = s2.size();
        int len3 = s3.size();
        if(len1+len2 != len3) return false;
        vector<vector<bool> > dp(len1+1, vector<bool>(len2+1));
        dp[0][0]=true;
        for(int i=0; i<len1; i++)
            dp[i+1][0] = dp[i][0] && s1[i]==s3[i];
        for(int i=0; i<len2; i++)
            dp[0][i+1] = dp[0][i] && s2[i]==s3[i];
        for(int i=0; i<len1; i++)
            for(int j=0; j<len2; j++)
                dp[i+1][j+1] = (s1[i]==s3[i+j+1] && dp[i][j+1]) || (s2[j]==s3[i+j+1] && dp[i+1][j]);
        return dp[len1][len2];
    }
	//solution 2
    bool isInterleave(string s1, string s2, string s3) {
        int len1 = s1.size();
        int len2 = s2.size();
        int len3 = s3.size();
        if(len1+len2 != len3) return false;
        if(len2 == 0) return s1==s3;
        vector<bool> dp(len2+1);
        dp[0]=true;
        for(int i=0; i<len2; i++)
            dp[i+1] = s2[i]==s3[i] && dp[i];
        for(int i=0; i<len1; i++)
        {
            dp[0] = s1[i]==s3[i] && dp[0];
            for(int j=0; j<len2; j++)
                dp[j+1] = (s1[i]==s3[i+j+1] && dp[j+1]) || (s2[j]==s3[i+j+1] && dp[j]);
        }
        return dp[len2];
    }
};