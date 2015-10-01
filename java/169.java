/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times. 
 * You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class Solution {
  public int majorityElement(int[] nums) {
      Arrays.sort(nums);
      return nums[nums.length/2];
  }
}

/** solution 2
 * A Linear Time Majority Vote Algorithm
 * http://www.cs.utexas.edu/~moore/best-ideas/mjrty/
 */
public class Solution {
    public int majorityElement(int[] nums) {
        int result = 0, count = 0;
        for(int i: nums){
            if(count == 0) {
                result = i;
                count++;
            }else if(i == result)
                count++;
            else
                count--;
        }
        return result;
    }
}
