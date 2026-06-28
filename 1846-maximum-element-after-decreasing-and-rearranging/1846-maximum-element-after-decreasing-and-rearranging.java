class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n=arr.length;
        Arrays.sort(arr);
        arr[0]=1;
        int max=arr[0];
        for(int i=1;i<n;i++)
        {
            if(Math.abs(arr[i]-arr[i-1])>1)
            {
                arr[i]=arr[i-1]+1;
            }
            max=Math.max(max,arr[i]);
        }
        return max;
    }
}