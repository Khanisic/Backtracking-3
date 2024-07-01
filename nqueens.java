// Time Complexity : O(n * n!)
// Space Complexity : O(n^n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    boolean grid[][]; // boolean grid of all false
    List<List<String>> res; 

    public List<List<String>> solveNQueens(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        grid = new boolean[n][n];
        res = new ArrayList<>();
        backtrack(0); // starting with row = 0
        return res;
    }

    private void backtrack(int row) {
        if (row == grid.length) { // base case reached, end of tree
            List<String> ans = new ArrayList<>(); 
            for (int i = 0; i < grid.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < grid.length; j++) {
                    if(grid[i][j] == true){
                        sb.append('Q');
                    }else{
                        sb.append('.');
                    }
                }
                ans.add(sb.toString());
            }
            res.add(ans);
            return; // to prevent overflow as for loop starting from 0 and not index as seen previously
        }

        for (int i = 0; i < grid.length; i++) {
            if (isSafe(row, i)) {
                grid[row][i] = true; // action
                backtrack(row + 1); // recurse
                grid[row][i] = false; // backtrack
            }
        }
    }

    private boolean isSafe(int row, int col) {
        // upper check, same col
        for (int i = row; i >= 0; i--) {
            if (grid[i][col] == true) {
                return false;
            }
        }

        // upper left diagonal
        int i = row;
        int j = col;
        while (i >= 0 && j >= 0) {
            if (grid[i][j] == true) {
                return false;
            }
            i--;
            j--;
        }

        // upper right diagonal
        i = row;
        j = col;
        while (i >= 0 && j < grid.length) {
            if (grid[i][j] == true) {
                return false;
            }
            i--;
            j++;
        }

        return true;
    }
}