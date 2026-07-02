class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) 
    {
        int m=grid.size();
        int n=grid.get(0).size();
        int[][] dir={{0,-1},{-1,0},{0,1},{1,0}};
        int[][] dis=new int[m][n];
        for(int[] r:dis)
        {
            Arrays.fill(r,Integer.MAX_VALUE);
        }
        Deque<int[]> q=new ArrayDeque<>();
        q.offerFirst(new int[]{0,0});
        dis[0][0]=grid.get(0).get(0);
        while(q.size()>0)
        {
            int[] rem=q.pollFirst();
            int r=rem[0];
            int c=rem[1];
            if(r==m-1 && c==n-1)
            {
                return true;
            }
            for(int i=0;i<4;i++)
            {
                int nr=r+dir[i][0];
                int nc=c+dir[i][1];
                if(nr<0 || nc<0 || nr>=m || nc>=n)
                {
                    continue;
                }
                int cost=dis[r][c]+grid.get(nr).get(nc);
                if(cost>=health)
                {
                    continue;
                }
                if(cost<dis[nr][nc])
                {
                    dis[nr][nc]=cost;
                    if(grid.get(nr).get(nc)==0)
                    {
                        q.offerFirst(new int[]{nr,nc});
                    }
                    else
                    {
                        q.offerLast(new int[]{nr,nc});
                    }
                }
            }
        }
        return false;
    }
}