class Solution {
    int mod=1000_000_007;
    public int rec(int i,int j,int k,String word1,String word2,String target,int t1,int t2,int[][][][][] dp)
    {
        if(k==target.length())
        {
            if(t1!=0 && t2!=0)
            {
                return 1;
            }
            return 0;
        }
        if(dp[i][j][k][t1][t2]!=-1)
        {
            return dp[i][j][k][t1][t2];
        }
        long ways=0;
        int tar=target.charAt(k);
        for(int ni=i;ni<word1.length();ni++)
        {
            if(word1.charAt(ni)==tar)
            {
                ways+=rec(ni+1,j,k+1,word1,word2,target,1,t2,dp);
            }
        }
        for(int nj=j;nj<word2.length();nj++)
        {
            if(word2.charAt(nj)==tar)
            {
                ways+=rec(i,nj+1,k+1,word1,word2,target,t1,1,dp);
            }
        }
        return dp[i][j][k][t1][t2]=(int)(ways%mod);
    }
    public int interleaveCharacters(String word1, String word2, String target) {
        int[][][][][] dp=new int[word1.length()+1][word2.length()+1][target.length()+1][2][2];
        for(int[][][][] a:dp)
        {
            for(int[][][] b:a)
            {
                for(int[][] c:b)
                {
                    for(int[] d:c)
                    {
                        Arrays.fill(d,-1);
                    }
                }
            }
        }
        return rec(0,0,0,word1,word2,target,0,0,dp);
    }
}