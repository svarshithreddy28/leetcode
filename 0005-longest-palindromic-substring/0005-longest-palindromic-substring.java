class Solution {
    public int[] manacher(String s)
    {
        int n=s.length();
        char[] arr=new char[2*n+1];
        int[] p=new int[2*n+1];
        int c=0,r=0;
        for(int i=0;i<n;i++)
        {
            arr[2*i+1]=s.charAt(i);
        }
        for(int i=0;i<n+n+1;i++)
        {
            if(i<r)
            {
                p[i]=Math.min(p[2*c-i],r-i);
            }
            while(i-p[i]-1>=0 && i+p[i]+1<2*n+1 && arr[i-p[i]-1]==arr[i+p[i]+1])
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
    public String longestPalindrome(String s) {
        int n=s.length();
        int[] p=manacher(s);
        int max=0;
        String ans="";
        for(int i=0;i<2*n+1;i++)
        {
            if(p[i]>max)
            {
                max=p[i];
                ans=s.substring((i-p[i])/2,(i+p[i])/2);
            }
        }
        return ans;
    }
}