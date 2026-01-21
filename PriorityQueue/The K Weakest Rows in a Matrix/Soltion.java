/*
You are given an m x n binary matrix mat of 1's (representing soldiers) and 0's (representing civilians). The soldiers are positioned in front of the civilians. That is, all the 1's will appear to the left of all the 0's in each row.
A row i is weaker than a row j if one of the following is true:
The number of soldiers in row i is less than the number of soldiers in row j.
Both rows have the same number of soldiers and i < j.
Return the indices of the k weakest rows in the matrix ordered from weakest to strongest.

Example 1:
Input: mat = 
[[1,1,0,0,0],
 [1,1,1,1,0],
 [1,0,0,0,0],
 [1,1,0,0,0],
 [1,1,1,1,1]], 
k = 3
Output: [2,0,3]
Explanation: 
The number of soldiers in each row is: 
- Row 0: 2 
- Row 1: 4 
- Row 2: 1 
- Row 3: 2 
- Row 4: 5 
The rows ordered from weakest to strongest are [2,0,3,1,4].

Example 2:
Input: mat = 
[[1,0,0,0],
 [1,1,1,1],
 [1,0,0,0],
 [1,0,0,0]], 
k = 2
Output: [0,2]
Explanation: 
The number of soldiers in each row is: 
- Row 0: 1 
- Row 1: 4 
- Row 2: 1 
- Row 3: 1 
The rows ordered from weakest to strongest are [0,2,3,1].

Constraints:
m == mat.length
n == mat[i].length
2 <= n, m <= 100
1 <= k <= m
matrix[i][j] is either 0 or 1.
*/

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
    Comparator.comparingInt((Map.Entry<Integer, Integer> a) -> a.getValue())
              .thenComparingInt(a -> a.getKey())
);
        Map<Integer, Integer> map = new HashMap<>();
        for(int row = 0; row < mat.length; row++) {
            for(int col = 0; col < mat[0].length; col++) {
                map.putIfAbsent(row, 0);
                if(mat[row][col] == 1) {
                    map.put(row, map.getOrDefault(row, 0) + 1);
                }
            }
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(entry);
        }
        int[] res = new int[k];
        for(int i = 0; i < k; i++) {
            res[i] = pq.poll().getKey();
        }
        return res;
    }
}