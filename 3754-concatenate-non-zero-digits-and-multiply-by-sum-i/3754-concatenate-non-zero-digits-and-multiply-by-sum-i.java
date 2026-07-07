class Solution {
    public long sumAndMultiply(int n) {
        if(n==0)
        {
            return 0;
        }
        long sum=0;
        StringBuilder sb=new StringBuilder();
        while(n>0)
        {
            int d=n%10;
            if(d>0)
            {
                sb.append(d);
            }
            sum+=d;
            n=n/10;
        }
        String k=sb.reverse().toString();
        return Integer.parseInt(k)*sum;
    }
}