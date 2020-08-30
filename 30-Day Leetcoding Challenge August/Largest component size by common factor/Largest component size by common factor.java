/*Given a non-empty array of unique positive integers A, consider the following graph:

There are A.length nodes, labelled A[0] to A[A.length - 1];
There is an edge between A[i] and A[j] if and only if A[i] and A[j] share a common factor greater than 1.
Return the size of the largest connected component in the graph.


Example 1:

Input: [4,6,15,35]
Output: 4

Example 2:

Input: [20,50,9,63]
Output: 2

Example 3:

Input: [2,3,6,7,4,12,21,39]
Output: 8

Note:

1 <= A.length <= 20000
1 <= A[i] <= 100000*/

class Solution {
    public int largestComponentSize(int[] A) {
       UnionFind uf = new UnionFind(A.length);
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i = 0; i < A.length; i++) {
            map.put(i, factorSet(A[i]));
        }
        Map<Integer, Set<Integer>> rmap = new HashMap<>();
        for(Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            int i = entry.getKey();
            Set<Integer> set = entry.getValue();
            for(int factor : set) {
                Set<Integer> indexSet = rmap.get(factor);
                if(null == indexSet) {
                    indexSet = new HashSet<>();
                    rmap.put(factor, indexSet);
                }
                indexSet.add(i);
            }
        }
        for(Map.Entry<Integer, Set<Integer>> entry : rmap.entrySet()) {
            Set<Integer> set = entry.getValue();
            int v = -1;
            for(int i : set) {
                v = i;
                break;                
            }
            for(int i : set)
                uf.union(i,v);
        }
    
        Map<Integer, Integer> idCount = new HashMap<>();
        for(int i = 0; i < A.length; i++) {
            int id = uf.root(i);
            int count = idCount.getOrDefault(id, 0);
            idCount.put(id, count+1);
        }
        int max = 0;
        for(int v : idCount.values()) {
            max = Math.max(max,v);
        }
        return max;
    }
    public Set<Integer> factorSet(int a) {
        Set<Integer> set = new HashSet<>();
        set.add(a);
        int upper = (int)Math.sqrt(a);
        for(int i = 2; i <= upper && i <= a; i++) {
            while(a%i == 0) {
                set.add(i);
                a /= i;
                if(a != 1)
                    set.add(a);
            }
        }
        return set;
    }
    
    static class UnionFind {
        private int[] ids;
        private int[] size;
        public UnionFind(int n) {
            this.ids = new int[n];
            this.size = new int[n];
            for(int i = 0; i < n; i++) {
                this.ids[i] = i;
                this.size[i] = 1;
            }
        }
        public int root(int i) {
            int node = i;
            while(ids[i] != i) {
                ids[i] = ids[ids[i]];
                i = ids[i];
            }
            return i;
        }
        public void union(int i, int j) {
            int rooti = root(i);
            int rootj = root(j);
            if(size[j] < size[i]) {
                ids[rootj] = rooti;
                size[i] += size[j];
            }
            else {
                ids[rooti] = rootj;
                size[j] += size[i];
            }
        }
        public boolean find(int i, int j) {
            return root(i) == root(j);
        }
    }
}