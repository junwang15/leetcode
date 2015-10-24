/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 **/

public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid == null)
            return 0;
        int m, n;
        if((m = grid.length) == 0)
            return 0;
        if((n = grid[0].length) == 0)
            return 0;
        int[][] pathSum = new int[m][n];
        pathSum[m-1][n-1] = grid[m-1][n-1];
        for(int i=m-2; i>=0; i--)
            pathSum[i][n-1] = grid[i][n-1] + pathSum[i+1][n-1];
        for(int j=n-2; j>=0; j--)
            pathSum[m-1][j] = grid[m-1][j] + pathSum[m-1][j+1];
        for(int i=m-2; i>=0; i--)
            for(int j=n-2; j>=0; j--)
                pathSum[i][j] = grid[i][j] + Math.min(pathSum[i+1][j], pathSum[i][j+1]);
        return pathSum[0][0];
    }
}
