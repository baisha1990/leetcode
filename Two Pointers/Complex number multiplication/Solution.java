/*Given two strings representing two complex numbers.

You need to return a string representing their multiplication. Note i2 = -1 according to the definition.

Example 1:
Input: "1+1i", "1+1i"
Output: "0+2i"
Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
Example 2:
Input: "1+-1i", "1+-1i"
Output: "0+-2i"
Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
Note:

The input strings will not have extra blank.
The input strings will be given in the form of a+bi, where the integer a and b will both belong to the range of [-100, 100]. And the output should be also in this form.
*/

class Solution {
    public String complexNumberMultiply(String a, String b) {
        String[] aa = a.split("\\+");
        String[] bb = b.split("\\+");
        int af = Integer.parseInt(aa[0]);
        int as = Integer.parseInt(aa[1].replaceAll("[a-z]", ""));
        int bf = Integer.parseInt(bb[0]);
        int bs = Integer.parseInt(bb[1].replaceAll("[a-z]", ""));
        int p1 = -(as*bs) + (af*bf);
        int p2 = (as*bf) + (af*bs);
        String s = Integer.toString(p1) + '+' + Integer.toString(p2) + 'i';
        
        return s;
    }
}