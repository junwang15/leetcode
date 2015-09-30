/**
 * Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 * For example, given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has the minimal length under the problem constraint.
 * @author Jun
 *
 */
 
 public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
    	if(nums == null || nums.length == 0) return 0;
    	int i = 0, j = 0, sum = 0, result = 0;
    	while(j < nums.length && sum < s)
    		sum += nums[j++];
    	// window size is initialized as the number of first elements whose sum >= s 
    	int wdSize = j;
    	j--;
    	
     	while(j < nums.length) {
    		if(sum >= s) {
    			if(i == j) return 1;
    			result = wdSize;
    			// try to find subarrays with shorter length
    			wdSize--;
    			sum -= nums[i++];
    		} else {
    			// slide window to right
    			if(j == nums.length - 1) break;
    			sum = sum - nums[i++] + nums[++j];
    		}
    	}
        return result;
    }
}
