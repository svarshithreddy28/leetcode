class Solution {
    public int largestInteger(int[] nums, int k) {
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            max=Math.max(max,nums[i]);
        }
        int[] arr=new int[max+1];
        if(k==n)
        {
            return max;
        }
        for(int i=0;i<n;i++)
        {
            arr[nums[i]]++;
        }
        if(k==1)
        {
            for(int i=max;i>=0;i--)
            {
                if(arr[i]==1)
                {
                    return i;
                }
            }
            return -1;
        }
        if(arr[nums[0]]==1 && arr[nums[n-1]]==1)
        {
            return Math.max(nums[0],nums[n-1]);
        }
        else if(arr[nums[0]]==1 && arr[nums[n-1]]>1)
        {
            return nums[0];
        }
        else if(arr[nums[0]]>1 && arr[nums[n-1]]==1)
        {
            return nums[n-1];
        }
        return -1;
    }
}