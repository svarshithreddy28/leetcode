class Solution {
    public int rec(int[] arr,int i,int n,int[] dp)
    {
        if(i>=n)
        {
            return 0;
        }
        if(dp[i]!=Integer.MIN_VALUE)
        {
            return dp[i];
        }
        int result=arr[i]-rec(arr,i+1,n,dp);
        if((i+1)<n)
        {
            result=Math.max(result,arr[i]+arr[i+1]-rec(arr,i+2,n,dp));
        }
        if((i+2)<n)
        {
            result=Math.max(result,arr[i]+arr[i+1]+arr[i+2]-rec(arr,i+3,n,dp));
        }
        return dp[i]=result;
    }
    public String stoneGameIII(int[] stoneValue) {
        int n=stoneValue.length;
        int[] dp=new int[n+1];
        Arrays.fill(dp,Integer.MIN_VALUE);
        int x=rec(stoneValue,0,n,dp);
        if(x>0) return "Alice";
        else if(x<0) return "Bob";
        else return "Tie";
    }
}