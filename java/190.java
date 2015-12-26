
public class ReverseBits {
	// you need treat n as an unsigned value
    public static int reverseBits(int n) {
    	int result = 0;
    	for(int i = 0; i < 32; i++) {
    		if((n & 1) == 1) 
    			result |= 1;
    		n >>>= 1;
    		if(i != 31)
    			result <<= 1;
    	}
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Integer.toBinaryString(43261596));
		System.out.println(Integer.toBinaryString(reverseBits(43261596)));
		System.out.println(reverseBits(43261596));
		System.out.println(reverseBits(-2147483648)); 
		System.out.println(reverseBits(2147483647)); 
	}

}
