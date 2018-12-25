/*Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Note:

Each element in the result must be unique.
The result can be in any order.
*/

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        Set<Integer> set = new HashSet<>();
        List<Integer> l = new ArrayList<>();
        
        for(int i = 0; i < l1; i++) 
            set.add(nums1[i]);
            for(int j = 0; j < l2; j++) {
                if(set.contains(nums2[j])) {
                    l.add(nums2[j]);
                    set.remove(nums2[j]);
                }
            }
        
        int[] a = new int[l.size()];
        for(int i = 0; i < l.size(); i++) {
            a[i] = l.get(i);
        }
        return a;
    }
}