import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle2 {
	public static List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        
        result.add(1);
        List<Integer> lastrow = result;
        
        for(int i = 0; i < rowIndex; i++) {
        	result = new ArrayList<>();
        	result.add(1);
        	for(int j = 0; j < lastrow.size()-1; j++)
        		result.add(lastrow.get(j) + lastrow.get(j+1));
        	result.add(1);
        	lastrow = result;
        }
        return result;
    }
	
	// a faster solution
	public static List<Integer> getRow2(int rowIndex) {
		Integer[] result = new Integer[rowIndex+1];
        result[0] = 1;
        Integer[] lastrow = result;
        
        for(int i = 1; i <= rowIndex; i++) {
        	result = new Integer[rowIndex+1];
        	result[0] = 1;
        	for(int j = 1; j <= i-1; j++)
        		result[j] = lastrow[j-1] + lastrow[j];
        	result[i] = 1;
        	lastrow = result;
        }
        return Arrays.asList(result);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getRow2(0));
		System.out.println(getRow2(1));
		System.out.println(getRow2(2));
		System.out.println(getRow2(3));
		System.out.println(getRow2(4));
		System.out.println(getRow2(5));
	}
}
