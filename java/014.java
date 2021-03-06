public class Solution {
    public String longestCommonPrefix(String[] strs) {
    	if(strs == null || strs.length == 0) return "";
    	
    	StringBuffer prefix = new StringBuffer();
    	char c;
    	for(int idx = 0; idx < strs[0].length(); idx++) {
    		c = strs[0].charAt(idx);
    		for(int j = 1; j < strs.length; j++) {
    			if(idx >= strs[j].length() || strs[j].charAt(idx) != c)	
    				return prefix.toString();
    		}
    		prefix.append(c);
    	}
    	return prefix.toString();        
    }
}
