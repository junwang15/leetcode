/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand. (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2). 
 * You are given a target value to search. If found in the array return its index, otherwise return -1. 
 * You may assume no duplicate exists in the array.
 * @author Jun
 */
 
public class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
        	int mid = left + (right - left)/2;
        	if(target == nums[mid]) return mid;
        	if(nums[mid] >= nums[left]) {
        		if(target > nums[mid])	
        			left = mid + 1;
        		else if(target >= nums[left])
        			right = mid - 1;
        		else
        			left = mid + 1;
        	} else {
        		if(target < nums[mid])
        			right = mid - 1;
        		else if(target <= nums[right])
        			left = mid + 1;
        		else
        			right = mid - 1;
        	}
        }
        return -1;       
    }
}
