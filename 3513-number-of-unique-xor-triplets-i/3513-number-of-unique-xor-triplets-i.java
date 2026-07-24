class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n=nums.length;
        int k=1;
        while(n<=2)
        {
            return n;
        }
        while(k<=n)
        {
            k<<=1;
        }
        return k;
    }
}