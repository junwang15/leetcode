/**
All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
For example,
Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
Return:
["AAAAACCCCC", "CCCCCAAAAA"].
*/

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if(s == null) return null;
		// use "Set result" to avoid redundance in result;
        Set<String> seen = new HashSet(), result = new HashSet();
        for(int i = 0; i+9 < s.length(); i++) {
            String sequence = s.substring(i, i+10);
            if(!seen.add(sequence))
                result.add(sequence);
        }
        return new ArrayList(result);
    }
}
