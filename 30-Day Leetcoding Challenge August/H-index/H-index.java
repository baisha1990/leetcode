/*Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

Example:

Input: citations = [3,0,6,1,5]
Output: 3 
Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had 
             received 3, 0, 6, 1, 5 citations respectively. 
             Since the researcher has 3 papers with at least 3 citations each and the remaining 
             two with no more than 3 citations each, her h-index is 3.
Note: If there are several possible values for h, the maximum one is taken as the h-index.*/

class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0)
            return 0;
        int l = citations.length;
        int[] temp = new int[l+1];
        for(int i = 0; i < l; i++) {
            if(citations[i] <= l) {
               temp[citations[i]]++;
            } else {
                temp[l]++;
            }
        }
        int n = 0;
        for(int i = l; i >= 0; i--) {
            n += temp[i];
            if(n >= i)
                return i;
        }
        return -1;
    }
}