package leetcode;

public class MinWindow {
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        // initialize the hash map <character in t: times of appearance of each character>
        for(Character c : t.toCharArray())
        	map[c]++;
        int counter = t.length(); // check whether the substring is valid
        int begin = 0, end = 0; 
        int d = Integer.MAX_VALUE; // length of the substring
        int head = 0;
        while(end < s.length()) {
        	// move "end" leftward until find a valid substring
        	if(map[s.charAt(end++)]-- > 0)
        		counter--;
        	while(counter == 0) {
        		// update d here if finding minimum
        		if(end - begin < d)
        			d = end - (head = begin);
        		// increase begin to make it invalid/valid again
        		if(map[s.charAt(begin++)]++ == 0)
        			counter++;
        	}
        }
        return d == Integer.MAX_VALUE ? "" : s.substring(head, head+d);
    }
    
    public static void main(String[] args) {
    	String s = "ADOBECODEBANC";
    	String t = "ABC";
    	MinWindow mw = new MinWindow();
    	System.out.println(mw.minWindow(s, t));
    }
}
