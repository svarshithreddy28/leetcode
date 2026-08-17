class Solution {
    public int rec(int l,int r,int[] pre,int[][] dp)
    {
        if(l>=r)
        {
            return 0;
        }
        if(dp[l][r]!=-1)
        {
            return dp[l][r];
        }
        int ans=0;
        for(int k=l;k<r;k++)
        {
            int lsum=pre[k+1]-pre[l];
            int rsum=pre[r+1]-pre[k+1];
            if(lsum<rsum)
            {
                ans=Math.max(ans,lsum+rec(l,k,pre,dp));
            }
            else if(lsum>rsum)
            {
                ans=Math.max(ans,rsum+rec(k+1,r,pre,dp));
            }
            else
            {
                ans=Math.max(ans,lsum+Math.max(rec(l,k,pre,dp),rec(k+1,r,pre,dp)));
            }
        }
        return dp[l][r]=ans;
    }
    public int stoneGameV(int[] stoneValue) {
        int n=stoneValue.length;
        int[] pre=new int[n+1];
        int[][] dp=new int[n+1][n+1];
        for(int i=0;i<n;i++)
        {
            pre[i+1]=pre[i]+stoneValue[i];
        }
        for(int i=0;i<=n;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        return rec(0,n-1,pre,dp);
    }
}