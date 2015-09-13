public class Solution {
    public int romanToInt(String s) {
    	if(s == null || s.length() == 0)	return 0;

    	int integer = 0;
    	int len = s.length();
    	for(int i = 0; i < len; i++) {
    		char c = s.charAt(i);
    		if(c == 'M')		integer += 1000;
    		else if(c == 'D')	integer += 500;
    		else if(c == 'L')	integer += 50;
    		else if(c == 'V')	integer += 5;
    		else if(c == 'C') {
    			if      (i < len - 1 && s.charAt(i+1) == 'D')	{integer += 400; i++;} 
    			else if (i < len - 1 && s.charAt(i+1) == 'M')	{integer += 900; i++;}
    			else    integer += 100;
    		} else if(c == 'X') {
    			if      (i < len - 1 && s.charAt(i+1) == 'L')	{integer += 40; i++;} 
    			else if (i < len - 1 && s.charAt(i+1) == 'C')	{integer += 90; i++;} 
    			else    integer += 10;
    		} else if(c == 'I') {
    			if      (i < len - 1 && s.charAt(i+1) == 'V')	{integer += 4; i++;} 
    			else if	(i < len - 1 && s.charAt(i+1) == 'X')	{integer += 9; i++;} 
    			else    integer += 1;
    		}
    	}
    	return integer;        
    }
}
