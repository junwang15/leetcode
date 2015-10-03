/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * @author Jun
 *
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0)    return false;
        int row = matrix.length;
        int col = matrix[0].length;
        if(target < matrix[0][0] || target > matrix[row - 1][col - 1])
            return false;
        // find the row
        int low = 0, high = row - 1;
        int mid = 0, midValue = 0;
        while(low <= high) {
            mid = low + (high - low) / 2;
            midValue = matrix[mid][0];
            if(midValue > target)
                high = mid - 1;
            else if(midValue < target)
                low = mid + 1;
            else
                return true;
        }
        row = target < midValue ? mid - 1 : mid;
        // find the column
        low = 0; high = col - 1; 
        while(low <= high) {
            mid = low + (high - low) / 2;
            midValue = matrix[row][mid];
            if(midValue > target)
                high = mid - 1;
            else if(midValue < target)
                low = mid + 1;
            else
                return true;
        }
        return false;
    }
}
