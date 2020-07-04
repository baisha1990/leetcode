/*Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 

Example:

Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
Note:  

1 is typically treated as an ugly number.
n does not exceed 1690.*/

class Solution {
    public int nthUglyNumber(int n) {
        if(n <= 0)
            return 0;
        List<Integer> l = new ArrayList<>();
        l.add(1);
        int i = 0, j = 0, k = 0;
        while(l.size() < n) {
            int m2 = l.get(i) * 2, m3 = l.get(j) * 3, m5 = l.get(k) * 5;
            int min = Math.min(m2, Math.min(m3, m5));
            l.add(min);
            if(min == m2)
                i++;
            if(min == m3)
                j++;
            if(min == m5)
                k++;
        }
        return l.get(l.size() - 1);
    }
    
}