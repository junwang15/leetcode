/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * For example, given [3,2,1,5,6,4] and k = 2, return 5.
 * Note: You may assume k is always valid, 1 ≤ k ≤ array's length.
 * @author Jun
 */

public class Solution {
    public int findKthLargest(int[] nums, int k) {
    	if(k < 1 || nums == null) return 0;
    	// the kth largest element equals the (nums.length-k+1)th smallest element
    	return getKth(nums, nums.length - k + 1, 0, nums.length - 1);
    }
    
    // get the kth element in subarray of nums, from start to end.
    private int getKth(int[] nums, int k, int start, int end) {
    	int pivot = nums[end];
    	int left = start, right = end;
    	while(left < right) {
    		while(nums[left] < pivot && left < right)
    			left++;
    		while(nums[right] >= pivot && left < right)
    			right--;
    		swap(nums, left, right);
    	}    	
    	swap(nums, left, end); // pivot is the (left+1)th element in nums
    	
    	if(k == left + 1)
    		return pivot;
    	else if(k < left + 1)
    		return getKth(nums, k, start, left - 1);
    	else
    		return getKth(nums, k, left + 1, end);
    }
    
    private void swap(int[] nums, int i, int j){
    	int tmp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = tmp;
    }
}
