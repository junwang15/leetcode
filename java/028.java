public class Solution {
    public int strStr(String haystack, String needle) {
    	if(haystack == null || needle == null)	return -1;
    	int hlen = haystack.length(), nlen = needle.length();
    	if(nlen == 0)   return 0;
        if(hlen < nlen) return -1;
        
        int i, j;
        char start = needle.charAt(0);
        for(i = 0; i <= hlen - nlen; i++) {
        	if(haystack.charAt(i) == start) {
        		for(j = 1; j < nlen && haystack.charAt(i + j) == needle.charAt(j); j++)	;
        		if(j == nlen)	return i;
        	}
        }
        return -1;      
    }
}
