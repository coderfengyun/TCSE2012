class liuxianglong {
	//transferring function
	//m is the index of chars in S
	//n is the index of chars in T
	//if(S[m]==T[n]) f(m,n) = f(m-1,n-1)+f(m-1,n);
	//else f(m,n) = f(m-1,n)
	public int numDistinct(String S, String T) {
        if(S.length()<T.length()) return 0;
        int[][] dp = new int[2][S.length()+1];
        int tag = 0;
        for(int i=0;i<=S.length();i++)dp[tag][i]=1;
        for(int i=0;i<T.length();i++){
            tag=tag^1;
            dp[tag][0]=0;
            for(int j=1;j<S.length()+1;j++){
                if(T.charAt(i)==S.charAt(j-1)){
                    dp[tag][j]=dp[tag][j-1]+dp[tag^1][j-1];
                }else{
                    dp[tag][j]=dp[tag][j-1];
                }
            }
        }
        return dp[tag][S.length()];
    }
}