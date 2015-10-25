/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * For example, 
 * Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
 * 
 */ 

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null ||nums.length == 0)
        	return nums;
        int idx, start, end;
        if((idx = binarySearch(nums, target)) < 0)
        	return new int[] {-1,-1};
        start = end = idx;
        while(start >= 0 && nums[start] == target)
        	start--;
        while(end < nums.length && nums[end] == target)
        	end++;
        return new int[] {start+1, end-1};
    }
    
    private int binarySearch(int[] nums, int target) {
    	int left = 0, right = nums.length-1;
    	while(left <= right) {
    		int mid = left + (right - left)/2;
    		if(nums[mid] > target)
    			right = mid - 1;
    		else if(nums[mid] < target)
    			left = mid + 1;
    		else
    			return mid;
    	}
    	return -1;
    }
}
