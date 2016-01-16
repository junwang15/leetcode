/** Two-sum II (Sorted Array)
  * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
  **/

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0)
        int i = 0, j = nums.length - 1;
        while(i < j) {
            int sum = nums[i] + nums[j];
            if(sum == target)
                return new int[] {i+1, j+1};
            else if(sum < target)
                i++;
            else
                j--;
        }
    }
    return null;
}
