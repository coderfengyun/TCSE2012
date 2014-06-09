package org.tcse.algorithm;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class Permutation2 {
	private List<Set<Integer>> duplications = new ArrayList<Set<Integer>>();

	public List<List<Integer>> permute(int[] num) {
		if (num == null || num.length == 0) {
			return new LinkedList<List<Integer>>();
		}
		Arrays.sort(num);
		buildUpDuplications(num);
		return permute0(0, num, new LinkedList<Integer>(),
				new LinkedList<Integer>());
	}

	private void buildUpDuplications(int[] num) {
		this.duplications.add(new HashSet<Integer>(0));
		for (int i = 1; i < num.length; i++) {
			this.duplications.add(new HashSet<Integer>());
			if (num[i] == num[i - 1]) {
				this.duplications.get(i).addAll(this.duplications.get(i - 1));
				this.duplications.get(i).add(i - 1);
			}
		}

	}

	private List<List<Integer>> permute0(int begin, int[] num,
			List<Integer> partResult, List<Integer> occupiedIndexs) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		if (begin >= num.length) {
			return result;
		}
		for (int i = 0; i < num.length; i++) {
			if (occupiedIndexs.contains(i)) {
				continue;
			}
			if (hasDuplicationsBeforeExceptUsed(occupiedIndexs, i, num)) {
				continue;
			}
 			List<Integer> tempResult = new LinkedList<Integer>(partResult), tempPickedIndex = new LinkedList<Integer>(
					occupiedIndexs);
			tempResult.add(num[i]);
			tempPickedIndex.add(i);
			List<List<Integer>> lowerResult = permute0(begin + 1, num,
					tempResult, tempPickedIndex);
			if (lowerResult.isEmpty()) {
				result.add(tempResult);
			}
			result.addAll(lowerResult);
		}
		return result;
	}

	private boolean hasDuplicationsBeforeExceptUsed(
			List<Integer> occupiedIndex, int i, int[] num) {
		Set<Integer> duplicationsBefore = this.duplications.get(i);
		duplicationsBefore.removeAll(occupiedIndex);
		return !duplicationsBefore.isEmpty();
	}

	@Test
	public void test() {
		Permutation2 so = new Permutation2();
		List<List<Integer>> result = so.permute(new int[] { 0, 1, 0 });
		assertEquals(3, result.size());
	}
}
