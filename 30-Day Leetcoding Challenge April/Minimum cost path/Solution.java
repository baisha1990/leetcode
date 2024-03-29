/*Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.*/

class Solution {
    public int minPathSum(int[][] grid) {
        
        int r = grid.length, c = grid[0].length;
        int[][] res = new int[r][c];
        
        res[0][0] = grid[0][0];
        for(int i = 1; i < r; i++) {
            res[i][0] = res[i-1][0] + grid[i][0];
        }
        
        for(int j = 1; j < c; j++) {
            res[0][j] = res[0][j-1] + grid[0][j];
        }
        
        for(int i = 1; i < r; i++) {
            for(int j = 1; j < c; j++) {
                res[i][j] = grid[i][j] + Math.min(res[i-1][j], res[i][j-1]);
            }
        }
        return res[r-1][c-1];
    }
}