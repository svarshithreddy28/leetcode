class Solution {
    public int smallestNumber(int n, int t) {
       for(int i=n;i<n+10;i++)
       {
            int x=i;
            int ans=1;
            while(x>0)
            {
                int rem=x%10;
                ans*=rem;
                x=x/10;
            }
            if(ans%t==0)
            {
                return i;
            }
       }
        return n;
    }
}