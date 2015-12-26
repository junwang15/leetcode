
public class PowerOfTwo {
	public static boolean isPowerOfTwo(int n) {
        if(n < 1)
        	return false;
        while(n != 1){
        	if((n & 1) == 1)
        		return false;
        	n >>= 1;
        }
        return true;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPowerOfTwo(0));
		System.out.println(isPowerOfTwo(1));
		System.out.println(isPowerOfTwo(2));
		System.out.println(isPowerOfTwo(256));	
	}

}
