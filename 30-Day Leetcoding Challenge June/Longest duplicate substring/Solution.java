/*Given a string S, consider all duplicated substrings: (contiguous) substrings of S that occur 2 or more times.  (The occurrences may overlap.)

Return any duplicated substring that has the longest possible length.  (If S does not have a duplicated substring, the answer is "".)

Example 1:

Input: "banana"
Output: "ana"
Example 2:

Input: "abcd"
Output: ""
 

Note:

2 <= S.length <= 10^5
S consists of lowercase English letters.*/

class Solution {
    public String longestDupSubstring(String S) {
        int n = S.length();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++)
            nums[i] = S.charAt(i) - 'a';
        int a = 26;
        long modulus = (long)Math.pow(2, 32);
        int l = 1, r = n, L;
        while(l != r) {
            L = l + (r - l) / 2;
            if(search(L, a, modulus, n, nums) != -1)
                l = L + 1;
            else
                r = L;
        }
        int start = search(l-1, a, modulus, n, nums);
        return start != -1 ? S.substring(start, start + l - 1) : "";
    }
    
    int search(int L, int a, long modulus, int n, int[] nums) {
        long h = 0;
        for(int i = 0; i < L; i++)
            h = (h * a + nums[i]) % modulus;
        HashSet<Long> seen = new HashSet<>();
        seen.add(h);
        long aL = 1;
        for(int i = 1; i <= L; i++)
            aL = (aL * a) % modulus;
        
        for(int start = 1; start < n - L + 1; start++) {
            h = (h * a - nums[start - 1] * aL % modulus + modulus) % modulus;
            h = (h + nums[start + L - 1]) % modulus;
            if(seen.contains(h))
                return start;
            seen.add(h);
        }
        return -1;
    }
}