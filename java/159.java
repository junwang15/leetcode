package leetcode;

public class Substring {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		if(s == null || s.length() == 0)	return 0;
		int[] map = new int[128];	// hash map
		int start = 0, end = 0;
		int d = 0;	// track the length of longest valid substring
		int count = 0; // count the number of distinct characters
		while(end < s.length()) {
			if(map[s.charAt(end++)]++ == 0)
				count++;
			// move start rightward until the substring is valid again
			while(count > 2) {
				if(map[s.charAt(start++)]-- == 1)
					count--;
			}
			// update the length of longest valid substring
			d = Math.max(d, end - start);
		}
		return d;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Substring sub = new Substring();
		System.out.println(sub.lengthOfLongestSubstringTwoDistinct(""));
		System.out.println(sub.lengthOfLongestSubstringTwoDistinct("a"));
		System.out.println(sub.lengthOfLongestSubstringTwoDistinct("ab"));
		System.out.println(sub.lengthOfLongestSubstringTwoDistinct("ababcbbbb"));
	}

}
