package leetcode;

public class NumIslands {
    public int numIslands(int[][] grid) {
        if(grid == null || grid.length == 0)
        	return 0;
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
        	for(int j = 0; j < grid[0].length; j++) {
        		if(grid[i][j] == 1) {
        			count++;
        			merge(grid, i, j);
        		}
        	}
        }
        return count;
    }
    
    private void merge(int[][] grid, int x, int y) {
    	if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0)
    		return;
    	grid[x][y] = 0;
    	merge(grid, x-1, y);
    	merge(grid, x, y-1);
    	merge(grid, x+1, y);
    	merge(grid, x, y+1);
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
		NumIslands ni = new NumIslands();
		int[][] grid =     {{1,1,0,0,0},
							{1,1,0,0,0},
							{0,0,1,0,0},
							{0,0,0,1,1}};
		ni.printMatrix(grid);
		System.out.println(ni.numIslands(grid));
	}

}
