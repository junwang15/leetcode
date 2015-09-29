public class Solution {
    public boolean isPalindrome(String s) {
        if(s == null) return false;
        if(s.length() < 2) return true;
        
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int i, j;
        for(i = 0; i < (j = s.length()-1-i); i++){
            if(s.charAt(i) != s.charAt(j))
                return false;
        }
        return true;
    }
}
