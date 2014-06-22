public class Solution {
    private enum Direction {
		HORIZON, VERTICAL;
		public Direction Change() {
			if (this.equals(HORIZON)) {
				return VERTICAL;
			} else {
				return HORIZON;
			}
		}
	}

	private enum HorizonDirection {
		LEFT_TO_RIGHT, RIGHT_TO_LEFT;
		public HorizonDirection Change() {
			if (this.equals(LEFT_TO_RIGHT)) {
				return RIGHT_TO_LEFT;
			} else {
				return LEFT_TO_RIGHT;
			}
		}
	}

	private enum VerticalDirection {
		TOP_TO_BOTTOM, BOTTOM_TO_TOP;
		public VerticalDirection Change() {
			if (this.equals(TOP_TO_BOTTOM)) {
				return BOTTOM_TO_TOP;
			} else {
				return TOP_TO_BOTTOM;
			}
		}
	}

	private static class DirectionWrapper {
		public Direction mainDirection = Direction.HORIZON;
		public HorizonDirection currentHorizon = HorizonDirection.LEFT_TO_RIGHT;
		public VerticalDirection currentVertical = VerticalDirection.TOP_TO_BOTTOM;

		public void change() {
			if (mainDirection.equals(Direction.HORIZON)) {
				this.currentHorizon = currentHorizon.Change();
			} else {
				this.currentVertical = currentVertical.Change();
			}
			this.mainDirection = mainDirection.Change();
		}
	}

	private static class Range {
		public int lowerBound;
		public int upperBound;

		public Range(int lowerBound, int upperBound) {
			this.lowerBound = lowerBound;
			this.upperBound = upperBound;
		}

		public boolean isLegal() {
			return this.upperBound >= this.lowerBound;
		}
	}

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new LinkedList<Integer>();
		if (matrix == null || matrix.length == 0) {
			return result;
		}
		int horizonIndex = 0, verticalIndex = 0;
		DirectionWrapper currentDirection = new DirectionWrapper();
		Range horizonRange = new Range(0, matrix[0].length - 1), verticalRange = new Range(
				0, matrix.length - 1);

		while (horizonRange.isLegal() && verticalRange.isLegal()) {
			result.add(matrix[verticalIndex][horizonIndex]);
			if (currentDirection.mainDirection.equals(Direction.HORIZON)) {
				if (currentDirection.currentHorizon
						.equals(HorizonDirection.LEFT_TO_RIGHT)) {
					if (horizonIndex == horizonRange.upperBound) {
						currentDirection.change();
						verticalRange.lowerBound++;
						verticalIndex++;
					} else {
						horizonIndex++;
					}
				} else {
					if (horizonIndex == horizonRange.lowerBound) {
						currentDirection.change();
						verticalRange.upperBound--;
						verticalIndex--;
					} else {
						horizonIndex--;
					}
				}
			} else {
				if (currentDirection.currentVertical
						.equals(VerticalDirection.TOP_TO_BOTTOM)) {
					if (verticalIndex == verticalRange.upperBound) {
						currentDirection.change();
						horizonRange.upperBound--;
						horizonIndex--;
					} else {
						verticalIndex++;
					}
				} else {
					if (verticalIndex == verticalRange.lowerBound) {
						currentDirection.change();
						horizonRange.lowerBound++;
						horizonIndex++;
					} else {
						verticalIndex--;
					}
				}
			}
		}
		return result;
	}
}