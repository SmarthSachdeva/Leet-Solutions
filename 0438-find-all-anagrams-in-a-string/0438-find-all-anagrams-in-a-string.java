class Solution {
    static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())return false;
       int alphabet[]=new int[26];
       for(int i=0;i<s.length();i++){
           alphabet[s.charAt(i)-'a']++;
           alphabet[t.charAt(i)-'a']--;
       }
    //   for(int i=0;i<t.length();i++){
    //        alphabet[t.charAt(i)-'a']--;
    //    }
       for(int i:alphabet){
           if(i!=0)return false;
       }
      return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer>list=new ArrayList<>();
        int len=p.length();
    
	  for(int i=0;i<=s.length()-len;i++){
	      String m=s.substring(i,i+len);
	     if(isAnagram(m,p)){
              list.add(i);
         }
	  }
        return list;
}
}