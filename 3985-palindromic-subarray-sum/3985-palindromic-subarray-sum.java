class Solution {
    public int[] manacher(int[] nums)
    {
        int n=nums.length;
        int[] s=new int[2*n+1];
        int[] p=new int[2*n+1];
        int c=0,r=0;
        for(int i=0;i<n;i++)
        {
            s[2*i+1]=nums[i];
        }
        for(int i=0;i<n+n+1;i++)
        {
            if(i<r)
            {
                p[i]=Math.min(p[2*c-i],r-i);
            }
            while(i-p[i]-1>=0 && i+p[i]+1<2*n+1 && s[i-p[i]-1]==s[i+p[i]+1])
            {
                p[i]++;
            }
            if(i+p[i]>r)
            {
                c=i;
                r=i+p[i];
            }
        }
        return p;
    }
    public long getSum(int[] nums) {
        int n=nums.length;
        long[] pre=new long[n+1];
        for(int i=0;i<n;i++)
        {
            pre[i+1]=pre[i]+nums[i];
        }
        int[] p=manacher(nums);
        long res=0;
        for(int i=0;i<n+n+1;i++)
        {
            long val=pre[(i+p[i])/2]-pre[(i-p[i])/2];
            res=Math.max(res,val);
        }
        return res;
    }
}