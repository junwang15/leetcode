import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 * @author jun
 *
 */

public class SummaryRanges {
    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList();
        if(nums == null || nums.length == 0)
        	return result;        
        if(nums.length == 1)
        	result.add(nums[0] + "");
        
        int start = 0, end = 0;
        for(int i = 1; i < nums.length; i++) {
        	if(nums[i] == nums[end]+1) {
        		if(i == nums.length-1)
        			result.add(nums[start] + "->" + nums[i]);
        	} else {
        		if(start != end)
        			result.add(nums[start] + "->" + nums[end]);
        		else
        			result.add(nums[end] + "");
        		if(i == nums.length-1)
        			result.add(nums[i] + "");
        		start = i;
        	}
        	end = i;
        }
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] anArray = {0,1,2,4,6,7,9};
		//int[] anArray = {0,2};
		System.out.println(summaryRanges(anArray));
	}
}