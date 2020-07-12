/*Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]*/

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        	if (nums == null)
		return null;
 
	Arrays.sort(nums);
 
	List<List<Integer>> result = new ArrayList<>();
 
	for (int i = 0; i < nums.length; i++) {
		List<List<Integer>> temp = new ArrayList<>();
 
		for (List<Integer> a : result) {
			temp.add(new ArrayList<Integer>(a));
		}
 
		for (List<Integer> a : temp) {
			a.add(nums[i]);
		}
        
		List<Integer> single = new ArrayList<Integer>();
		single.add(nums[i]);
		temp.add(single);
 
		result.addAll(temp);
	}
 
	//add empty set
	result.add(new ArrayList<Integer>());
 
	return result;
    }
}