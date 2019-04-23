/*
  Problem at : https://leetcode.com/problems/matrix-cells-in-distance-order/
*/

// Sort based solution (similar to counting sort)
class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        ArrayList<Integer>[] map = new ArrayList[R+C-1];
        for(int i = 0; i < R+C-1; ++i)
            map[i] = new ArrayList<Integer>();
        int[][] res = new int[R*C][2];
        for(int i = 0; i < R; ++i){
            for(int j = 0; j < C; ++j){
                int dist = Math.abs(i - r0) + Math.abs(j - c0);
                map[dist].add(i * C + j);
            }
        }
        
        int k = 0;
        for(int i = 0; i < R+C-1; ++i){
            for(int id : map[i]){
                res[k][0] = id/C;
                res[k][1] = id%C;
                 ++k;
            }
        }
        return res;
    }
}

// BFS based solution
public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
	boolean[][] visited = new boolean[R][C];
	int[][] result = new int[R * C][2];
	int i = 0;
	Queue < int[] > queue = new LinkedList < int[] > ();
	queue.offer(new int[] {
		r0,
		c0
	});
	while (!queue.isEmpty()) {
		int[] cell = queue.poll();
		int r = cell[0];
		int c = cell[1];

		if (r < 0 || r >= R || c < 0 || c >= C) {
			continue;
		}
		if (visited[r][c]) {
			continue;
		}

		result[i] = cell;
		i++;
		visited[r][c] = true;

		queue.offer(new int[] {r, c - 1});
		queue.offer(new int[] {r, c + 1});
		queue.offer(new int[] {r - 1, c});
		queue.offer(new int[] {r + 1, c});
	}
	return result;
}


