class Solution {
    public long rec(int[][] grid,int m,int n,int i,int j,boolean[][] vis)
    {
        long sum=grid[i][j];
        vis[i][j]=true;
        int[][] dir={{0,-1},{0,1},{-1,0},{1,0}};
        for(int p=0;p<4;p++)
        {
            int r=i+dir[p][0];
            int c=j+dir[p][1];
            if(r>=0 && c>=0 && r<m && c<n && !vis[r][c] && grid[r][c]!=0)
            {
                sum+=rec(grid,m,n,r,c,vis);
            }
        }
        return sum;
    }
    public int countIslands(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        int ans=0;
        boolean[][] vis=new boolean[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]!=0 && !vis[i][j])
                {
                    long res=rec(grid,m,n,i,j,vis);
                    if(res%k==0)
                    {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}