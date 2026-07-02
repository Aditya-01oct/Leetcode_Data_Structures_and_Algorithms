class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m= grid.size();
        int n= grid.get(0).size();
        int[][] dist= new int[m][n];
         for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = grid.get(0).get(0);
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        PriorityQueue<int[]> pq = new PriorityQueue<>(
        Comparator.comparingInt(a -> a[0]));

        pq.add(new int[]{dist[0][0], 0, 0});

        while (!pq.isEmpty()) {

            int[] current = pq.poll();
            int cost = current[0];
            int x    = current[1];
            int y    = current[2];

            if(dist[x][y]<cost){
                continue;
            }
            if(x==m-1&&y==n-1){
                return cost < health;
            }
            for (int[] dir : dirs){
                int nx= x+dir[0];
                int ny = y+ dir[1];
                if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
                    continue;
                }
                int newcost= cost+ grid.get(nx).get(ny);
                if (dist[nx][ny]> newcost){
                    dist[nx][ny]= newcost;
                    pq.add(new int[]{dist[nx][ny], nx, ny});
                }
               
            }
        }
        return false;
    }
}
