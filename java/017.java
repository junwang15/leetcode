package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BackTracking {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if(digits == null || digits.length() == 0)
            return result;
        
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        map.put(0, "");
        
        ArrayList<Character> item = new ArrayList<Character>();
        getString(digits, result, map, item);
        return result;
    }
    
    private void getString(String digits, List<String> result, HashMap<Integer, String> map, ArrayList<Character> item) {
        if(digits.length() == 0) {
        	char[] tmp = new char[item.size()];
        	for(int i = 0; i < item.size(); i++)
        		tmp[i] = item.get(i);
        	result.add(String.valueOf(tmp));
        	return;
        }
    	
        int cur = Integer.valueOf(digits.substring(0,1));
    	String letters = map.get(cur);
    	for(int i = 0; i < letters.length(); i++) {
    		item.add(letters.charAt(i));
    		getString(digits.substring(1), result, map, item);
    		item.remove(item.size()-1);
    	}
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BackTracking bt = new BackTracking();
		System.out.println(bt.letterCombinations("23"));
	}

}
