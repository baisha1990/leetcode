/*Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:

Input: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4*/

class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0 || matrix[0] == null)
            return 0;
        int r = matrix.length, c = matrix[0].length;
        int[][] res = new int[r + 1][c + 1];
        int max = 0;
                
        for(int i = 1; i <= r; i++) {
            for(int j = 1; j <= c; j++) {
                if(matrix[i-1][j-1] == '0')
                    continue;
                else{
                    res[i][j] = Math.min(res[i-1][j-1], Math.min(res[i-1][j], res[i][j-1])) + 1;
                    if(res[i][j] > max)
                        max = res[i][j];
                }
            }
        }

        return max * max;
    }
    
}