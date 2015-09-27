/**
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, 
 * such that only one letter can be changed at a time and each intermediate word must exist in the dictionary. For example, given: 
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * One shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog", the program should return its length 5.
 * @author Jun
 */
 
public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        LinkedList<WordNode> queue = new LinkedList<WordNode>();
		queue.add(new WordNode(beginWord, 1));
		wordList.add(endWord);
		
		while(!queue.isEmpty()) {
			WordNode top = queue.remove();
			String topword = top.word;
			if(topword.equals(endWord))
				return top.depth;	
			// push all word in wordList having 1 letter different from topword
			char[] array = topword.toCharArray();
			for(int i = 0; i < array.length; i++) {
				char tmp = array[i];
				for(char c = 'a'; c <= 'z'; c++) {
					if(array[i] != c) array[i] = c; // exclude the case where array == topword
					String newWord = new String(array);
					if (wordList.contains(newWord)) {
						queue.add(new WordNode(newWord, top.depth+1));
						wordList.remove(newWord);
					}
					array[i] = tmp;
				}
			}
		}
		return 0;
    }
	
	private class WordNode {
		String word;
		int depth;
		
		WordNode(String word, int depth) {
		this.word = word;
		this.depth = depth;
		}
	}
}
