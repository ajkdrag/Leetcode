/*
  Problem at : https://leetcode.com/problems/possible-bipartition/
*/

// Using DFS
class Solution {
    ArrayList<Integer>[] graph;
    Map<Integer, Integer> color;

    public boolean possibleBipartition(int N, int[][] dislikes) {
        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; ++i)
            graph[i] = new ArrayList();

        for (int[] edge: dislikes) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        color = new HashMap();
        for (int node = 1; node <= N; ++node)
            if (!color.containsKey(node) && !dfs(node, 0))
                return false;
        return true;
    }

    public boolean dfs(int node, int c) {
        if (color.containsKey(node))
            return color.get(node) == c;
        color.put(node, c);

        for (int nei: graph[node])
            if (!dfs(nei, c ^ 1))
                return false;
        return true;
    }
}

// using cycle lengths
class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[] parent = new int[N+1];
        for (int[] d : dislikes){
            if (parent[d[1]] == 0)
                parent[d[1]] = d[0]; 
            else {
                boolean c0 = false;
                int a = d[0];               
                while(parent[a] != 0){      
                    a = parent[a];          
                    c0 = c0 ? false : true; 
                }
                boolean c1 = false;
                int b = d[1];               
                while(parent[b] != 0){
                    b = parent[b];
                    c1 = c1 ? false : true;
                }
                if (a == b && c0 == c1) return false; 
            }
        }
        return true;
    }
}
