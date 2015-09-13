public class Solution {
    public String intToRoman(int num) {
    	StringBuffer roman = new StringBuffer();
    	// thousand
    	for(int i = num/1000; i > 0; i--)
    		roman.append('M');
    	// hundred
    	num %= 1000;
    	int hundred = num/100;
    	if(hundred == 9) {		 
    		roman.append("CM");
    		hundred = 0;
    	} else if(hundred > 4) {
    		roman.append('D');
    		hundred %= 5;
    	}
    	if(hundred == 4)	
    		roman.append("CD");
    	else for(int i = hundred; i > 0; i--)
    		roman.append('C');
    	// ten
    	num %= 100;
    	int ten = num/10;
    	if(ten == 9) {
    		roman.append("XC");
    		ten = 0;
    	} else if(ten > 4) {
    		roman.append('L');
    		ten %= 5;
    	}
    	if(ten == 4)
    		roman.append("XL");
    	else for(int i = ten; i > 0; i--)
    		roman.append('X');
    	// one
    	num %= 10;
    	int one = num;
    	if(one == 9) {
    		roman.append("IX");
    		one = 0;
    	} else if(one > 4) {
    		roman.append('V');
    		one %= 5;
    	}
    	if(one == 4)
    		roman.append("IV");
    	else for(int i = one; i > 0; i--)
    		roman.append('I');
    	return roman.toString();
    }
}
