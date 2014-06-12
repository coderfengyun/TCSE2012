class Solution {
public:
  int numDistinct(string S, string T) {
    vector<int> dp = vector<int>(T.size()+1, 0);
    dp[0] = 1;
    for (int i=1; i<=S.size(); i++) {
      for (int j=T.size(); j>0; j--) {
        if (S[i-1] == T[j-1]) {
          dp[j] += dp[j-1];
        } 
      }
    }
    return dp[T.size()];
  }
};
