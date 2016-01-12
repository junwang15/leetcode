package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
 * determine if a person could attend all meetings. 
 * For example, given [[0, 30],[5, 10],[15, 20]], return false.
 * @author jun
 *
 */
public class MeetingRooms {
	class IntervalComparator implements Comparator<Interval> {
		public int compare(Interval a, Interval b){
			return a.start - b.start;
		}
	}
	public boolean canAttendMeetings(Interval[] intervals) {
		Arrays.sort(intervals, new IntervalComparator());
		/**
		 * In Java 8, you can write comparator like this
		 * Arrays.sort(intervals, (x, y) -> x.start - y.start);
		 */
		for(int i = 1; i < intervals.length; i++) {
			if(intervals[i].start < intervals[i-1].end)
				return false;
		}
		return true;
	}
}
