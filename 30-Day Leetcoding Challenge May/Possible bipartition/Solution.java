/*Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.

Each person may dislike some other people, and they should not go into the same group. 

Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.

Return true if and only if it is possible to split everyone into two groups in this way.

 

Example 1:

Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
Output: true
Explanation: group1 [1,4], group2 [2,3]
Example 2:

Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
Output: false
Example 3:

Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
Output: false
 

Constraints:

1 <= N <= 2000
0 <= dislikes.length <= 10000
dislikes[i].length == 2
1 <= dislikes[i][j] <= N
dislikes[i][0] < dislikes[i][1]
There does not exist i != j for which dislikes[i] == dislikes[j].*/

class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        List<Integer>[] graph = new ArrayList[N];
        for(int i = 0; i < N; i++)
            graph[i] = new ArrayList<>();
        for(int[] d : dislikes) {
            int u = d[0] - 1;
            int v = d[1] - 1;
            
            graph[u].add(v);
            graph[v].add(u);
        }
        
        int[] colors = new int[N];
        
        for(int i = 0; i < N; i++) {
            if(colors[i] != 0)
                continue;
            colors[i] = 1;
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            while(!q.isEmpty()) {
                int node = q.remove();
                for(int neigh : graph[node]) {
                    if(colors[neigh] == colors[node])
                        return false;
                    
                    if(colors[neigh] == 0) {
                        colors[neigh] = -colors[node];
                        q.add(neigh);
                    }
                }
            }
        }
        return true;
    }
}