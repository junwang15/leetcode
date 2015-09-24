//Rotate an array of n elements to the right by k steps.
public class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0) return;
        k = k % nums.length;
        if(k == 0) return;
        
        inverse(nums, 0, nums.length-k-1);
        inverse(nums, nums.length-k, nums.length-1);
        inverse(nums, 0, nums.length-1);
    }
    
    private void inverse(int[] nums, int left, int right) {
        while(left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++; right--;
        }
    }
}
