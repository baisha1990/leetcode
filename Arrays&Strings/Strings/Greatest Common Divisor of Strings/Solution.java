/*For strings S and T, we say "T divides S" if and only if S = T + ... + T  (T concatenated with itself 1 or more times)

Return the largest string X such that X divides str1 and X divides str2.

 

Example 1:

Input: str1 = "ABCABC", str2 = "ABC"
Output: "ABC"
Example 2:

Input: str1 = "ABABAB", str2 = "ABAB"
Output: "AB"
Example 3:

Input: str1 = "LEET", str2 = "CODE"
Output: ""
 

Note:

1 <= str1.length <= 1000
1 <= str2.length <= 1000
str1[i] and str2[i] are English uppercase letters.*/

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1))
            return "";
        int l1 = str1.length(), l2 = str2.length();
        int g = gcd(l1, l2);
        if(l1 > l2)
            return str1.substring(0, g);
        else
            return str2.substring(0, g);
    }
    
    public int gcd(int a, int b) {
        while(a != b) {
            if(a > b)
                a = a - b;
            else
                b = b - a;
        }
        return b;
    }
}