/*Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.*/

class Solution {
    public String addStrings(String num1, String num2) {
        int l1 = num1.length()-1, l2 = num2.length()-1, carry = 0;
        StringBuilder sb = new StringBuilder();
		while(l1 >= 0 || l2 >= 0 || carry > 0) {
			int a = l1 >= 0 ? (num1.charAt(l1--) - '0') : 0;
			int b = l2 >= 0 ? (num2.charAt(l2--) - '0') : 0;
			int sum = (a + b + carry);			
			sb.insert(0, sum % 10);
            carry = (sum) / 10;
		}
		return sb.toString();
    }
}