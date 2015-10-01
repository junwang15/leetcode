/**
 * Given an integer array of size n, find all elements that appear more than n/3 times. The algorithm should run in linear time and in O(1) space.
 * @author Jun
 *
 */

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) return result;
        
        int c1 = 0, c2 = 0; // two counters
        Integer r1 = null, r2 = null; // two possible elements
        // find all possible elements
        for(int i : nums){
        	if(r1 != null && i == r1.intValue())
         		c1++;
         	else if(r2 != null && i == r2.intValue())
         		c2++;
         	else if(c1 == 0) {
        		r1 = i;
        		c1++;
        	} else if(c2 == 0) {
        		r2 = i;
        		c2++;
        	} else {
        		c1--;
        		c2--;
        	}
        }
        c1 = c2 = 0;
        // find true appearance of the elements
        for(int i : nums){
        	if(i == r1.intValue())
        		c1++;
        	else if(i == r2.intValue())
        		c2++;
        }
        // add the selected elements to result
        if(c1 > nums.length/3) result.add(r1);
        if(c2 > nums.length/3) result.add(r2);
        return result;        
    }
}
