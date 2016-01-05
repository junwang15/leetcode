package leetcode;
/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * @author jun
 *
 */

public class SetZeroes {
    public void setZeroes(int[][] matrix) {
    	if(matrix == null || matrix.length == 0)
    		return;
    	int m = matrix.length, n = matrix[0].length;
    	boolean firstRowHasZero = false, firstColHasZero = false;
    	for(int i = 0; i < m ; i++) {
    		if(matrix[i][0] == 0) {
    			firstColHasZero = true;
    			break;
    		}
    	}
    	for(int i = 0; i < n; i++) {
    		if(matrix[0][i] == 0) {
    			firstRowHasZero = true;
    			break;
    		}
    	}
    	for(int i = 1; i < m; i++) {
    		for(int j = 1; j < n; j++) {
    			if(matrix[i][j] == 0) {
    				matrix[0][j] = 0;
    				matrix[i][0] = 0;
    			}
    		}
    	}
    	for(int i = 1; i < m; i++) {
    		if(matrix[i][0] == 0)
    			fillRowWithZeros(i, matrix);
    	}
    	for(int j = 1; j < n; j++) {
    		if(matrix[0][j] == 0)
    			fillColWithZeros(j, matrix);
    	}
    	if(firstRowHasZero)
    		fillRowWithZeros(0, matrix);
    	if(firstColHasZero)
    		fillColWithZeros(0, matrix);
    }
    
    private void fillRowWithZeros(int r, int[][] m) {
    	for(int i = 0; i < m[0].length; i++)
    		m[r][i] = 0;
    }
    
    private void fillColWithZeros(int c, int[][] m) {
    	for(int i = 0; i < m.length; i++)
    		m[i][c] = 0;
    }
    
    
    private void printMatrix(int[][] matrix) {
    	for(int i = 0; i < matrix.length; i++) {
    		for(int j = 0; j < matrix[0].length; j++)
    			System.out.print(matrix[i][j]);
    		System.out.println();
    	}
    }
    
    public static void main(String[] args) {
    	SetZeroes sz = new SetZeroes();
    	int[][] matrix = {{0, 2, 3}, {2, 1, 0}, {3, 2,1}};
    	sz.printMatrix(matrix);
    	sz.setZeroes(matrix);
    	sz.printMatrix(matrix);
    }
}
