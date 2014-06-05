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
				List<Integer> footPrints = new LinkedList<Integer>();
				if (isSurrounded(i, j, board, footPrints, resultRepo)) {
					board[i][j] = 'X';
				}
			}
		}
	}

	// Just find a way to the edge
	private boolean isSurrounded(int row, int column, char[][] board,
			List<Integer> footPrints, Map<Integer, Boolean> resultRepo) {
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
		if (resultRepo.containsKey(calculate(row, column, board))) {
			return resultRepo.get(calculate(row, column, board));
		}
		footPrints.add(calculate(row, column, board));
		// check left
		if (!footPrints.contains(calculate(row, column - 1, board))) {
			result &= check(row, column - 1, board, footPrints, resultRepo);
		}
		// check right
		if (!footPrints.contains(calculate(row, column + 1, board))) {
			result &= check(row, column + 1, board, footPrints, resultRepo);
		}
		// check upper
		if (!footPrints.contains(calculate(row + 1, column, board))) {
			result &= check(row + 1, column, board, footPrints, resultRepo);
		}
		// check down
		if (!footPrints.contains(calculate(row - 1, column, board))) {
			result &= check(row - 1, column, board, footPrints, resultRepo);
		}
		return result;
	}

	private boolean check(int row, int column, char[][] board,
			List<Integer> footPrints, Map<Integer, Boolean> resultRepo) {
		boolean temp = false, result = true;
		if(resultRepo.containsKey(calculate(row, column, board))){
		    return resultRepo.get(calculate(row, column, board));
		}
		temp = isSurrounded(row, column, board, footPrints, resultRepo);
		if(temp){
		    board[row][column] = 'X';
		}
		resultRepo.put(calculate(row, column, board), temp);
		result &= temp;
		return result;
	}

    private int calculate(int row, int column, char[][] board){
        return row * board[0].length + column;
    }
}