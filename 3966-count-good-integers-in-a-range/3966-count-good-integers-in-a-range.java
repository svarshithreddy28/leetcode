class Solution {
    public long rec(int i,int prev,int tg,int st,String s,long[][][][] dp,int k)
    {
        if(i==s.length())
        {
            return 1;
        }
        if(prev!=-1 && dp[i][prev][tg][st]!=-1)
        {
            return dp[i][prev][tg][st];
        }
        int lim=tg==1?s.charAt(i)-'0':9;
        long ans=0;
        for(int d=0;d<=lim;d++)
        {
            if(prev==-1 && d==0)
            {
                ans+=rec(i+1,-1,tg==1&&d==lim?1:0,0,s,dp,k);
            }
            else if(prev==-1 || Math.abs(d-prev)<=k)
            {
                ans+=rec(i+1,d,tg==1&&d==lim?1:0,1,s,dp,k);
            }
        }
        if(prev!=-1)
        {
            dp[i][prev][tg][st]=ans;
        }
        return ans;
    }
    public long solve(long n,int k)
    {
        String s=Long.toString(n);
        long[][][][] dp=new long[16][10][2][2];
        for(long[][][] a:dp)
        {
            for(long[][] b:a)
            {
                for(long[] c:b)
                {
                    Arrays.fill(c,-1);
                }
            }
        }
        return rec(0,-1,1,0,s,dp,k);
    }
    public long goodIntegers(long l, long r, int k) {
        long li=solve(l-1,k);
        long ri=solve(r,k);
        return ri-li;
    }
}