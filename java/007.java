public class Solution {
    public int reverse(int x) {
		long result = 0;
		boolean neg = false;
		if (x < 0) {
			neg = true;
			x *= -1;
		}
		while(x > 0) {
			result *=10;
			result += x % 10;
			x /= 10;
		}
		if (result > Integer.MAX_VALUE) return 0;     // overflow
		return (int)result * ((neg == true) ? -1 : 1);    
    }
}
