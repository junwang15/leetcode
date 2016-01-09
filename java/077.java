// Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(n <=0 || k > n)  return result;
        List<Integer> comb = new ArrayList<Integer>();
        dfs(n, k, result, comb, 1);
        return result;
    }
    
    private void dfs(int n, int k, List<List<Integer>> result, List<Integer> comb, int start) {
        if(comb.size() == k){
            result.add(new ArrayList<Integer>(comb));
            return;
        }
        for(int i = start; i <= n; i++) {
            comb.add(i);
            dfs(n, k, result, comb, i+1);
            comb.remove(comb.size()-1);
        }
    }
}
