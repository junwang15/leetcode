package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	private List<List<Integer>> result = new ArrayList<List<Integer>>();;
	
	public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0)
        	return result;
        ArrayList<Integer> lst = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++)
        	lst.add(nums[i]);
        permute(lst, nums.length);
        return result;
    }
	
    private void permute(List<Integer> lst, int n) {
        if(n == 1) {
        	List<Integer> newList = new ArrayList<Integer>();
        	newList.addAll(lst);
            result.add(newList);
            return;
        }
        for(int i = 0; i < n; i++) {
        	swap(lst, i, n-1);
            permute(lst, n-1);
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
		int[] nums = {1, 2, 3};
		List<List<Integer>> result = pu.permute(nums);
		for(List<Integer> lst :  result)
            printList(lst);
	}

}
