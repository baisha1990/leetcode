/*
No-Zero integer is a positive integer that does not contain any 0 in its decimal representation.
Given an integer n, return a list of two integers [a, b] where:
a and b are No-Zero integers.
a + b = n
The test cases are generated so that there is at least one valid solution. If there are many valid solutions, you can return any of them.


Example 1:
Input: n = 2
Output: [1,1]
Explanation: Let a = 1 and b = 1.
Both a and b are no-zero integers, and a + b = 2 = n.
*/

class Solution {
    public int[] getNoZeroIntegers(int n) {
        for(int i = 1; i < n; i++) {
            int a = n - i;
            if(!String.valueOf(i).contains("0") && !String.valueOf(a).contains("0")) {
                return new int[] {i, a};
            }
        }
        return new int[0];
    }
}