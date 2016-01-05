package leetcode;

public class ImageRotation {
    public void rotate(int[][] matrix) {
    	if(matrix == null || matrix.length == 0 || matrix.length != matrix[0].length)
    		return;
    	int n = matrix.length;
    	int left = 0, right = n - 1;
    	while(left < right) {
    		for(int i = left; i < right; i++)
    			rotateImagePix(matrix, left, i);
    		left++;
    		right--;
    	}
    }
    
    private void rotateImagePix(int[][] matrix, int x, int y){
    	int n = matrix.length;
    	int tmp = matrix[x][y];   	
    	matrix[x][y] = matrix[n-1-y][x];
    	matrix[n-1-y][x] = matrix[n-1-x][n-1-y];    
    	matrix[n-1-x][n-1-y] = matrix[y][n-1-x];  		
    	matrix[y][n-1-x] = tmp;
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
		ImageRotation ir = new ImageRotation();
		int[][] matrix = {{1,2,3}, {3,4,5},{6,7,8}};
		ir.printMatrix(matrix);
		ir.rotate(matrix);
		ir.printMatrix(matrix);
	}

}
