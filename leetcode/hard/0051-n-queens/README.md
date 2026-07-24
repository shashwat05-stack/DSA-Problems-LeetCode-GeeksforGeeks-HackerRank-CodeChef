# N-Queens

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

The  **n-queens**  puzzle is the problem of placing `n` queens on an `n x n` chessboard such that no two queens attack each other.

Given an integer `n`, return  *all distinct solutions to the  **n-queens puzzle***. You may return the answer in  **any order**.

Each solution contains a distinct board configuration of the n-queens' placement, where `'Q'` and `'.'` both indicate a queen and an empty space, respectively.

 

 **Example 1:** 

```
Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above

```

 **Example 2:** 

```
Input: n = 1
Output: [["Q"]]

```

 

 **Constraints:** 

- 1 <= n <= 9

## Solution

**Language:** Java  
**Runtime:** 2 ms (beats 82.17%)  
**Memory:** 46.6 MB (beats 65.16%)  
**Submitted:** 2026-07-24T10:25:07.047Z  

```java
class Solution {
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];

        // Fill board with '.'
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        backtrack(board, 0);

        return result;
    }

    // Try to place a queen row by row
    private void backtrack(char[][] board, int row) {

        // Base Case: All queens placed
        if (row == board.length) {
            result.add(construct(board));
            return;
        }

        // Try every column
        for (int col = 0; col < board.length; col++) {

            if (isSafe(board, row, col)) {

                // Place Queen
                board[row][col] = 'Q';

                // Move to next row
                backtrack(board, row + 1);

                // Backtrack
                board[row][col] = '.';
            }
        }
    }

    // Check whether placing queen is safe
    private boolean isSafe(char[][] board, int row, int col) {

        // Check same column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q')
                return false;
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0;
             i--, j--) {

            if (board[i][j] == 'Q')
                return false;
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < board.length;
             i--, j++) {

            if (board[i][j] == 'Q')
                return false;
        }

        return true;
    }

    // Convert board to List<String>
    private List<String> construct(char[][] board) {

        List<String> temp = new ArrayList<>();

        for (char[] row : board) {
            temp.add(new String(row));
        }

        return temp;
    }
}
    

```

---

[View on LeetCode](https://leetcode.com/problems/n-queens/)