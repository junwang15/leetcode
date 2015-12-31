package coding;
/**
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated 
 * sequence of one or more dictionary words. 
 * For example, given s = "leetcode", dict = ["leet", "code"]. 
 * Return true because "leetcode" can be segmented as "leet code".
 */
import java.util.HashSet;
import java.util.Set;

public class WordBreak {
	public boolean wordBreak(String s, Set<String> wordDict) {
		if(s == null || s.length() == 0)
			return true;
		int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for(int i = 1; i <= len; i++)
        	for(int j = 0; j < i; j++)
        		if(dp[j] && wordDict.contains(s.substring(j, i))) {
        			dp[i] = true;
        			break;
        		}
        return dp[len];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordBreak wb = new WordBreak();
		String s = "aaaaaaa";
		Set<String> st = new HashSet<String>();
		st.add("aaaa"); st.add("aaa");
		System.out.println(wb.wordBreak(s, st));
	}

}
