package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix 
 * in spiral order. 
 * For example, given the following matrix:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]]
 *  You should return [1,2,3,6,9,8,7,4,5].
 * @author jun
 *
 */

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
    	List<Integer> result = new ArrayList<Integer>();
    	if(matrix == null || matrix.length == 0)
    		return result;
    	int left = 0, up = 0, right = matrix[0].length-1, down = matrix.length-1;
    	while(left < right && up < down) {
    		for(int col = left; col < right; col++)
    			result.add(matrix[up][col]);
    		for(int row = up; row < down; row++)
    			result.add(matrix[row][right]);
    		for(int col = right; col > left; col--)
    			result.add(matrix[down][col]);
    		for(int row = down; row > up; row--)
    			result.add(matrix[row][left]);
    		left++; up++; right--; down--;
    	}
    	if(left == right) {
    		for(int row = up; row <= down; row++)
    			result.add(matrix[row][left]);
    	} else if(up == down) {
    		for(int col = left; col <= right; col++)
    			result.add(matrix[up][col]);
    	}
    	return result;
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
    	SpiralMatrix sm = new SpiralMatrix();
    	int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    	int[][] matrix2 = {{1, 2}, {4, 5}, {7, 8}};
    	int[][] matrix3 = {{1, 2, 3}, {4, 5, 6}};
    	sm.printMatrix(matrix1);
    	List<Integer> result = sm.spiralOrder(matrix1);
    	System.out.println(result.toString());
    	sm.printMatrix(matrix2);
    	result = sm.spiralOrder(matrix2);
    	System.out.println(result.toString());
    	sm.printMatrix(matrix3);
    	result = sm.spiralOrder(matrix3);
    	System.out.println(result.toString());
	}
}
