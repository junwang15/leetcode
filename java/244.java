package leetcode;
import java.util.*;

/**
 * This is a follow up of Shortest Word Distance. The only difference is now you are given the list of words and your method will be 
 * called repeatedly many times with different parameters. How would you optimize it?
 * Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and
 * return the shortest distance between these two words in the list.
 * For example,
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * Given word1 = "coding”, word2 = "practice”, return 3. Given word1 = "makes", word2 = "coding", return 1.
 * @author jun
 *
 */

public class WordDistance {
	// indexMap = <word, indexListOfWord>
	Map<String, List<Integer>> indexMap = new HashMap<String, List<Integer>>();

	public WordDistance(String[] words) {
		for(int i = 0; i < words.length; i++) {
			String curWord = words[i];
			if(!indexMap.containsKey(curWord)) {
				List<Integer> indexListOfWord = new ArrayList<Integer>();
				indexListOfWord.add(i);
				indexMap.put(curWord, indexListOfWord);
			} else {
				indexMap.get(curWord).add(i);
			}
		}
	}
	
	public int shortest(String word1, String word2) {
		List<Integer> indexList1 = indexMap.get(word1);
		List<Integer> indexList2 = indexMap.get(word2);
		int i = 0, j = 0;
		int min = Integer.MAX_VALUE;
		while(i < indexList1.size() && j < indexList2.size()) {
			int index1 = indexList1.get(i), index2 = indexList2.get(j);
			min = Math.min(Math.abs(index1 - index2), min);
			if(index1 < index2)
				i++;
			else
				j++;			
		}
		return min;
	}
}
