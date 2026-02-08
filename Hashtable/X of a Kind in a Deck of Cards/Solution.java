/*
You are given an integer array deck where deck[i] represents the number written on the ith card.
Partition the cards into one or more groups such that:
Each group has exactly x cards where x > 1, and
All the cards in one group have the same integer written on them.
Return true if such partition is possible, or false otherwise.

Example 1:
Input: deck = [1,2,3,4,4,3,2,1]
Output: true
Explanation: Possible partition [1,1],[2,2],[3,3],[4,4].

Example 2:
Input: deck = [1,1,1,2,2,2,3,3]
Output: false
Explanation: No possible partition.

Constraints:
1 <= deck.length <= 104
0 <= deck[i] < 104
*/

class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        int n = deck.length;
        if(n <= 1) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.put(deck[i], map.getOrDefault(deck[i], 0) + 1);
        }
        int gcd = -1;
        for(int value : map.values()) {
            if(gcd == -1) {
                gcd = value;
            } else {
                gcd = findGCD(gcd, value);
            }
        }
        return gcd >= 2;
    }
    private int findGCD(int a, int b) {
        if(b == 0) {
            return a;
        }
        return findGCD(b, a % b);
    }
}