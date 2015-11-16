/**
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 **/

public class NumMatrix {
    private int[][] sum; // sum[i][j] is the sum from nums[0][0] to nums[i+1][j+1]
    
    public NumMatrix(int[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return;

		int row = matrix.length;
		int col = matrix[0].length;

        sum = new int[row+1][col+1];
		for(int r = 1; r <= row; r++)
			for(int c = 1; c <= col; c++)
				sum[r][c] = sum[r][c-1] + sum[r-1][c] - sum[r-1][c-1] + matrix[r-1][c-1];
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2+1][col2+1] - sum[row1][col2+1] - sum[row2+1][col1] + sum[row1][col1];
    }

    public static void main(String[] args) {
        int[][] aMatrix = {
	        {3, 0, 1, 4, 2},
  	        {5, 6, 3, 2, 1},
  	        {1, 2, 0, 1, 5},
          	{4, 1, 0, 1, 7},
          	{1, 0, 3, 0, 5}
            };
        NumMatrix nm = new NumMatrix(aMatrix);
        System.out.println(nm.sumRegion(0,0,0,0));
        System.out.println(nm.sumRegion(0,0,0,1));
        System.out.println(nm.sumRegion(2,1,4,3));
        System.out.println(nm.sumRegion(1,1,2,2));
        System.out.println(nm.sumRegion(1,2,2,4));
    }
}
