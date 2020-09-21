/*On a 2-dimensional grid, there are 4 types of squares:

1 represents the starting square.  There is exactly one starting square.
2 represents the ending square.  There is exactly one ending square.
0 represents empty squares we can walk over.
-1 represents obstacles that we cannot walk over.
Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.

 

Example 1:

Input: [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
Output: 2
Explanation: We have the following two paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
Example 2:

Input: [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
Output: 4
Explanation: We have the following four paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
Example 3:

Input: [[0,1],[2,0]]
Output: 0
Explanation: 
There is no path that walks over every empty square exactly once.
Note that the starting and ending square can be anywhere in the grid.
 

Note:

1 <= grid.length * grid[0].length <= 20*/

class Solution {
    int r,c;
    int[][] grid;
    int pc;
    
    void backtrack(int r, int c, int remain) {
        if(this.grid[r][c] == 2 && remain == 1) {
            this.pc += 1;
            return;
        }
        
        int temp = grid[r][c];
        grid[r][c] = -4;
        remain -= 1;
        
        int[] r_offsets = {0, 0, 1, -1};
        int[] c_offsets = {1, -1, 0, 0};
        for(int i = 0; i < 4; i++) {
            int next_r = r + r_offsets[i];
            int next_c = c + c_offsets[i];
            
            if(next_r < 0 || next_r >= this.r || next_c < 0 || next_c >= this.c)
                continue;
            
            if(grid[next_r][next_c] < 0)
                continue;
            
            backtrack(next_r, next_c, remain);
        }
        grid[r][c] = temp;
    }
    public int uniquePathsIII(int[][] grid) {
        int non_obstacles = 0, start_r = 0, start_c = 0;
        this.r = grid.length;
        this.c = grid[0].length;
        
        for(int row = 0; row < r; row++)
            for(int col = 0; col < c; col++) {
                int cell = grid[row][col];
                if(cell >= 0)
                    non_obstacles += 1;
                if(cell == 1) {
                    start_r = row;
                    start_c = col;
                }
            }
        
        this.pc = 0;
        this.grid = grid;
        
        backtrack(start_r, start_c, non_obstacles);
        
        return this.pc;
    }
}