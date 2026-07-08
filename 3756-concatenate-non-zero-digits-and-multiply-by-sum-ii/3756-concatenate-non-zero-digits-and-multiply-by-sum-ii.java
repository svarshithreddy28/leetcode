class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n=s.length();
        int mod=1000_000_007;
        int m=queries.length;
        int[] pow=new int[n+1];
        pow[0]=1;
        int[] sum=new int[n+1];
        int[] digits=new int[n+1];
        int[] len=new int[n+1];
        int[] ans=new int[m];
        for(int i=1;i<=n;i++)
        {
            pow[i]=(int)((1L*pow[i-1]*10)%mod);
        }
        for(int i=0;i<n;i++)
        {
            int num=s.charAt(i)-'0';
            sum[i+1]=sum[i]+num;
            digits[i+1]=num>0?(int)((digits[i]*10L+num)%mod):digits[i];
            len[i+1]=len[i]+((num>0)?1:0);
        }
        for(int i=0;i<m;i++)
        {
            int l=queries[i][0];
            int r=queries[i][1]+1;
            long su=sum[r]-sum[l];
            int length=len[r]-len[l];
            long d=(1L*digits[l]*pow[length])%mod;
            long nd=(digits[r]-d+mod)%mod;
            ans[i]=(int)((1L*nd*su)%mod);
        }
        return ans;
    }
}