/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> copy = new LinkedList<Interval>();
        for(Interval interval : intervals){
            copy = insert(copy, interval);
        }
        return copy;
    }
    
    private List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> result = new LinkedList<Interval>();
		if (intervals == null || intervals.size() == 0) {
			result.add(newInterval);
			return result;
		}
		int size = intervals.size();
		int overlapStartIndex = -1, overlapEndIndex = -1, firstStartLTNewIntervalEndIndex = size;
		for (int i = 0; i < intervals.size(); i++) {
			Interval currentInterval = intervals.get(i);
			if (hasOverlap(currentInterval, newInterval)) {
				overlapStartIndex = overlapStartIndex != -1 ? overlapStartIndex
                : i;
				overlapEndIndex = i;
			}
			if (currentInterval.start > newInterval.end
                && firstStartLTNewIntervalEndIndex == size) {
				firstStartLTNewIntervalEndIndex = i;
			}
		}
		if (overlapStartIndex == -1) {
			// has no overlap
			for (int i = 0; i < firstStartLTNewIntervalEndIndex; i++) {
				result.add(intervals.get(i));
			}
			result.add(newInterval);
			for (int i = firstStartLTNewIntervalEndIndex; i < size; i++) {
				result.add(intervals.get(i));
			}
		} else {
			for (int i = 0; i < overlapStartIndex; i++) {
				result.add(intervals.get(i));
			}
			Interval overlapStartInterval = intervals.get(overlapStartIndex), overlapEndInterval = intervals
            .get(overlapEndIndex);
			result.add(new Interval(Math.min(overlapStartInterval.start,
                                             newInterval.start), Math.max(overlapEndInterval.end,
                                                                          newInterval.end)));
			for (int i = overlapEndIndex + 1; i < size; i++) {
				result.add(intervals.get(i));
			}
		}
		return result;
	}
    
	private boolean hasOverlap(Interval partner1, Interval partner2) {
		return (partner1.start >= partner2.start && partner1.start <= partner2.end)
        || (partner1.end >= partner2.start && partner1.end <= partner2.end)
        || (partner1.start < partner2.start && partner1.end > partner2.end);
	}
}