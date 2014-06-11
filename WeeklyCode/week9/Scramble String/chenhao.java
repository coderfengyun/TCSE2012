public class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1.length()!=s2.length()){
            return false;
        }
        int n=s1.length();
        boolean[][][] dp=new boolean[n+1][n][n];
        
        for(int len=1;len<=n;len++){
            for(int i=0;i+len<=n;i++){
                for(int j=0;j+len<=n;j++){
                    if(len==1){
                        dp[len][i][j]=s1.charAt(i)==s2.charAt(j);
                    }
                    else{
                        for(int k=1;k<len;k++){
                            if(( dp[k][i][j] && dp[len-k][i+k][j+k] ) ||
                                ( dp[k][i][j+len-k] && dp[len-k][i+k][j] )){
                                dp[len][i][j]=true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return dp[n][0][0];
    }
}