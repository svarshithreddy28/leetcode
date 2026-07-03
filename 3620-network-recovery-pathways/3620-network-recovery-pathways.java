class Solution {
    int l=Integer.MAX_VALUE,r=Integer.MIN_VALUE,n=0;
    public ArrayList<ArrayList<int[]>> construct(int[][] edges,boolean[] online,int n)
    {
        ArrayList<ArrayList<int[]>> list=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            list.add(new ArrayList<>());
        }
        for(int[] e:edges)
        {
            int u=e[0];
            int v=e[1];
            int w=e[2];
            
            if(!online[u] || !online[v])
            {
                continue;
            }
            l=Math.min(l,w);
            r=Math.max(r,w);
            list.get(u).add(new int[]{v,w});
        }
        return list;
    }
    public boolean check(ArrayList<ArrayList<int[]>> list,int mid,long k,int n)
    {
        long[] dis=new long[n];
        Arrays.fill(dis,Long.MAX_VALUE);
        PriorityQueue<long[]> pq=new PriorityQueue<>((a,b)->Long.compare(a[1],b[1]));
        pq.offer(new long[]{0,0});
        dis[0]=0;
        while(pq.size()>0)
        {
            long[] rem=pq.poll();
            int node=(int)rem[0];
            long d=rem[1];
            if(d>k)
            {
                return false;
            }
            if(node==n-1)
            {
                return true;
            }
            if(d>dis[node])
            {
                continue;
            }
            for(int[] ngbr:list.get(node))
            {
                int v=ngbr[0];
                int w=ngbr[1];
                if(w<mid)
                {
                    continue;
                }
                if(dis[node]+w<dis[v])
                {
                    dis[v]=w+dis[node];
                    pq.offer(new long[]{v,dis[v]});
                }
            }
        }
        return false;
    }
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        if(edges.length==0)
        {
            return -1;
        }
        int n=online.length;
        int ans=0;
        ArrayList<ArrayList<int[]>> list=construct(edges,online,n);
        if(!check(list,l,k,n))
        {
            return -1;
        }
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            if(check(list,mid,k,n))
            {
                ans=mid;
                l=mid+1;
            }
            else
            {
                r=mid-1;
            }
        }
        return ans;
    }
}