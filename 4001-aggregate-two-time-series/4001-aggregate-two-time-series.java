class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
        TreeMap<Integer,Integer> tm1=new TreeMap<>();
        TreeMap<Integer,Integer> tm2=new TreeMap<>();
        int n=series1.length;
        int m=series2.length;
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            tm1.put(series1[i][0],series1[i][1]);
        }
        for(int i=0;i<m;i++)
        {
            tm2.put(series2[i][0],series2[i][1]);
        }
        for(int i=0;i<n;i++)
        {
            int key=series1[i][0];
            int s1=series1[i][1];
            Integer next=tm2.ceilingKey(key);
            int s=s1;
            if(next!=null)
            {
                s+=tm2.get(next);
            }
            ans.add(new ArrayList<>(Arrays.asList(key,s)));
        }
        for(int i=0;i<m;i++)
        {
            int key=series2[i][0];
            if(tm1.containsKey(key))
            {
                continue;
            }
            int s1=series2[i][1];
            Integer next=tm1.ceilingKey(key);
            int s=s1;
            if(next!=null)
            {
                s+=tm1.get(next);
            }
            ans.add(new ArrayList<>(Arrays.asList(key,s)));
        }
        ans.sort(Comparator.comparing(list->list.get(0)));
        return ans;
    }
}