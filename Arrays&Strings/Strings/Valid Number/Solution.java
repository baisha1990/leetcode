/* Given a string s, return whether s is a valid number.
For example, all the following are valid numbers: "2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789", while the following are not valid numbers: "abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53".

Formally, a valid number is defined using one of the following definitions:

An integer number followed by an optional exponent.
A decimal number followed by an optional exponent.
An integer number is defined with an optional sign '-' or '+' followed by digits.

A decimal number is defined with an optional sign '-' or '+' followed by one of the following definitions:

Digits followed by a dot '.'.
Digits followed by a dot '.' followed by digits.
A dot '.' followed by digits.
An exponent is defined with an exponent notation 'e' or 'E' followed by an integer number.

The digits are defined as one or more digits.

Example 1:
Input: s = "0"
Output: true
*/

class Solution {
    public boolean isNumber(String s) {
        int exponentPlace = s.indexOf('e');
        if(exponentPlace == -1) {
            exponentPlace = s.indexOf('E');
        }
        int lastIndexOfFirstPart = exponentPlace == -1 ? s.length() - 1 : exponentPlace - 1;
        boolean isFirstPartValid = validInteger(s, 0, lastIndexOfFirstPart) || validDecimal(s, 0, lastIndexOfFirstPart);
        boolean isSecondPartValid = exponentPlace == -1 || validInteger(s, exponentPlace + 1, s.length() - 1);
        
        return isFirstPartValid && isSecondPartValid;
    }

    boolean validDecimal(String s, int start, int end) {
        if(start > end) {
            return false;
        }
        if(s.charAt(start) == '+' || s.charAt(start) == '-') {
            start++;
        }
        int dotIndex = s.indexOf('.');
        if(dotIndex == -1) {
            return false;
        }

        boolean atLeastOneSetOfDigits = false;
        if(dotIndex > start) {
            if(!validDigits(s, start, dotIndex - 1)) {
                return false;
            }
            atLeastOneSetOfDigits = true;
        }
        
        if(dotIndex < end) {
            if(!validDigits(s, dotIndex + 1, end)) {
                return false;
            }
            atLeastOneSetOfDigits = true;
        }
        return atLeastOneSetOfDigits;
    }
    boolean validInteger(String s, int start, int end) {
        if(start > end) {
            return false;
        }
        if(s.charAt(start) == '+' || s.charAt(start) == '-') {
            start++;
        }
        if(start > end) {
            return false;
        }
        return validDigits(s, start, end);
    }

    boolean validDigits(String s, int start, int end) {
        if(start > end) {
            return false;
        }
        for(int i = start; i <= end; i++) {
            if(!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}