package leetcode;

import java.util.Stack;

public class WordString {
	public String reverseWords(String s) {
        if(s == null || s.length() == 0)  return s;
        int len = s.length();
        int left = 0, right = 0;
        Stack<String> words = new Stack<String>();
        while(right < len) {
        	while(right < len && s.charAt(right) == ' ')
        		right++;
        	if(right == len)
        		break;
        	left = right;
        	while(right < len && s.charAt(right) != ' ')
        		right++;
        	words.push(s.substring(left, right));
        }
        StringBuilder result = new StringBuilder();
        while(!words.isEmpty()) {
        	result.append(words.pop());
        	result.append(' ');
        }
        return String.valueOf(result).trim();
    }
    
	public static void main(String[] args)
	{
		// your code goes here
		WordString id = new WordString();
		String s = "  what a     fine        day     ";
		System.out.println(s);
		System.out.println(id.reverseWords(s)+"<--end");
	}
}
