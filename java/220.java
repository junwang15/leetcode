/**
 * Given an array of integers, find out whether there are two distinct indices i and j in the array 
 * such that the difference between nums[i] and nums[j] is at most t and the difference between i 
 * and j is at most k.
 */

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length == 0 || k <= 0 || t < 0) 
            return false;
        TreeSet<Integer> pool = new TreeSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            int n = nums[i];
            if((pool.ceiling(n) != null &&  n >= pool.ceiling(n) - t) || 
            (pool.floor(n) != null && n <= pool.floor(n) + t)) // take care of overflow!!!
                return true;
            else
                pool.add(n);
            //maintain a sliding window with size <= k
            if(i >= k)
                pool.remove(nums[i-k]);
        }
        return false;
    }
}
