class Solution {
public:
  bool isValidSudoku(vector<vector<char> > &board) {
    vector<vector<bool> > col(9, vector<bool>(10, false));
    vector<vector<bool> > row(9, vector<bool>(10, false));
    vector<vector<bool> > grid(9, vector<bool>(10, false));
    int gridi, gridj;
    for (int i=0; i<9; i++) {
      gridi = i/3;
      for (int j=0; j<9; j++) {
	gridj = j/3;
	if (board[i][j] == '.') continue;
	int num = board[i][j] == '.'? 0:board[i][j]-'0';
	if (row[i][num]) return false;
	if (col[j][num]) return false;
	if (grid[3*gridi+gridj][num]) return false;
	row[i][num] = true;
	col[j][num] = true;
	grid[3*gridi+gridj][num] = true;
      }
    }
    return true;
  }
};
