package week10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class MergeInterval {
	public List<Interval> merge(List<Interval> intervals) {
		if (intervals == null) {
			return null;
		}
		if (intervals.size() == 0) {
			return new ArrayList<Interval>();
		}
		Collections.sort(intervals, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});
		Stack<Integer> numbers = new Stack<Integer>();
		for (Interval interval : intervals) {
			if (numbers.isEmpty() || interval.start > numbers.peek()) {
				numbers.push(interval.start);
				numbers.push(interval.end);
			} else {
				int top = numbers.pop();
				numbers.push(interval.end > top ? interval.end : top);
			}
		}

		Stack<Integer> numbers2 = new Stack<Integer>();
		while (!numbers.isEmpty()) {
			numbers2.push(numbers.pop());
		}

		List<Interval> result = new ArrayList<Interval>();

		while (!numbers2.isEmpty()) {
			result.add(new Interval(numbers2.pop(), numbers2.pop()));
		}
		return result;
	}

	public static class Interval {
		@Override
		public String toString() {
			return "Interval [start=" + start + ", end=" + end + "]";
		}

		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

	public static void main(String[] args) {
		MergeInterval solution = new MergeInterval();
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1, 3));
		intervals.add(new Interval(2, 4));
		System.out.println(solution.merge(intervals));
	}
}
