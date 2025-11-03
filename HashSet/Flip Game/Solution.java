/*
You are playing a Flip Game with your friend.
You are given a string currentState that contains only '+' and '-'. You and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move, and therefore the other person will be the winner.
Return all possible states of the string currentState after one valid move. You may return the answer in any order. If there is no valid move, return an empty list [].

Example 1:
Input: currentState = "++++"
Output: ["--++","+--+","++--"]

Example 2:
Input: currentState = "+"
Output: []

Constraints:
1 <= currentState.length <= 500
currentState[i] is either '+' or '-'.
*/

class Solution {
    public List<String> generatePossibleNextMoves(String currentState) {
        if(currentState == null) {
            return new ArrayList<>();
        }
        Set<String> set = new HashSet<>();
        for(int i = 0; i+1 < currentState.length(); i++) {
            if(currentState.charAt(i) == '+' && currentState.charAt(i) == currentState.charAt(i + 1)) {
                StringBuilder newStr = new StringBuilder(currentState);
                newStr.setCharAt(i, '-');
                newStr.setCharAt(i + 1, '-');
                set.add(newStr.toString());
            }
        }
        return new ArrayList<>(set);
    }
}