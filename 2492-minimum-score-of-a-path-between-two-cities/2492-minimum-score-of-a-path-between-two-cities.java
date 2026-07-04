class Solution {
    public void union(int u,int v,int[] rank,int[] par)
    {
        int px=find(u,par);
        int py=find(v,par);
        if(px==py)
        {
            return;
        }
        if(rank[px]>rank[py])
        {
            par[py]=px;
            rank[px]+=rank[py];
        }
        else if(rank[px]<rank[py])
        {
            par[px]=py;
            rank[py]+=rank[px];
        }
        else
        {
            par[py]=px;
            rank[px]+=rank[py];
        }
    }
    public int find(int x,int[] par)
    {
        if(par[x]==x)
        {
            return x;
        }
        int temp=find(par[x],par);
        par[x]=temp;
        return temp;
    }
    public int minScore(int n, int[][] roads) {
        int[] par=new int[n+1];
        int[] rank=new int[n+1];
        int ans=Integer.MAX_VALUE;
        Arrays.fill(rank,1);
        for(int i=0;i<=n;i++)
        {
            par[i]=i;
        }
        for(int i=0;i<roads.length;i++)
        {
            int u=roads[i][0];
            int v=roads[i][1];
            union(u,v,rank,par);
        }
        int ones_root=find(1,par);
        for(int i=0;i<roads.length;i++)
        {
            if(ones_root==find(roads[i][0],par))
            {
                ans=Math.min(ans,roads[i][2]);
            }
        }
        return ans;
    }
}