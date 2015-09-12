public class Solution {
    public int myAtoi(String string) {
    	String str = string.trim();
        if(str.length() == 0) return 0;
        int i = 0;
        double solution = 0;    //DOUBLE!
        boolean neg = false; 
        // check if is valid
        char c = str.charAt(0);
        if(c == '-') {	
        	neg = true;
        	i++;
        } else if(c == '+') {
        	i++;
        } else if(!Character.isDigit(c))
        	return 0;

        while(i < str.length() && Character.isDigit(c = str.charAt(i++))) {
        	solution *= 10;
        	solution += Character.getNumericValue(c);
        }
        if (neg) solution *= -1;
        if      (solution > Integer.MAX_VALUE)	return Integer.MAX_VALUE;
        else if (solution < Integer.MIN_VALUE)	return Integer.MIN_VALUE;  
        return (int)solution;    
   }
}
