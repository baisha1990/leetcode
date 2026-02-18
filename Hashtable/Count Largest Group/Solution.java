/*
You are given an integer n.
We need to group the numbers from 1 to n according to the sum of its digits. For example, the numbers 14 and 5 belong to the same group, whereas 13 and 3 belong to different groups.
Return the number of groups that have the largest size, i.e. the maximum number of elements.

Example 1:
Input: n = 13
Output: 4
Explanation: There are 9 groups in total, they are grouped according sum of its digits of numbers from 1 to 13:
[1,10], [2,11], [3,12], [4,13], [5], [6], [7], [8], [9].
There are 4 groups with largest size.

Example 2:
Input: n = 2
Output: 2
Explanation: There are 2 groups [1], [2] of size 1.

Constraints:
1 <= n <= 104
*/

class Solution {
    public int countLargestGroup(int n) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int maxNum = Integer.MIN_VALUE, count = 0;
        for(int i = 1; i <= n; i++) {
            int sumVal = sum(i);
            if(!map.containsKey(sumVal)) {
                map.put(sumVal, new ArrayList<>());
            }
            List<Integer> l = map.get(sumVal);
            l.add(i);
            map.put(sumVal, l);
        }
        for(List<Integer> l : map.values()) {
            maxNum = Math.max(maxNum, l.size());
        }
        for(List<Integer> l : map.values()){
            if(l.size() == maxNum) {
                count++;
            }
        }
        return count;
    }
    private int sum(int n) {
        int sum = 0;
        while(n > 0) {
            int digit = n % 10;
            sum += digit;
            n /= 10;
        }
        return sum;
    }
}