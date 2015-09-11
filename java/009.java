// Solution 1 (faster)
public class Solution {
    public boolean isPalindrome(int x) {
    	if (x < 0) return false;
        String str = Integer.toString(x);
        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
        	if (str.charAt(i) != str.charAt(j))
        		return false;
        }
        return true;
    }
}

// Solution 2
public class Solution {
    public boolean isPalindrome(int x) {
    	if (x < 0) return false;
        long y = 0;
        int origin = x;
        while(x > 0) {
        	y *= 10;
        	y += x % 10;
        	x /= 10;
        }
        if (y > Integer.MAX_VALUE) return false;
        return origin == (int)y;  
    }
}
