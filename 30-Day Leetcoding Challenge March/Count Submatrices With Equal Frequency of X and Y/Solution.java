/*
Given a 2D character matrix grid, where grid[i][j] is either 'X', 'Y', or '.', return the number of submatrices that contain:

1) grid[0][0]
2) an equal frequency of 'X' and 'Y'.
3) at least one 'X'.
 

Example 1:
Input: grid = [["X","Y","."],["Y",".","."]]
Output: 3
Explanation:


Example 2:
Input: grid = [["X","X"],["X","Y"]]
Output: 0
Explanation:
No submatrix has an equal frequency of 'X' and 'Y'.

Example 3:
Input: grid = [[".","."],[".","."]]
Output: 0
Explanation:
No submatrix has at least one 'X'.

 
Constraints:
1 <= grid.length, grid[i].length <= 1000
grid[i][j] is either 'X', 'Y', or '.'.
*/

class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        int[][][] sum = new int[n + 1][m + 1][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'X') {
                    sum[i + 1][j + 1][0] =
                        sum[i + 1][j][0] + sum[i][j + 1][0] - sum[i][j][0] + 1;
                    sum[i + 1][j + 1][1] = 1;
                } else if (grid[i][j] == 'Y') {
                    sum[i + 1][j + 1][0] =
                        sum[i + 1][j][0] + sum[i][j + 1][0] - sum[i][j][0] - 1;
                    sum[i + 1][j + 1][1] = sum[i + 1][j][1] | sum[i][j + 1][1];
                } else {
                    sum[i + 1][j + 1][0] =
                        sum[i + 1][j][0] + sum[i][j + 1][0] - sum[i][j][0];
                    sum[i + 1][j + 1][1] = sum[i + 1][j][1] | sum[i][j + 1][1];
                }
                ans += (sum[i + 1][j + 1][0] == 0 && sum[i + 1][j + 1][1] == 1)
                    ? 1
                    : 0;
            }
        }
        return ans;
    }
}