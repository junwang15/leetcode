package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
Each number in C may only be used once in the combination.
Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 
 * @author jun
 *
 */

public class BackTracking {
    public List<List<Integer>> combinationSum2	(int[] candidates, int target) {
    	Set<List<Integer>> result = new HashSet<List<Integer>>();
    	if(candidates == null || candidates.length == 0)
    		return new ArrayList<List<Integer>>();
    	Arrays.sort(candidates);
    	List<Integer> tmp = new ArrayList<Integer>();
    	getComb(candidates, target, result, tmp, 0);
    	return new ArrayList<List<Integer>>(result);
    }
    
    private void getComb(int[] candidates, int target, Set<List<Integer>> result, List<Integer> curr, int index) {
    	if(target == 0) {
    		List<Integer> tmp = new ArrayList<Integer>();
    		for(int i : curr)
    			tmp.add(i);
    		result.add(tmp);
    		return;
    	}
    	if(index >= candidates.length || target < candidates[index])
    		return;
    	for(int i = index; i < candidates.length; i++) {
    		if(target < candidates[i])
    			break;
    		curr.add(candidates[i]);
    		getComb(candidates, target-candidates[i], result, curr, i+1);
    		curr.remove(curr.size() - 1);
    	}
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BackTracking bt = new BackTracking();
		int[] nums = {1,2,2};
		//System.out.println(bt.subsetsWithDup(nums));
		System.out.println(bt.combinationSum2(nums, 7));
	}
}
