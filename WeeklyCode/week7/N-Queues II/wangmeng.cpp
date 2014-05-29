class Solution {
public:
  int result, n;
  vector<bool> col, diag, rdiag;
  void solve(int line) {
    if (line == n) {
      result++;
      return;
    }
    for (int i=0; i<n; i++) {
      if (col[i] || diag[i+line] || rdiag[line-i+n-1]) continue;
      col[i] = diag[i+line] = rdiag[line-i+n-1] = true;
      solve(line+1);
      col[i] = diag[i+line] = rdiag[line-i+n-1] = false;
    }
  }
  int totalNQueens(int n) {
    result = 0;
    this->n = n;
    col.clear(); col.resize(n, false);
    diag.clear(); diag.resize(n<<1, false);
    rdiag.clear(); rdiag.resize(n<<1, false);
    solve(0);
    return result;
  }
};
