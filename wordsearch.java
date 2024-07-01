// Time Complexity : exponential
// Space Complexity : O(n) length of word
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    int m, n; // to store row and col
    int[][] dirs;

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // direction array
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (backtrack(board, 0, word, i, j)) { // start bacltrack from here
                        return true;
                    }
                }

            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, int index, String word, int row, int col) {

        if (index == word.length()) {
            return true;
        }
        if (row < 0 || row == m || col < 0 || col == n || board[row][col] == '#'
                || board[row][col] != word.charAt(index)) {
            return false;
        }

        if (board[row][col] == word.charAt(index)) {
            char temp = board[row][col];
            board[row][col] = '#'; // to mark visited
            for (int[] dir : dirs) {
                int nr = row + dir[0];
                int nc = col + dir[1];
                if(backtrack(board, index + 1, word, nr, nc)){ // character found, move ahead
                    return true;
                }
            }
            board[row][col] = temp; // restore it back to original char
        }

        return false;
    }
}