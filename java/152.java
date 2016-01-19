/*
Maximum product subarray
Find the contiguous subarray within an array (containing at least one number) which has the largest product.
For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
*/

public class Solution {
    public int maxProduct(int[] nums) {
    	if(nums == null || nums.length == 0)
    		return 0;
    	int max = nums[0], min = nums[0], result = nums[0];
    	for(int i = 1 ; i < nums.length; i++) {
    		if(nums[i] > 0) {
    			max = Math.max(max * nums[i], nums[i]);
    			min = Math.min(min * nums[i], nums[i]);
    		} else {
    			int lastMax = max;
    			max = Math.max(min * nums[i], nums[i]);
    			min = Math.min(lastMax * nums[i], nums[i]);
    		}
    		result = Math.max(result, max);
    	}
        return result;
    }
}
