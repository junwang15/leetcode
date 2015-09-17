public class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length < 1 || target < nums[0]) return 0;
        if(target > nums[nums.length - 1])  return nums.length;
        
        int left = 0, right = nums.length;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if      (nums[mid] < target)    left = mid + 1;
            else if (nums[mid] > target)    right = mid;
            else    return mid;
        }
        return left;
    }
}

// solution 2 (faster)
public class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums.length < 1 || target < nums[0]) return 0;
        if(target > nums[nums.length - 1])  return nums.length;
        
        int left = 0, right = nums.length, mid = 0;
        while(left <= right) {
            mid = left + (right - left) / 2;
            if      (nums[mid] < target)    left = mid + 1;
            else if (nums[mid] > target)    right = mid - 1;
            else    return mid;
        }
        return target > nums[mid] ? mid + 1: mid;
    }
}
