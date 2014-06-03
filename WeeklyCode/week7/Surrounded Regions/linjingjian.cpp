class Solution {
public:
    queue<pair<int,int> > q;
    int m, n;
    
    void revise(int x, int y, vector<vector<char>> &board) {
        if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'O') {
            board[x][y] = 'P';
            q.push(make_pair(x,y));
        }    
    }
    
    void bfs(int x, int y, vector<vector<char>> &board) {
        revise(x, y, board);
        while (!q.empty()) {
            pair<int,int> p = q.front();
            q.pop();            
            revise(p.first - 1, p.second, board);
            revise(p.first + 1, p.second, board);
            revise(p.first, p.second - 1, board);
            revise(p.first, p.second + 1, board);
        }
    }
    
    void solve(vector<vector<char>> &board) {
        if (board.empty() || board.size() == 0 || board[0].size() == 0) return;
        m = board.size(), n = board[0].size();
        for (int i = 0; i < n; i++) {
            bfs(0, i, board);
            bfs(m - 1, i, board);
        }
        for (int i = 0; i < m; i++) {
            bfs(i, 0, board);
            bfs(i, n - 1, board);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] == 'P' ? 'O' : 'X';
            }
        }
    }
};