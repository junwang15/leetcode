
public class ConvertToTitle {
	public static String convertToTitle(int n) {
		if(n <= 0)
			return "";
		StringBuilder result = new StringBuilder();
		while(n > 0) {
			int tmp = (n-1) % 26;
			result.append((char)('A' + tmp));
			n = (n-tmp-1) / 26;
		}
		return result.reverse().toString();
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(convertToTitle(-1));
//		System.out.println(convertToTitle(0));
		System.out.println(convertToTitle(26));
		System.out.println(convertToTitle(27*26));
	}

}
