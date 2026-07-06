class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n=intervals.length;
        int ans=0;
        Arrays.sort(intervals,(a,b)->{
            if(a[1]==b[1])
            {
                return b[0]-a[0];
            }
            else
            {
                return a[1]-b[1];
            }
        });
        for(int i=0;i<n;i++)
        {
            int xi=intervals[i][0];
            int yi=intervals[i][1];
            boolean covered=false;
            for(int j=i+1;j<n;j++)
            {
                int x=intervals[j][0];
                int y=intervals[j][1];
                if(x<=xi && y>=yi)
                {
                    covered=true;
                    break;
                }
            }
            if(!covered)
            {
                ans++;
            }
        }
        return ans;
    }
}