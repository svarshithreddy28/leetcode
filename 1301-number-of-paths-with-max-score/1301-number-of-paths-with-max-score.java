class Solution {
    int mod=1000_000_007;
    public int[] rec(List<String> board,int i,int j,int n,int m,int[][][] dp)
    {
        if(i==0 && j==0)
        {
            return new int[]{0,1};
        }
        if(i<0 || i>=n || j<0 || j>=m || board.get(i).charAt(j)=='X')
        {
            return new int[]{Integer.MIN_VALUE,0};
        }
        if(dp[i][j][0]!=-1 && dp[i][j][1]!=-1)
        {
            return new int[]{dp[i][j][0],dp[i][j][1]};
        }
        int cnt=0,no=0;
        if(board.get(i).charAt(j)!='S')
        {
            no=board.get(i).charAt(j)-'0';
        }
        int[] x=rec(board,i-1,j,n,m,dp);
        int[] y=rec(board,i,j-1,n,m,dp);
        int[] z=rec(board,i-1,j-1,n,m,dp);
        int a=Math.max(x[0],Math.max(y[0],z[0]))%mod;
        if(a==x[0])
        {
            cnt+=x[1];
        }
        if(a==y[0])
        {
            cnt+=y[1];
        }
        if(a==z[0])
        {
            cnt+=z[1];
        }
        int[] ans=new int[]{(a+no)%mod,cnt%mod};
        dp[i][j]=new int[]{ans[0],ans[1]};
        return ans;
    }
    public int[] pathsWithMaxScore(List<String> board) {
        int n=board.size();
        int[][][] dp=new int[n][n][2];
        for(int[][] arr:dp)
        {
            for(int[] ar1:arr)
            {
                Arrays.fill(ar1,-1);
            }
        }
        int[] max=rec(board,n-1,n-1,n,n,dp);
        if(max[0]<0)
        {
            return new int[]{0,0};
        }
        return new int[]{max[0]%mod,max[1]%mod};
    }
}