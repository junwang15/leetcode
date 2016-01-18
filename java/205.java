public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s == null || t == null || s.length() != t.length())
            return false;
        Map<Character, Integer> mapS = new HashMap<Character, Integer>();
        Map<Character, Integer> mapT = new HashMap<Character, Integer>();
        for(Integer i = 0; i < s.length(); i++) {
            if(mapS.get(s.charAt(i)) != mapT.get(t.charAt(i)))
                return false;
            mapS.put(s.charAt(i), i);
            mapT.put(t.charAt(i), i);
        }
        return true;
    }
}

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s == null || t == null || s.length() != t.length())
            return false;
        int[] mapS = new int[256];
        int[] mapT = new int[256];
        int len = s.length();
        for(Integer i = 0; i < len; i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            if(mapS[charS] != mapT[charT])
                return false;
            mapS[charS] = i+1;		// NOTE: = i will not work!!
            mapT[charT] = i+1;
        }
        return true;
    }
}
