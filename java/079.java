/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/

public class Solution {
    private boolean[][] solution;
    
    public boolean exist(char[][] board, String word) {
        if(word == null || word.length() == 0)
            return true;
        if(board == null || board.length == 0 || board[0].length == 0)
            return false;
        int m = board.length, n = board[0].length;
        solution = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == word.charAt(0) && search(board, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }
    
    /*
     * From the starting point (row, col) search all safe paths and make recursive call to rest of the problem
     */
    private boolean search(char[][] board, String word, int row, int col, int index) {
        // check if cell(row, col) is used before or with target character
        if(solution[row][col] == true || board[row][col] != word.charAt(index))
            return false;
        solution[row][col] = true;
        // finish if reach the end of the word
        if(index == word.length() -1) 
            return true;
        // seach all possible paths
        if(row > 0 && search(board, word, row-1, col, index+1))
            return true;
        if(row < board.length-1 && search(board, word, row+1, col, index+1))
            return true;
        if(col > 0 && search(board, word, row, col-1, index+1))
            return true;
        if(col < board[0].length-1 && search(board, word, row, col+1, index+1))
            return true;
        // if none of the option works out, BACKTRACK and return false
        solution[row][col] = false;
        return false;
    }
}
