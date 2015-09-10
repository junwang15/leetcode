public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) return s.length();

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int max, count;
        max = count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c) || map.get(c) < i - count)
                count++;
            else
                count = i - map.get(c);
            map.put(c, i);
            if (count > max)    max = count;
        }
        return max;
    }
}
