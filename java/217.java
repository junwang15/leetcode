/**
 * Given an array of integers, find if the array contains any duplicates. Your function should return true if 
 * any value appears at least twice in the array, and it should return false if every element is distinct.
 */
public class Solution {
  public boolean containsDuplicate(int[] nums) {
      if(nums == null || nums.length == 0) return false;
      Set<Integer> pool = new HashSet<Integer>();
      for(int i : nums) {
          if(!pool.contains(i))
              pool.add(i);
          else
              return true;
      }
      return false;
  }
}

// a better solution
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        Set<Integer> pool = new HashSet<Integer>();
        for(int i : nums) {
            if(!pool.add(i))
                return true;
        }
        return false;
    }
}
