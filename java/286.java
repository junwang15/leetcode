package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given a m x n 2D grid initialized with these three possible values.
-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
For example, given the 2D grid:
INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
 After running your function, the 2D grid should be:
  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4
 * @author jun
 *
 */
public class WallsGates {
	public void wallsAndGates(int[][] rooms) {
		if(rooms == null || rooms.length == 0 || rooms[0].length == 0)
			return;
		int m = rooms.length, n = rooms[0].length;
		Queue<int[]> queue = new LinkedList<int[]>();
		for(int i = 0; i < m; i++)
			for(int j = 0; j < n; j++)
				if(rooms[i][j] == 0)
					queue.add(new int[] {i, j});
		int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		while(!queue.isEmpty()) {
			int[] temp = queue.remove();
			int distance = rooms[temp[0]][temp[1]];
			for(int[] dir : directions) {
				int newX = dir[0]+temp[0], newY = dir[1]+temp[1];
				if(newX>=0 && newX<m && newY>=0 && newY<n && rooms[newX][newY]>distance) {
					rooms[newX][newY] = distance + 1;
					queue.offer(new int[] {newX, newY});
				}
			}
		}
	}
	
	private void printMatrix(int[][] matrix) {
    	for(int i = 0; i < matrix.length; i++) {
    		for(int j = 0; j < matrix[0].length; j++){
    			System.out.print(matrix[i][j]);
    			System.out.print(' ');
    		}
    		System.out.println();
    	}
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WallsGates wg = new WallsGates();
		int inf = Integer.MAX_VALUE;
		int[][] matrix={{inf, -1, 0, inf}, {inf, inf, inf, -1}, {inf, -1, inf, -1}, {0, -1, inf, inf}};
		wg.wallsAndGates(matrix);
		wg.printMatrix(matrix);
	}

}
