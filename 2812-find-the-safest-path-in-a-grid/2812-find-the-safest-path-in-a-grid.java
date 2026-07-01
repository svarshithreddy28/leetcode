class Solution {
    int[][] dir={{0,1},{-1,0},{0,-1},{1,0}};
    public  boolean canreach(int[][] dis,int mid)
    {
        int n=dis.length;
        Queue<int[]> q=new LinkedList();
        q.offer(new int[]{0,0});
        boolean[][] vis=new boolean[n][n];
        if(dis[0][0]<mid)
        {
            return false;
        }
        vis[0][0]=true;
        while(q.size()>0)
        {
            int[] rem=q.poll();
            int r=rem[0];
            int c=rem[1];
            if(r==n-1 && c==n-1)
            {
                return true;
            }
            for(int i=0;i<4;i++)
            {
                int nr=r+dir[i][0];
                int nc=c+dir[i][1];
                if(nr>=0 && nc>=0 && nr<n && nc<n && !vis[nr][nc] && dis[nr][nc]>=mid)
                {
                    vis[nr][nc]=true;
                    q.offer(new int[]{nr,nc});
                }
            }
        }
        return false;
    }
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int ans=0;
        int n=grid.size();
        int[][] dis=new int[n][n];
        boolean[][] vis=new boolean[n][n];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(dis[i],Integer.MAX_VALUE);
        }
        Queue<int[]> q=new LinkedList();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid.get(i).get(j)==1)
                {
                    q.offer(new int[]{i,j});
                    dis[i][j]=0;
                }
            }
        }
        while(q.size()>0)
        {
            int[] rem=q.poll();
            int r=rem[0];
            int c=rem[1];
            for(int p=0;p<4;p++)
            {
                int nr=r+dir[p][0];
                int nc=c+dir[p][1];
                if(nr>=0 && nc>=0 && nr<n && nc<n && !vis[nr][nc] && dis[nr][nc]==Integer.MAX_VALUE)
                {
                    vis[nr][nc]=true;
                    dis[nr][nc]=1+dis[r][c];
                    q.offer(new int[]{nr,nc});
                }
            }
        }
        int lo=0;
        int hi=2*n;
        while(lo<=hi)
        {
            int mid=lo+(hi-lo)/2;
            if(canreach(dis,mid))
            {
                ans=mid;
                lo=mid+1;
            }
            else
            {
                hi=mid-1;
            }
        }
        return ans;
    }
}