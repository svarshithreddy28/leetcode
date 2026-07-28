class Solution {
    public String smallestPalindrome(String s) {
        int[] arr=new int[26];
        for(char ch:s.toCharArray())
        {
            arr[ch-'a']++;
        }
        StringBuilder firsthalf=new StringBuilder();
        String middle="";
        for(int i=0;i<26;i++)
        {
            if(arr[i]%2==1)
            {
                middle=String.valueOf((char)(i+'a'));
            }
           for(int j=0;j<arr[i]/2;j++)
           {
               firsthalf.append((char)(i+'a'));
           }
        }
        return firsthalf.toString()+middle+firsthalf.reverse().toString();
    }
}