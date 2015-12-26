
public class TitleToNumber {
	public static int titleToNumber(String s) {
		if(s == null || s.length() == 0)
			return 0;
		int result = 0;
		for(int i = 0; i < s.length(); i++) {
			result *= 26;
			result += s.charAt(i) - 'A' + 1;
		}
		return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(titleToNumber(""));
		System.out.println(titleToNumber("A"));
		System.out.println(titleToNumber("AB"));
	}

}
