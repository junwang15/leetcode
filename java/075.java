/**
 * Given an array with n objects colored red, white or blue, sort them so that 
 * objects of the same color are adjacent, with the colors in the order red, 
 * white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white,
 * and blue respectively.
 **/
public class Solution {
    public void sortColors(int[] nums) {
        int left = 0, right = 0;
        for(int color = 0; color < 3; color++) {
            for(right = left; right < nums.length; right++) {
                if(nums[right] == color)
                    swap(nums, left++, right);
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        if(nums == null || i > nums.length || j > nums.length)
            return;
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
