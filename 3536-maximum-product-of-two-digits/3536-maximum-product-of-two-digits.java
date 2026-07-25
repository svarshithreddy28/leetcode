class Solution {
    public int maxProduct(int n) {
        int ans=1;
        int f=0;
        int s=0;
        while(n>0)
        {
            int k=n%10;
            if(k>f)
            {
                s=f;
                f=k;
            }
            else if(k>s)
            {
                s=k;
            }
            n=n/10;
        }
        return f*s;
    }
}