class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        ArrayDeque<Integer> dq=new ArrayDeque<>();
        int[] ans=new int[n-k+1];
        for(int i=0;i<n;i++)
        {
            if(dq.size()>0 && dq.getFirst()<=i-k)
            {
                dq.pollFirst();
            }
            while(dq.size()>0 && nums[dq.getLast()]<=nums[i])
            {
                dq.pollLast();
            }
            dq.offerLast(i);
            if(i>=k-1)
            {
                ans[i-k+1]=nums[dq.getFirst()];
            }
        }
        return ans;
    }
}