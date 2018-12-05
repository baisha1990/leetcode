/*Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.

You may return any answer array that satisfies this condition.

 

Example 1:

Input: [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
*/

class Solution {
    public int[] sortArrayByParity(int[] A) {
        int begin = 0;
		int end = A.length-1;
		int[] newA = new int[A.length];
		
		for(int i = 0; i < A.length; i++) {
			if(A[i]%2 == 0)
				newA[begin++] = A[i];
			else
				newA[end--] = A[i];
		}
		return newA;
    }
}

/*In place sorting*/
class Solution {
    public int[] sortArrayByParity(int[] A) {
		for(int i = 0, j = 0; i < A.length; i++) {
			if(A[i] % 2 == 0) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				j++;
			}
		}
		return A;
	}
}