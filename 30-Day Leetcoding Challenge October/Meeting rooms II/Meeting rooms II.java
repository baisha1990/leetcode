/*Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

Example 1:

Input: [[0, 30],[5, 10],[15, 20]]
Output: 2
Example 2:

Input: [[7,10],[2,4]]
Output: 1
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.*/

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0)
            return 0;
        Arrays.sort(intervals, (a,b) -> (a[0] - b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int[] interval : intervals) {
            if(pq.size() > 0 && pq.peek() <= interval[0])
                pq.poll();
            pq.offer(interval[1]);
        }
        return pq.size();
    }
}