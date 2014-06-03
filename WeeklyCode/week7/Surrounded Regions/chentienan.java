public class Solution {
	public void solve(char[][] board) {
		// Key is rowIndex * rowLength + columnIndex
		Map<Integer, Boolean> resultRepo = new HashMap<Integer, Boolean>();

		for (int i = 0; i < board.length; i++) {
			char[] row = board[i];
			for (int j = 0; j < row.length; j++) {
				// The edge
				if (j == row.length - 1 || i == board.length - 1) {
					continue;
				}
				List<FootPrint> footPrints = new LinkedList<FootPrint>();
				if (isSurrounded(i, j, board, footPrints, resultRepo)) {
					board[i][j] = 'X';
				}
			}
		}
	}

	// Just find a way to the edge
	private boolean isSurrounded(int row, int column, char[][] board,
			List<FootPrint> footPrints, Map<Integer, Boolean> resultRepo) {
		boolean result = true, temp = false;
		if (board[row][column] == 'X') {
			// 'X' is surrounded by himself
			return true;
		}
		if (row == 0 || row == board.length - 1 || column == 0
				|| column == board[row].length - 1) {
			// Already touch the edge
			return false;
		}
		if (resultRepo.containsKey(row * board[0].length + column)) {
			return resultRepo.get(row * board[0].length + column);
		}
		footPrints.add(new FootPrint(row, column));
		// check left
		if (!footPrints.contains(new FootPrint(row, column - 1))) {
			result &= check(row, column - 1, board, footPrints, resultRepo);
		}
		// check right
		if (!footPrints.contains(new FootPrint(row, column + 1))) {
			result &= check(row, column + 1, board, footPrints, resultRepo);
		}
		// check upper
		if (!footPrints.contains(new FootPrint(row + 1, column))) {
			result &= check(row + 1, column, board, footPrints, resultRepo);
		}
		// check down
		if (!footPrints.contains(new FootPrint(row - 1, column))) {
			result &= check(row - 1, column, board, footPrints, resultRepo);
		}
		return result;
	}

	private boolean check(int row, int column, char[][] board,
			List<FootPrint> footPrints, Map<Integer, Boolean> resultRepo) {
		boolean temp = false, result = true;
		temp = isSurrounded(row, column, board, footPrints, resultRepo);
		resultRepo.put(row * board[0].length + column, temp);
		result &= temp;
		return result;
	}

	private class FootPrint {
		private final int row;
		private final int column;

		FootPrint(int row, int column) {
			this.row = row;
			this.column = column;
		}

		@Override
		public int hashCode() {
			return this.row * 37 + this.column * 49;
		}

		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof FootPrint)) {
				return false;
			}
			FootPrint underTest = (FootPrint) obj;
			return this.row == underTest.row && this.column == underTest.column;
		}

	}
}