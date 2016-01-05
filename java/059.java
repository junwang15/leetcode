package leetcode;

/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order. 
 * For example, given n = 3, 
 * You should return the following matrix:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 * @author jun
 *
 */

public class SpiralMatrix {
    private void printMatrix(int[][] matrix) {
    	for(int i = 0; i < matrix.length; i++) {
    		for(int j = 0; j < matrix[0].length; j++)
    			System.out.print(matrix[i][j]);
    		System.out.println();
    	}
    }
    
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if(n < 1)
        	return matrix;
        int lower = 0, upper = n-1;
        int i = 1;
        while(lower < upper) {
        	for(int col = lower; col < upper; col++)
        		matrix[lower][col] = i++;
        	for(int row = lower; row < upper; row++)
        		matrix[row][upper] = i++;
        	for(int col = upper; col > lower; col--)
        		matrix[upper][col] = i++;
        	for(int row = upper; row > lower; row--)
        		matrix[row][lower] = i++;
        	lower++; upper--;
        }
        if(lower == upper)
        	matrix[lower][upper] = i;
        return matrix;
    }
	
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	SpiralMatrix sm = new SpiralMatrix();   	
    	sm.printMatrix(sm.generateMatrix(3));
	}

}
