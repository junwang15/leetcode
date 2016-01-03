package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {	
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0)
        	return result;
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        List<Integer> lst = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++)
        	lst.add(nums[i]);
        permute(set, lst, nums.length);
        for(List<Integer> list : set)
        	result.add(list);
        return result;
    }
	
    private void permute(Set<List<Integer>> set, List<Integer> lst, int n) {
        if(n == 1) {
        	if(!set.contains(lst)) {
            	List<Integer> newList = new ArrayList<Integer>();
            	newList.addAll(lst);
                set.add(newList);
            }
            return;
        }
        for(int i = 0; i < n; i++) {
        	swap(lst, i, n-1);
            permute(set, lst, n-1);
            swap(lst, i, n-1);
        }
    }

    private void swap(List<Integer> lst, int i, int j) {
        int tmp = lst.get(i);
        lst.set(i, lst.get(j));
        lst.set(j, tmp);
    }

	private static void printList(List<Integer> lst) {
		for(Integer item : lst) 
			System.out.print(item);
		System.out.print(' ');
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Permutations pu = new Permutations();
		int[] nums = {1, 1, 2};
		List<List<Integer>> result = pu.permute(nums);
		for(List<Integer> lst :  result)
            printList(lst);
	}

}
