package leetcode;

public class ValidNumber {
	
    public boolean isNumber(String s) {
        if(s == null) return false;
        s = s.trim();
        
        boolean hasNumber = false, hasE = false, hasPoint = false, hasNumAfterE = true;
        
        for(int i = 0; i < s.length(); i++) {
        	char curr = s.charAt(i);
        	if(curr >= '0' && curr <= '9') {
        		hasNumber = true;
        		if(hasE)
        			hasNumAfterE = true;
        	} else if(curr == '.') {
        		if(hasPoint || hasE)
        			return false;
        		hasPoint = true;
        	} else if(curr == 'e') {
        		if(hasE || !hasNumber)
        			return false;
        		hasE = true;
        		hasNumAfterE = false;
        	} else if(curr == '+' || curr == '-') {
        		if(i!=0 && s.charAt(i-1)!= 'e')
        			return false;
        	} else
        		return false;
        }
        return hasNumber && hasNumAfterE;
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidNumber vn = new ValidNumber();
		System.out.println(vn.isNumber(""));
		System.out.println(vn.isNumber("."));
		System.out.println(vn.isNumber(".1"));
		System.out.println(vn.isNumber("1."));
		System.out.println(vn.isNumber("e10"));
		System.out.println(vn.isNumber("+2.0e2"));
		System.out.println(vn.isNumber("+1a"));
		System.out.println(vn.isNumber("2e10"));

	}

}
