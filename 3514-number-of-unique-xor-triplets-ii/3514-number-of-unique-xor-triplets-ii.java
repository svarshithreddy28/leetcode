class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n=nums.length;
        int max=0;
        int ans=0;
        for(int i=0;i<n;i++)
        {
            max=Math.max(max,nums[i]);
        }
        int v=1;
        while(v<=max)
        {
            v<<=1;
        }
        boolean[] bit1=new boolean[v];
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n;j++)
            {
                bit1[nums[i]^nums[j]]=true;
            }
        }
        boolean[] bit2=new boolean[v];
        for(int i=0;i<v;i++)
        {
            if(!bit1[i])
            {
                continue;
            }
            for(int k:nums)
            {
                bit2[i^k]=true;
            }
        }
        for(int i=0;i<v;i++)
        {
            if(bit2[i])
            {
                ans++;
            }
        }
        return ans;
    }
}