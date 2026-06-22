class Solution {
    public ArrayList<ArrayList<int[]>> construct(int n,int[][] edges)
    {
        ArrayList<ArrayList<int[]>> list=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            list.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++)
        {
            int u=edges[i][0];
            int v=edges[i][1];
            int w=edges[i][2];
            list.get(u).add(new int[]{v,w});
        }
        return list;
    }
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        ArrayList<ArrayList<int[]>> al=construct(n,edges);
        int[][] dist=new int[n][k+1];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        dist[0][1]=0;
        pq.offer(new int[]{0,0,1});
        while(pq.size()>0)
        {
            int[] cur=pq.poll();
            int d=cur[0];
            int node=cur[1];
            int run=cur[2];
            if(d!=dist[node][run])
            {
                continue;
            }
            for(int[] ngbr:al.get(node))
            {
                int v=ngbr[0];
                int w=ngbr[1];
                int nrun=(labels.charAt(v)==labels.charAt(node))?run+1:1;
                // System.out.println(nrun);
                if(nrun>k)
                {
                    continue;
                }
                if((d+w)<dist[v][nrun])
                {
                    dist[v][nrun]=d+w;
                    pq.offer(new int[]{dist[v][nrun],v,nrun});
                }
            }
        }
        long ans=Integer.MAX_VALUE;
        for(int i=0;i<=k;i++)
        {
            ans=Math.min(ans,dist[n-1][i]);
        }
        return ans==Integer.MAX_VALUE?-1:(int)ans;
    }
}