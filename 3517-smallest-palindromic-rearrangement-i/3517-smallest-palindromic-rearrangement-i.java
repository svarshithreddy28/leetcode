class Solution {
    public String smallestPalindrome(String s) {
        int n=s.length();
        StringBuilder sb=new StringBuilder();
        StringBuilder sb1=new StringBuilder();
        int[] count=new int[26];
        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            count[ch-'a']++;
        }
        for(int i=0;i<26;i++)
        {
            int k=count[i]/2;
            int isodd=count[i]%2;
            sb.repeat((char)('a'+i),k);
            if(isodd==1)
            {
                sb1.append((char)('a'+i));
            }
        }
        return sb.toString()+sb1.toString()+sb.reverse().toString();
    }
}