class Solution {
public:
     void solve(vector<vector<char>> &board) {
       if (board.size() == 0)
           return;
       const int row = board.size();
       const int col = board[0].size();
       for (int i = 0; i < row; i++){
           if (board[i][0] == 'O') bfs(i, 0, board);
           if (board[i][col-1] == 'O') bfs(i, col-1, board);
       }
       for (int i = 0; i < col; i++){
           if (board[0][i] == 'O') bfs(0, i, board);
           if (board[row-1][i] == 'O') bfs(row-1, i, board);
       }
       for (int i = 0; i < row; i++){
           for (int j = 0; j < col; j++){
               if (board[i][j] == 'o')
                   board[i][j] = 'O';
               else if (board[i][j] == 'O')
                   board[i][j] = 'X';
           }
       }
    }
   bool isValid(const int i, const int j, const int row, const int col){
       return i>=0 && i<row && j>=0 && j<col;

   }
   void bfs(int i, int j, vector<vector<char>> &board){
      const int row = board.size();
      const int col = board[0].size();
      const int dx[4] = {0, 0, 1, -1};
      const int dy[4] = {1, -1, 0, 0};
      queue<pair<int, int>> q;
      q.push(make_pair(i, j));
      board[i][j] = 'o';
      while(!q.empty()){
          pair<int, int> point = q.front();
          q.pop();
          int x = point.first;
          int y = point.second;
          for (int n = 0; n < 4; n++){
              int n_x = x + dx[n];
              int n_y = y + dy[n];
              if (isValid(n_x, n_y, row, col) && board[n_x][n_y] == 'O'){
                  board[n_x][n_y] = 'o';
                  q.push(make_pair(n_x, n_y));
              }
          }
      }
   }

};
