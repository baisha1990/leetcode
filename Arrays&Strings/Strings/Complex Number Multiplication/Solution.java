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
The input strings will be given in the form of a+bi, where the integer a and b will both belong to the range of [-100, 100]. And the output should be also in this form.*/

class Solution {
    public String complexNumberMultiply(String a, String b) {
        //Get a1, a2, b1, b2
        String[] aarr1 = a.split("\\+");
        String[] aarr2 = b.split("\\+");
        
        int a1 = Integer.parseInt(aarr1[0]);
        String atemp1 = aarr1[1].replace("i", "");
        int b1 = Integer.parseInt(atemp1);
        int a2 = Integer.parseInt(aarr2[0]);
        String atemp2 = aarr2[1].replace("i", "");
        int b2 = Integer.parseInt(atemp2);
        
        int inte = ((a1*a2) - (b1*b2));
        int real = ((a1*b2) + (a2*b1));
        
        StringBuilder sb = new StringBuilder(Integer.toString(inte));
        sb.append("+");
        sb.append(Integer.toString(real));
        sb.append("i");
        return sb.toString();
    }
}
