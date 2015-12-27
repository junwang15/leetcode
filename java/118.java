import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
	public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows <= 0) return result;
        
        List<Integer> newrow, lastrow;
        newrow = new ArrayList<>();
        newrow.add(1);
        result.add(newrow);
        		
        for(int row=1; row<numRows; row++) {
        	newrow = new ArrayList<>();
            newrow.add(1);
            lastrow = result.get(row-1);
            for(int j=0; j<lastrow.size()-1; j++) {
            	newrow.add(lastrow.get(j) + lastrow.get(j+1));
            }
            newrow.add(1);
            result.add(newrow);
        }
        return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(generate(0));
		System.out.println(generate(1));
		System.out.println(generate(5));
	}

}
