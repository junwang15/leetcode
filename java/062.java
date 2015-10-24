/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 **/
public class Solution {
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
}
