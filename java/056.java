package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals. 
 * For example, 
 * Given [1,3],[2,6],[8,10],[15,18], 
 * return [1,6],[8,10],[15,18].
 * @author jun
 *
 */

public class IntervalMerge {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() <= 1)
        	return intervals;
        Collections.sort(intervals, new IntervalComparator());
        
        List<Interval> result = new ArrayList<Interval>();
        int start 	= intervals.get(0).start;
        int end 	= intervals.get(0).end;
        for(int i = 1; i < intervals.size(); i++) {
        	Interval curr = intervals.get(i);
        	if(curr.start <= end) {
        		end = Math.max(curr.end, end);
        	} else {
        		result.add(new Interval(start, end));
        		start = curr.start;
        		end = curr.end;
        	}
        }
        result.add(new Interval(start, end)); // do not forget!
        return result;
    }
    
    class IntervalComparator implements Comparator<Interval> {
    	public int compare(Interval a, Interval b) {
    		return a.start - b.start;
    	}
    }
}
