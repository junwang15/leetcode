
public class HammingWeight {
	public static int hammingWeight(int n) {
		if(n == 0)
			return 0;
		return (n & 1) + hammingWeight(n >>> 1);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(hammingWeight(-1));
		System.out.println(hammingWeight(-2147483648)); 
		System.out.println(hammingWeight(2147483647)); 
	}

}
