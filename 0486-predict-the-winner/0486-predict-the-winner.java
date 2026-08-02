class Solution {
    public boolean rec(int i,int j,int[] nums,int chance,int score1,int score2)
    {
        if(i>j)
        {
            return score1>=score2;
        }
        if((chance & 1)==0)
        {
            boolean a=rec(i+1,j,nums,chance^1,score1+nums[i],score2);
            boolean b=rec(i,j-1,nums,chance^1,score1+nums[j],score2);
            return a || b;
        }
        else
        {
            boolean c=rec(i+1,j,nums,chance^1,score1,score2+nums[i]);
            boolean d=rec(i,j-1,nums,chance^1,score1,score2+nums[j]);
            return c && d;
        }
    }
    public boolean predictTheWinner(int[] nums) {
        int n=nums.length;
        return rec(0,n-1,nums,0,0,0);
    }
}