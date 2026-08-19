class Solution {
    public int maxNumberOfFamilies(int n, int[][] r) {
        int m=r.length;
        int ans=0;
        int left=0b11110000;
        int middle=0b11000011;
        int right=0b00001111;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<m;i++)
        {
            int row=r[i][0];
            int seat=r[i][1];
            if(seat>1 && seat<10)
            {
                int bm=hm.containsKey(row)?hm.get(row):0;
                int value=bm|(1<<(seat-2));
                hm.put(row,value);
            }
        }
        ans=(n-hm.size())*2;
        for(int key:hm.keySet())
        {
            int row=key;
            int bm=hm.get(row);
            if((bm|left)==left || (bm|right)==right || (bm | middle)==middle)
            {
                ++ans;
            }
        }
        return ans;
    }
}