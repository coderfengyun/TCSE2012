class liuxianglong {
	private boolean isMatch(char cs,char cp){
		return cs==cp||cp=='.';
	}
	public boolean isMatch(String s, String p) {
		boolean[][] dp = new boolean[s.length()+1][p.length()+1];
		dp[s.length()][p.length()]=true;
		int suffix =p.length()-1;
		while(suffix>0&&p.charAt(suffix)=='*'){
			dp[s.length()][suffix-1]=true;
			suffix-=2;
		}
        for(int i =s.length()-1;i>=0;i--){
        	for(int j=p.length()-1;j>=0;j--){
        		char cp = p.charAt(j);
        		char cs = s.charAt(i);
        		if(cp=='*'){
        			j--;
        			cp = p.charAt(j);
        			dp[i][j]=isMatch(cs,cp)&&dp[i+1][j]||dp[i][j+2];
        		}else{
        			dp[i][j]=isMatch(cs,cp)&&dp[i+1][j+1];
        		}
        	}
        }
        return dp[0][0];
    }
}