class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int l=0,r=0,n=nums.length;
        HashMap<Integer,Integer> hm=new HashMap<>();
        int max=0;
        while(r<n)
        {
            if(!hm.containsKey(nums[r]))
            {
                hm.put(nums[r],0);
            }
            hm.put(nums[r],hm.get(nums[r])+1);
            while(hm.get(nums[r])>k)
            {
                hm.put(nums[l],hm.get(nums[l])-1);
                l++;
            }
            max=Math.max(max,r-l+1);
            r++;
        }
        return max;
    }
}