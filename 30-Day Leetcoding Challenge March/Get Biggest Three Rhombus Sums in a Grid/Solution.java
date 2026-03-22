/*
You are given an m x n integer matrix grid​​​.
A rhombus sum is the sum of the elements that form the border of a regular rhombus shape in grid​​​. The rhombus must have the shape of a square rotated 45 degrees with each of the corners centered in a grid cell. Below is an image of four valid rhombus shapes with the corresponding colored cells that should be included in each rhombus sum:
Note that the rhombus can have an area of 0, which is depicted by the purple rhombus in the bottom right corner.
Return the biggest three distinct rhombus sums in the grid in descending order. If there are less than three distinct values, return all of them.

Example 1:
Input: grid = [[3,4,5,1,3],[3,3,4,2,3],[20,30,200,40,10],[1,5,5,4,1],[4,3,2,2,5]]
Output: [228,216,211]
Explanation: The rhombus shapes for the three biggest distinct rhombus sums are depicted above.
- Blue: 20 + 3 + 200 + 5 = 228
- Red: 200 + 2 + 10 + 4 = 216
- Green: 5 + 200 + 4 + 2 = 211

Example 2:
Input: grid = [[1,2,3],[4,5,6],[7,8,9]]
Output: [20,9,8]
Explanation: The rhombus shapes for the three biggest distinct rhombus sums are depicted above.
- Blue: 4 + 2 + 6 + 8 = 20
- Red: 9 (area 0 rhombus in the bottom right corner)
- Green: 8 (area 0 rhombus in the bottom middle)

Example 3:
Input: grid = [[7,7,7]]
Output: [7]
Explanation: All three possible rhombus sums are the same, so return [7].
 
Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 50
1 <= grid[i][j] <= 105
*/

class Solution {
            public int[] getBiggestThree(int[][] grid) {
        int x = grid.length-1, y = grid[0].length-1;
        int[] res = new int[3];
        for(int i=0; i<=x; i++){
            for(int j=0; j<=y; j++){
                int left = Math.min(x, j);
                int right = Math.min(x, y-j);
                int down = (x-i)/2;
                int radius = Math.min(Math.min(left, down), right);
                fillTop(res, grid[i][j]);
                for(int k=1; k<=radius; k++){
                    findRadius(grid, k, i, j, res);
                }

            }
        }
        if(res[2]>0){
            return res;
        } if(res[1]>0){
            return new int[]{res[0], res[1]};
        } else {
            return new int[]{res[0]};
        }
    }

    private void findRadius(int[][] grid, int k, int i, int j, int[] res) {
        int b = 2*(k);
        int leftSum = 0, rightSum=0, leftbtm=0, rightbtm=0, up = grid[i][j], down = grid[b+i][j];
        for(int m=1; m<=k; m++){
            leftSum = leftSum + grid[i+m][j-m];
            rightSum = rightSum + grid[i+m][j+m];
            if(i+m != (b+i)-m) {
                leftbtm = leftbtm + grid[b+i - m][j - m];
            }
            if(i+m!=b+i-m) {
                rightbtm = rightbtm + grid[b+i - m][j + m];
            }
        }
        int sum = leftSum+rightSum+leftbtm+rightbtm+up+down;
        fillTop(res, sum);
    }

    private void fillTop(int[] res, int val) {
        if(val!=res[0] && val!=res[1] && val!=res[2] && val>res[0]){
            res[2] = res[1];
            res[1] = res[0];
            res[0] = val;
        } else if(val!=res[0] && val!=res[1] && val!=res[2] && val>res[1]){
            res[2] = res[1];
            res[1] = val;
        } else if(val!=res[0] && val!=res[1] && val!=res[2] && val>res[2]){
            res[2] = val;
        }
    }
}