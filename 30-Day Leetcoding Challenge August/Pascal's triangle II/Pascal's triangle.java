/*Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

Note that the row index starts from 0.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 3
Output: [1,3,3,1]
Follow up:

Could you optimize your algorithm to use only O(k) extra space?*/

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i <= rowIndex; i++) {
            l.add(0, 1);
            for(int j = 1; j < l.size() - 1; j++)
                l.set(j, l.get(j) + l.get(j+1));
        }
        return l;
    }
}