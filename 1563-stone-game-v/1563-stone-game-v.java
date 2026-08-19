class Solution {
    public int rec(int l,int r,int[] pre,int[][] dp)
    {
        if(l==r)
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
                ans=Math.max(ans,rsum+Math.max(rec(l,k,pre,dp),rec(k+1,r,pre,dp)));
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
        for(int l=n-1;l>=0;l--)
        {
            for(int r=l+1;r<n;r++)
            {
                int ans=0;
                for(int k=l;k<r;k++)
                {
                    int lsum=pre[k+1]-pre[l];
                    int rsum=pre[r+1]-pre[k+1];
                    if(lsum<rsum)
                    {
                        ans=Math.max(ans,lsum+dp[l][k]);
                    }
                    else if(lsum>rsum)
                    {
                        ans=Math.max(ans,rsum+dp[k+1][r]);
                    }
                    else
                    {
                        ans=Math.max(ans,rsum+Math.max(dp[l][k],dp[k+1][r]));
                    }
                }
                dp[l][r]=ans;
            }
        }
        return dp[0][n-1];
    }
}