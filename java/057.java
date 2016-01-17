package leetcode;
import java.util.*;


public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<Interval>();
        
        for(Interval i : intervals) {
            if(i.end < newInterval.start) {
                result.add(i);
            } else if(i.start > newInterval.end) {
                result.add(newInterval);
                newInterval = i;
            } else if (i.start <= newInterval.end || i.end >= newInterval.start) {
                newInterval = new Interval(Math.min(i.start, newInterval.start), Math.max(i.end, newInterval.end));
            }
        }
        result.add(newInterval);
        return result;
    }
    
    private void printIntervals(List<Interval> intList) {
    	for(Interval i : intList) {
    		System.out.print("[" + i.start + "," + i.end + "] ");
    	}
    	System.out.println();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1,2));
		intervals.add(new Interval(3,5));
		intervals.add(new Interval(8,9));
		Interval newInterval = new Interval(4,7);
		InsertInterval ii = new InsertInterval();
		List<Interval> result = new ArrayList<Interval>();
		result = ii.insert(intervals, newInterval);
		ii.printIntervals(intervals);
		ii.printIntervals(result);
	}

}
