class Solution {
public:
  typedef pair<int, int> POS;
  const int dx[4] = {-1,1,0,0}, dy[4] = {0,0,-1,1};
  int row, col;
  inline bool within(POS p) {
    return p.first < row && p.first >=0 && p.second < col && p.second >= 0;
  }
  bool replace(vector<vector<char>>& board, POS p, char src, char tgt) {
    queue<POS> q;
    bool res = true;
    q.push(p);
    board[p.first][p.second] = tgt;
    while(!q.empty()) {
      POS cur = q.front();
      q.pop();
      for (int i=0; i<4; i++) {
	POS next = POS(cur.first+dx[i], cur.second+dy[i]);
	if (within(next) && board[next.first][next.second] == src) {
	  board[next.first][next.second] = tgt;
	  q.push(next);
	} 
	res = res && (within(next));
      }
    }
    return res;
  }
  void solve(vector<vector<char>> &board) {
    row = board.size();
    if (row == 0) return;
    col = board[0].size();
    for (int i=0; i<row; i++) {
      for (int j=0; j<col; j++) {
	if (board[i][j] == 'O' && replace(board, POS(i, j), 'O', 'o')) {
	  replace(board, POS(i, j), 'o', 'X');
	}
      }
    }
    for_each(board.begin(), board.end(), [](vector<char>& row) {
	for_each(row.begin(), row.end(), [](char& c) {c=c=='o'?'O':c;}); 
      });
  }
};
