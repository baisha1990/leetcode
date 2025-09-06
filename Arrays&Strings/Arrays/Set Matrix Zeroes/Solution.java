/* Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
You must do it in place.

Example 1:
Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
*/

class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firstRow = false, firstCol = false;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    if(i == 0) firstRow = true;
                    if(j == 0) firstCol = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        for(int j = 0; j < matrix[0].length; j++) {
            if(firstRow) {
                matrix[0][j] = 0;
            }
        }

        for(int i = 0; i < matrix.length; i++) {
            if(firstCol) {
                matrix[i][0] = 0;
            }
        }
    }
}