public class Solution {
    public boolean isValid(String s) {
    	if(s == null)	return false;
        Stack<Character> stk = new Stack<Character>();
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        for(int i = 0; i < s.length(); i++) {
      	    char c = s.charAt(i);
      	    if(map.containsKey(c)) stk.push(c);
      	    else if(!stk.isEmpty() && c == map.get(stk.pop())) ;
      	    else return false;
        }
        if(stk.isEmpty())   return true;
        else                return false;
    }
}
