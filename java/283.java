/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order 
 * of the non-zero elements.
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 */
 
public class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length < 1)
            return;
        int p1 = 0, p2 = 0;
        while(p1 < nums.length) {
            if(nums[p1++] != 0)
                nums[p2++] = nums[p1 - 1];
        }
        while(p2 < nums.length)
            nums[p2++] = 0;
        return;
    }
}
