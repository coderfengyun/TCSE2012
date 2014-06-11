import java.util.Objects;

public class Solution {
    public int numDistinct(String S, String T) {
        // dp(i,j)= dp(i-1,j) + S[i]==T[j]?dp(i-1,j-1):0;
        S=Objects.requireNonNull(S);
        T=Objects.requireNonNull(T);
        int[] dp=new int[T.length()+1];
        dp[0]=1;
        for(int i=1;i<=S.length();i++){
            char x=S.charAt(i-1);
            for(int j=Math.min(i,T.length());j>=1;j--){
                char y=T.charAt(j-1);
                dp[j]+= x==y? dp[j-1]:0;
            }
        }
        return dp[T.length()];
    }
}