class liuxianglong {
	//m is the index of char in s
	//f(m) = Min{f(m-1)...fun(0)}+1 if s[j..m] is a palindrome
	public int minCut(String s) {
        int[] dp = new int[s.length()+1];dp[0]=1;
        boolean[][] pal = new boolean[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            for(int j=0;j<=i;j++){
                if(i-j>1){
                    pal[j][i] = pal[j+1][i-1]&&s.charAt(i)==s.charAt(j);
                }else{
                    pal[j][i] = s.charAt(i)==s.charAt(j);
                }
                if(dp[j]>0&&pal[j][i]){
                    int cut = dp[j]+1;
                    if(dp[i+1]==0||dp[i+1]>cut) dp[i+1]=cut;
                }
            }
        }
        return dp[s.length()]-2;
    }
}