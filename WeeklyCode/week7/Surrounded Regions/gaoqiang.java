public class Solution {
    int[][] flag;
	int[] xs = { -1, 0, 1, 0 };
	int[] ys = { 0, -1, 0, 1 };

	public void solve(char[][] board) {
		if (board == null)
			return;
		int m = board.length;
		if (m == 0)
			return;
		int n = board[0].length;
		flag = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if ((i == 0 || i == m - 1 || j == 0 || j == n - 1)
						&& board[i][j] == 'O') {
					color(board, i, j);
				}
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'O' && flag[i][j] != 1)
					board[i][j] = 'X';
			}
		}
	}

	private void color(char[][] board, int i, int j) {
		int m = board.length, n = board[0].length;
		Queue<Integer> queue = new LinkedList<Integer>();
		flag[i][j] = 1;
		queue.add(i * n + j);
		while (!queue.isEmpty()) {
			int index = queue.poll();
			int a = index / n;
			int b = index % n;
			for (int r = 0; r < 4; r++) {
				int x = a + xs[r];
				int y = b + ys[r];
				if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'O'
						&& flag[x][y] != 1) {
					flag[x][y] = 1;
					queue.add(x * m + y);
				}
			}
		}
	}
}