/*
Tic-tac-toe is played by two players A and B on a 3 x 3 grid. The rules of Tic-Tac-Toe are:
1) Players take turns placing characters into empty squares ' '.
2) The first player A always places 'X' characters, while the second player B always places 'O' characters.
3) 'X' and 'O' characters are always placed into empty squares, never on filled ones.
4) The game ends when there are three of the same (non-empty) character filling any row, column, or diagonal.
5) The game also ends if all squares are non-empty.
6) No more moves can be played if the game is over.
Given a 2D integer array moves where moves[i] = [rowi, coli] indicates that the ith move will be played on grid[rowi][coli]. return the winner of the game if it exists (A or B). In case the game ends in a draw return "Draw". If there are still movements to play return "Pending".
You can assume that moves is valid (i.e., it follows the rules of Tic-Tac-Toe), the grid is initially empty, and A will play first.

Example 1:
Input: moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]
Output: "A"
Explanation: A wins, they always play first.

Example 2:
Input: moves = [[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]]
Output: "B"
Explanation: B wins.

Example 3:
Input: moves = [[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]
Output: "Draw"
Explanation: The game ends in a draw since there are no moves to make.

Constraints:
1 <= moves.length <= 9
moves[i].length == 2
0 <= rowi, coli <= 2
There are no repeated elements on moves.
moves follow the rules of tic tac toe.
*/

class Solution {
    public String tictactoe(int[][] moves) {
        int n = 3;
        int[] rows = new int[n], cols = new int[n];
        int diag = 0, anti_diag = 0;
        
        int player = 1;
        
        for (int[] move : moves){

            int row = move[0], col = move[1];
            
            rows[row] += player;
            cols[col] += player;
            
            if (row == col){
                diag += player;
            }
            if (row + col == n - 1){
                anti_diag += player;
            }
            
            if (Math.abs(rows[row]) == n || Math.abs(cols[col]) == n || 
                Math.abs(diag) == n || Math.abs(anti_diag) == n){
                return player == 1 ? "A" : "B";
            }
            player *= -1;
        }
        return moves.length == n * n ? "Draw" : "Pending";
    }
}