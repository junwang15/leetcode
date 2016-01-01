import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move
 *  to adjacent numbers on the row below.
 *  For example, given the following triangle 
 *  [
 *  	[2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 *  ]
 *  The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * @author jun
 *
 */
public class MinimumTotal {
	public static int minimumTotal(List<List<Integer>> triangle) {
		int len = triangle.size();
		int[] sum = new int[len];
		sum[0] = triangle.get(0).get(0);
		for(int row = 1; row < len; row++) {
			List<Integer> lst = triangle.get(row);
			sum[row] = sum[row-1] + lst.get(row);
			for(int i = row - 1; i > 0; i--)
				sum[i] = lst.get(i) + Math.min(sum[i], sum[i-1]);
			sum[0] += lst.get(0);
			System.out.println(Arrays.toString(sum));
		}
		// find the minimum in array sum
		int min = sum[0];
		for(int i = 1; i < len; i++)
			if(min > sum[i])
				min = sum[i];
		return min;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> lst1 = new ArrayList<Integer>();
		lst1.add(2);
		ArrayList<Integer> lst2 = new ArrayList<Integer>();
		Collections.addAll(lst2, 3, 4);
		ArrayList<Integer> lst3 = new ArrayList<Integer>();
		Collections.addAll(lst3, 6, 5, 7);
		ArrayList<Integer> lst4 = new ArrayList<Integer>();
		Collections.addAll(lst4, 4, 1, 8, 3);
		ArrayList<List<Integer>> lst = new ArrayList<List<Integer>>();
		lst.add(lst1);
		lst.add(lst2);
		lst.add(lst3);
		lst.add(lst4);
		System.out.println(minimumTotal(lst));
		
	}

}
