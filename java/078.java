package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets.
Note: Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 * @author jun
 *
 */

public class BackTracking {
	// solution 1
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(nums == null || nums.length == 0)
			return result;
		Arrays.sort(nums);
        for(int len = 0; len <= nums.length; len++) {
        	List<Integer> item = new ArrayList<Integer>();
        	getSubset(nums, result, item, len, 0);
        }
        return result;
    }
	
	private void getSubset(int[] nums, List<List<Integer>> result, List<Integer> item, int len, int index) {
		if(item.size() == len) {
			List<Integer> tmp = new ArrayList<Integer>(item);
			result.add(tmp);
			return;
		}
		for(int i = index; i < nums.length; i++) {
			item.add(nums[i]);
			getSubset(nums, result, item, len, i+1);
			item.remove(item.size()-1);
		}
	}
	
	// solution2 (faster)
    public List<List<Integer>> subsets2(int[] nums) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(nums == null || nums.length == 0)
			return result;
		Arrays.sort(nums);
		for(int i : nums) {
			List<List<Integer>> tmp = new ArrayList<List<Integer>>();
			for(List<Integer> subset : result)
				tmp.add(new ArrayList<Integer>(subset));

			for(List<Integer> subset : tmp)
				subset.add(i);
			
			List<Integer> single = new ArrayList<Integer>();
			single.add(i);
			tmp.add(single);

			result.addAll(tmp);
		}
		result.add(new ArrayList<Integer>());
		return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BackTracking bt = new BackTracking();
		int[] nums = {3,2,1};
		List<List<Integer>> result = bt.subsets(nums);
		System.out.println(result);
	}
}
