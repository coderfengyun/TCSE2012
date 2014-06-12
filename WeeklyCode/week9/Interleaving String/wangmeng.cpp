class Solution {
public:
  /**
   * dp[i][j] = s1[i-1] == s3[i+j-1] && dp[i-1][j]
   *            || s2[j-1] == s3[i+j-1] && dp[i][j-1]
   **/
  bool isInterleave(string s1, string s2, string s3) {
    if (s1.size() + s2.size() != s3.size()) return false;
    vector<bool> dp(s2.size()+1, false);
    dp[0] = true;
    for (int i=1; i<=s2.size() && s2[i-1] == s3[i-1]; i++) dp[i] = true;
    for (int i=1; i<=s1.size(); i++) {
      for (int j=0; j<=s2.size(); j++) {
	dp[j] = (s1[i-1] == s3[i+j-1] && dp[j]) || (j > 0 && s2[j-1] == s3[i+j-1] && dp[j-1]);
      }
    }
    return dp[s2.size()];
  }
};
