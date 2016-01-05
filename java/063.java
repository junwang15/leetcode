package leetcode;
/**
 * Follow up for "Unique Paths": 
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid. 
 * For example, 
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0],
 * ]
 * The total number of unique paths is 2.
 * Note: m and n will be at most 100.
 * @author jun
 *
 */
public class UniquePaths {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	if(obstacleGrid == null || obstacleGrid.length == 0)
    		return 0;
    	int m = obstacleGrid.length, n = obstacleGrid[0].length;
    	int[] dp = new int[n], dp_last = new int[n];
        for(int i = 0; i < n; i++) {
        	if(obstacleGrid[0][i] == 1)
        		break;
        	dp_last[i] = dp[i] = 1;
        }
        for(int j = 1; j < m; j++) {
    		dp_last[0] = dp[0] = obstacleGrid[j][0] == 1 ? 0 : dp_last[0];
        	for(int i = 1; i < n; i++) {
        		dp_last[i] = dp[i] = obstacleGrid[j][i] == 1 ? 0 : dp[i-1] + dp_last[i];
        	}
        }
        return dp[n-1];
    }
    
    private void printMatrix(int[][] matrix) {
    	for(int i = 0; i < matrix.length; i++) {
    		for(int j = 0; j < matrix[0].length; j++)
    			System.out.print(matrix[i][j]);
    		System.out.println();
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniquePaths up = new UniquePaths();
		int[][] matrix = {{0,0,0},{1,0,1},{0,0,0}};
		up.printMatrix(matrix);
		System.out.println(up.uniquePathsWithObstacles(matrix));
	}

}
