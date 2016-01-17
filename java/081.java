/** search in a rotated array
 * Follow up for "Search in Rotated Sorted Array": What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 **/

public class Solution {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return false;
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(nums[mid] == target)
                return true;
            if(nums[left] < nums[mid]) {
                if(nums[left] <= target && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            } else if(nums[left] > nums[mid]){
                if(nums[right] >= target && target > nums[mid])
                    left = mid + 1;
                else
                    right = mid - 1;
            } else {
                left++;	//ATENTION!
            }
        }
        return false;
    }
}

// special case: {1,3,1,1,1}
