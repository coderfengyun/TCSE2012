package week10;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		if (matrix == null) {
			return null;
		}
		List<Integer> result = new ArrayList<Integer>();
		if (matrix.length == 0) {
			return result;
		}

		int m = matrix.length, n = matrix[0].length;
		int seperator = (m % 2 == 0 ? (m / 2 - 1) : m / 2);
		for (int i = 0; i <= seperator; i++) {
			if (i > n - 1 - i) {
				break;
			}
			// top
			for (int cursor = i; cursor <= n - 1 - i; cursor++) {
				result.add(matrix[i][cursor]);
			}
			// right
			for (int cursor = i + 1; cursor <= m - 1 - i && n - 1 - i >= 0; cursor++) {
				result.add(matrix[cursor][n - 1 - i]);
			}

			// bottom
			for (int cursor = n - 2 - i; cursor >= i && m - 1 - i > i; cursor--) {
				result.add(matrix[m - 1 - i][cursor]);
			}

			// left
			for (int cursor = m - 2 - i; cursor > i && i < n - 1 - i; cursor--) {
				result.add(matrix[cursor][i]);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		SpiralMatrix sprial = new SpiralMatrix();
		System.out.println(sprial.spiralOrder(new int[][] { { 1, 2, 3, 4 },
				{ 5, 6, 7, 8 } }));
	}
}
