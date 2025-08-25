/* Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.

Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
*/

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        int l = nums1.length > nums2.length ? nums1.length : nums2.length;
        System.out.print("l is:" + l);
        if(nums1.length == l) {
            for(int i = 0; i < l; i++) {
                if(containsElement(nums2, nums1[i])) {
                    set.add(nums1[i]);
                }
            }
        } else {
            for(int i = 0; i < l; i++) {
                if(containsElement(nums1, nums2[i])) {
                    set.add(nums2[i]);
                }
            }
        }
        int[] res = new int[set.size()];
        int i = 0;
        for(int s : set) {
            res[i++] = s;
        }
        return res;
    }

    private boolean containsElement(int[] arr, int key) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == key) {
                return true;
            }
        }
        return false;
    }
}