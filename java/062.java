/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 **/
public class Solution {
	// dp solution 1
    public int uniquePaths(int m, int n) {
        if(m==0 || n==0)    return 0;
        
        int[][] paths = new int[m][n];
        for(int i=m-1; i>=0; i--)
            paths[i][n-1]=1;
        for(int j=n-1; j>=0; j--)
            paths[m-1][j]=1;
        for(int i=m-2; i>=0; i--)
            for(int j=n-2; j>=0; j--)
                paths[i][j] = paths[i+1][j] + paths[i][j+1];
        return paths[0][0];
    }

	// dp solution 2
	public int uniquePaths2(int m, int n) {
        if(m < 1 || n < 1)
        	return 0;
        int[] dp = new int[n];
        int[] dp_last = new int[n];
        for(int i = 0; i < n; i++) {
        	dp[i] = 1;
        	dp_last[i] = 1;
        }
        for(int j = 1; j < m; j++) {
        	dp[0] = 1;
        	for(int i = 1; i < n; i++) {
        		dp[i] = dp[i-1] + dp_last[i];
        		dp_last[i] = dp[i];
        	}
        }
        return dp[n-1];
    }

	// dfs solution (recursion): Time Limit Exceeded
    public int uniquePaths(int m, int n) {
        return dfs(0, 0, m, n);
    }
    
    private int dfs(int i, int j, int m, int n) {
    	if(i == m-1 && j == n-1)
    		return 1;
    	if(i < m-1 && j < n-1)
    		return dfs(i+1, j, m, n) + dfs(i, j+1, m, n);
    	if(i < m-1)
    		return dfs(i+1, j, m, n);
    	if(j < n-1)
    		return dfs(i, j+1, m, n);
    	return 0;
    }
}
