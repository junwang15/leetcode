
public class TrailingZeroes {
	// recursive solution
	public static int trailingZeroes(int n) {
        if(n < 5)
        	return 0;
        return n /5 + trailingZeroes(n / 5);
    }
	
	// iterative solution
	public static int trailingZeroes1(int n) {
        if(n < 5)
        	return 0;
        int result = 0;
        while(n >= 5) {
        	result += n/5;
        	n /= 5;
        }
        return result;
    }
	
	// This solution will overflow
	public static int trailingZeroes2(int n) {
        if(n <= 0)
        	return 0;
        int result = 0;
        for(int i = 5; i <= n; i *= 5) {
        	result += n / i;
        }
        return result;
    }

}
