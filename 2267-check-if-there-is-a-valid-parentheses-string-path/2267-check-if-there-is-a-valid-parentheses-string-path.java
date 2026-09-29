class Solution {
    public boolean rec(int i,int j,int bal,int m,int n,char[][] grid,Boolean[][][] dp)
    {
        if(i>=m || j>=n)
        {
            return false;
        }
        if(grid[i][j]=='(')
        {
            bal++;
        }
        else
        {
            bal--;
        }
        if(bal<0)
        {
            return false;
        }
        if(i==m-1 && j==n-1)
        {
            return dp[i][j][bal]=(bal==0);
        }
        if(dp[i][j][bal]!=null)
        {
            return dp[i][j][bal];
        }
        boolean down=rec(i+1,j,bal,m,n,grid,dp);
        boolean right=rec(i,j+1,bal,m,n,grid,dp);
        return dp[i][j][bal]=(down || right);
    }
    public boolean hasValidPath(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        if((m+n-1)%2!=0)
        {
            return false;
        }
        Boolean[][][] dp=new Boolean[m+1][n+1][201]; 
        if(grid[0][0] == ')' || grid[m-1][n-1]=='(')
        {
            return false;
        }
        return rec(0,0,0,m,n,grid,dp);
    }
}