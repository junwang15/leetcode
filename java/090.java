package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
Given a collection of integers that might contain duplicates, nums, return all possible subsets.
Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,2], a solution is:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 * @author jun
 *
 */

public class BackTracking {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
		if(nums == null || nums.length == 0)
			return new ArrayList<List<Integer>>();
    	Set<List<Integer>> set = new HashSet<List<Integer>>();
		Arrays.sort(nums);
		for(int i : nums) {
			List<List<Integer>> tmp = new ArrayList<List<Integer>>();
			for(List<Integer> subset : set)
				tmp.add(new ArrayList<Integer>(subset));
			for(List<Integer> subset : tmp)
				subset.add(i);			
			List<Integer> single = new ArrayList<Integer>();
			single.add(i);
			tmp.add(single);
			set.addAll(tmp);
		}
		set.add(new ArrayList<Integer>());
		List<List<Integer>> result = new ArrayList<List<Integer>>(set);
		return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BackTracking bt = new BackTracking();
		int[] nums = {2,2,1};
		List<List<Integer>> result = bt.subsetsWithDup(nums);
		System.out.println(result);
	}
}
