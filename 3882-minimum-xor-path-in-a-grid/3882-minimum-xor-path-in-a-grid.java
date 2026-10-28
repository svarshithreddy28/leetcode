class Solution {
    public int rec(int[][] grid,int m,int n,int i,int j,int xor,int[][][] dp)
    {
        if(i>=m || j>=n)
        {
            return Integer.MAX_VALUE;
        }
        if(i==m-1 && j==n-1)
        {
            return xor;
        }
        if(dp[i][j][xor]!=-1)
        {
            return dp[i][j][xor];
        }
        int x=Integer.MAX_VALUE;
        int y=Integer.MAX_VALUE;
        if(i+1<m)
        {
            x=rec(grid,m,n,i+1,j,xor^grid[i+1][j],dp);
        }
        if(j+1<n)
        {
            y=rec(grid,m,n,i,j+1,xor^grid[i][j+1],dp);
        }
        return dp[i][j][xor]=Math.min(x,y);
    }
    public int minCost(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][][] dp=new int[m][n][1024];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                Arrays.fill(dp[i][j],-1);
            }
        }
        return rec(grid,m,n,0,0,grid[0][0],dp);
    }
}