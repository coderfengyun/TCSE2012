public class Solution {
  public int threeSumClosest(int[] num, int target) {
		int[] arrayAfterSort = sort(num);
		int result = Integer.MAX_VALUE;
		int indexOfJustGEtarget = indexOfJustGEtarget(target, arrayAfterSort,
				-1, -1);
		// LeftSide
		for (int i = indexOfJustGEtarget; i >= 0; i--) {
			result = whichCloser(
					target,
					result,
					towSumClosest(i, arrayAfterSort, target - arrayAfterSort[i])
							+ arrayAfterSort[i]);
		}
		// RightSide
		for (int i = indexOfJustGEtarget + 1; i < arrayAfterSort.length; i++) {
			result = whichCloser(
					target,
					result,
					towSumClosest(i, arrayAfterSort, target - arrayAfterSort[i]));
		}
		return result;
	}

	private int whichCloser(int target, int param1, int param2) {
		return getDistance(target, param1) > getDistance(target, param2) ? param2
				: param1;
	}

	private int getDistance(int target, int param1) {
		return (target - param1) > 0 ? target - param1 : param1 - target;
	}

	private int indexOfJustGEtarget(int target, int[] arrayAfterSort,
			int firstIndexCannotBeUsed, int secondIndexCannotBeUsed) {
		int i = 0;
		for (; i < arrayAfterSort.length; i++) {
			if (i == firstIndexCannotBeUsed || i == secondIndexCannotBeUsed) {
				continue;
			}
			if (arrayAfterSort[i] >= target)
				break;
		}
		return i == arrayAfterSort.length ? i - 1 : i;
	}

	// find twoSumClosest from num, target is num[index], and the index can't be
	// used.
	private int towSumClosest(final int firstLoopIndex, int[] arrayAfterSort,
			int realTarget) {
		int result = Integer.MAX_VALUE;
		int indexJustGETarget = indexOfJustGEtarget(realTarget, arrayAfterSort,
				firstLoopIndex, -1);
		// Left side
		for (int i = indexJustGETarget; i >= 0; i--) {
			if (i == firstLoopIndex) {
				continue;
			}
			result = whichCloser(realTarget, result,
					oneClosest(firstLoopIndex, i, arrayAfterSort, realTarget)
							+ arrayAfterSort[i]);
		}
		return result;
	}

	private int oneClosest(int firstLoopIndex, int secondLoopIndex,
			int[] arrayAfterSort, int realTarget) {
		int indexJustGETarget = indexOfJustGEtarget(realTarget, arrayAfterSort,
				firstLoopIndex, secondLoopIndex);
		int indexJustLETarget = -1;
		// Just find Left side one
		for (int i = indexJustGETarget - 1; i >= 0
				&& i >= indexJustGETarget - 3; i--) {
			if (i == firstLoopIndex || i == secondLoopIndex) {
				continue;
			}
			indexJustLETarget = i;
			break;
		}

		if (indexJustLETarget == -1) {
			return arrayAfterSort[indexJustGETarget];
		} else if (indexJustGETarget == arrayAfterSort.length) {
			return arrayAfterSort[indexJustLETarget];
		} else {
			return getDistance(realTarget, arrayAfterSort[indexJustLETarget]) < getDistance(
					realTarget, arrayAfterSort[indexJustGETarget]) ? arrayAfterSort[indexJustLETarget]
					: arrayAfterSort[indexJustGETarget];
		}
	}

	private int[] sort(int[] num) {
		for (int j = 1; j <= num.length - 1; j++) {
			for (int i = 0; i < num.length - j; i++) {
				if (num[i] > num[i + 1]) {
					int temp = num[i + 1];
					num[i + 1] = num[i];
					num[i] = temp;
				}
			}
		}
		return num;
	}
}