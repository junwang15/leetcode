/**
Print all unique combination of factors (except 1) of a given number.
For example:
Input: 12
Output: [[2, 2, 3], [2, 6], [3, 4]]
Input: 15
Output: [[3, 5]]
Input: 28
Output: [[2, 2, 7], [2, 14], [4, 7]]
**/


// backtracking
public List<List<Integer>> getFactors(int n) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if (n <= 3) return result;
    helper(n, -1, result, new ArrayList<Integer>());
    return result; 
}

private void helper(int n, int lower, List<List<Integer>> result, List<Integer> curr) {
	if(lower != -1) {
		curr.add(n);
		result.add(new ArrayList<Integer>(curr));
		curr.remove(curr.size() - 1);
	}

	for(int i = Math.max(2, lower); i <= n/i; i++) {
		if(n%i == 0) {
			curr.add(i);
			helper(n/i, i, result, curr);
			curr.remove(curr.size() - 1);
		}
	}
}
