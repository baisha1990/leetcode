/*Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. 
Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected 
if they are adjacent cells connected horizontally or vertically.*/

class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length == 0)
            return;
        int r = board.length, c = board[0].length;
        boolean[][] visited = new boolean[r][c];
        for(int j = 0; j < c; j++) {
            if(board[0][j] == 'O') {
                dfs(board, 0, j, false, visited);
            }
            if(board[r-1][j] == 'O') {
                dfs(board, r-1, j, false, visited);
            }
        }
        for(int i = 0; i < r; i++) {
            if(board[i][0] == 'O') {
                dfs(board, i, 0, false, visited);
            }
            if(board[i][c-1] == 'O') {
                dfs(board, i, c-1, false, visited);
            }
        }
        
        for(int i = 1; i < r-1; i++) {
            for(int j = 1; j < c-1; j++) {
                if(board[i][j] == 'O' && !visited[i][j]) {
                    dfs(board, i, j, true, visited);
                }
            }
        }
    }
    
    void dfs(char[][] board, int i, int j, boolean flip, boolean[][] visited) {
        if(i < 0 || j < 0 || i > board.length-1 || j > board[0].length-1) return;
        if(visited[i][j]) return;
        if(board[i][j] == 'X') return;
        if(flip) {
            board[i][j] = 'X';
        }
        visited[i][j] = true;
        dfs(board, i+1, j, flip, visited);
        dfs(board, i-1, j, flip, visited);
        dfs(board, i, j+1, flip, visited);
        dfs(board, i, j-1, flip, visited);
    }
}