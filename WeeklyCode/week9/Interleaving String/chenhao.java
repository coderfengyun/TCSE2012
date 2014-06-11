public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // dp(i,j) = ( s1[i]==s3[i+j] && dp(i-1,j) ) || ( s2[j]==s3[i+j] && dp(i,j-1) );
        if(s1.length()+s2.length()!=s3.length()){
            return false;
        }
        int n=s1.length(),m=s2.length();
        boolean[][] dp=new boolean[2][m+1];
        dp[0][0]=true;
        for(int i=1;i<=m;i++){
            if(s2.charAt(i-1)==s3.charAt(i-1)){
                dp[0][i]=true;
            }
            else{
                break;
            }
        }
        int t=1;
        for(int i=1;i<=n;i++){
            char c1=s1.charAt(i-1);
            dp[t][0]= dp[1-t][0] && c1==s3.charAt(i-1);
            for(int j=1;j<=m;j++){
                char c2=s2.charAt(j-1);
                char c3=s3.charAt(i+j-1);
                dp[t][j]= ( c1==c3 && dp[1-t][j] ) || ( c2==c3 && dp[t][j-1] );
            }
            t=1-t;
        }
        return dp[1-t][m];
    }
}