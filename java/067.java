/**
 * Given two binary strings, return their sum (also a binary string).
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 * @author Jun
 *
 */
 
 public class Solution {
    public String addBinary(String a, String b) {
    	if(a == null || a == "") return b;
    	if(b == null || b == "") return a;
    	
    	StringBuilder result = new StringBuilder();
    	int pa = a.length() - 1, pb = b.length() - 1, sign = 0;
    	while(pa >= 0 || pb >= 0) {
    		int va = (pa < 0) ? 0 : Character.getNumericValue(a.charAt(pa));
    		int vb = (pb < 0) ? 0 : Character.getNumericValue(b.charAt(pb));
    		pa--; pb--;
    		int value = va + vb + sign;
    		result.append(String.valueOf(value % 2));
    		sign = value / 2;
    	}
    	if(sign == 1) result.append("1");
    	return result.reverse().toString();
    }
}
