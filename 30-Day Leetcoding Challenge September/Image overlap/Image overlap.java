/*Two images A and B are given, represented as binary, square matrices of the same size.  (A binary matrix has only 0s and 1s as values.)

We translate one image however we choose (sliding it left, right, up, or down any number of units), and place it on top of the other image.  After, the overlap of this translation is the number of positions that have a 1 in both images.

(Note also that a translation does not include any kind of rotation.)

What is the largest possible overlap?

Example 1:

Input: A = [[1,1,0],
            [0,1,0],
            [0,1,0]]
       B = [[0,0,0],
            [0,1,1],
            [0,0,1]]
Output: 3
Explanation: We slide A to right by 1 unit and down by 1 unit.
Notes: 

1 <= A.length = A[0].length = B.length = B[0].length <= 30
0 <= A[i][j], B[i][j] <= 1*/

class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        return Math.max(largestOverlapHelper(A, B), largestOverlapHelper(B, A));
    }
    
    private int largestOverlapHelper(int[][] A, int[][] B) {
        int n = A.length, count = 0;
        for(int x = 0; x < A.length; x++) {
            for(int y = 0; y < A.length; y++) {
                int temp = 0;
                for(int i = x; i < n; i++) {
                    for(int j = y; j < n; j++) {
                        if(A[i][j] == 1 && B[i-x][j-y] == 1)
                            temp++;
                    }
                }
                count = Math.max(count, temp);
            }
        }
        return count;
    }
}